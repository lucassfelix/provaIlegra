package lucassfelix.ilegra.prova;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    private static final String HOMEPATH = "user.home";
    private static final String PATH_TO_INPUTS = "/data/in";
    private static final String PATH_TO_OUTPUTS = "/data/out";
    private static final String ALL_AFTER_DOT_REGEX = "[.].+$";
    private static final String EMPTY_STRING = "";

    private static Path pathToOutputs;
    private static Path pathToInputs;

    public static void main(String[] args) throws IOException {

        Path workingDirectory = Paths.get(System.getProperty(HOMEPATH));

        pathToInputs = Paths.get(workingDirectory + PATH_TO_INPUTS);
        pathToOutputs = Paths.get(workingDirectory + PATH_TO_OUTPUTS);

        System.out.println("HOMEPATH = " + System.getProperty(HOMEPATH));

        if (Files.notExists(pathToInputs)) {
            Files.createDirectory(pathToOutputs);
        }

        if (Files.notExists(pathToOutputs)) {
            Files.createDirectory(pathToOutputs);
        }

        System.out.println("Starting search...");

        new Thread(searchMethod).start();
    }

    private static final Runnable searchMethod = new Runnable() {
        @Override
        public void run() {
            int checkedFiles = 0;

            while (true) {
                try {

                    try(Stream<Path> files = Files.list(pathToInputs))
                    {
                        if (files.count() == checkedFiles)
                            continue;
                    }

                    System.out.println("Found unchecked files.");

                    Set<String> outputFilesSet;

                    try(Stream<Path> outputFiles = Files.list(pathToOutputs))
                    {
                        outputFilesSet = outputFiles
                                .map(path -> path.getFileName().toString().replaceFirst(ALL_AFTER_DOT_REGEX, EMPTY_STRING))
                                .collect(Collectors.toSet());
                    }

                    try(Stream<Path> inputFiles = Files.list(pathToInputs))
                    {
                        inputFiles
                                .filter(path -> !outputFilesSet.contains(path.getFileName().toString().replaceFirst(ALL_AFTER_DOT_REGEX, "")))
                                .map(FileReader::readFile).filter(Objects::nonNull)
                                .forEach(dataFile -> dataFile.processFile(pathToOutputs));
                    }

                    try(Stream<Path> inputFiles = Files.list(pathToInputs))
                    {
                        checkedFiles = (int) inputFiles.count();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    };
}
