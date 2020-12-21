package lucassfelix.ilegra.prova;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;

public class App{

    private static final String HOMEPATH = "user.home";
    private static final String PATH_TO_INPUTS = "/data/in";
    private static final String PATH_TO_OUTPUTS = "/data/out";
    private static final String ALL_AFTER_DOT_REGEX = "[.].+$";
    private static final String EMPTY_STRING = "";


    public static void main(String[] args) throws IOException {

        Path workingDirectory = Paths.get(System.getProperty(HOMEPATH));

        Path pathToInputs = Paths.get(workingDirectory  + PATH_TO_INPUTS);
        Path pathToOutputs = Paths.get(workingDirectory + PATH_TO_OUTPUTS);

        System.out.println("HOMEPATH = " + System.getProperty(HOMEPATH));

        if(Files.notExists(pathToInputs))
        {
            Files.createDirectory(pathToOutputs);
        }

        if(Files.notExists(pathToOutputs))
        {
            Files.createDirectory(pathToOutputs);
        }

        FileReader fileReader = new FileReader();

        int checkedFiles = 0,iter = 0;

        while(true)
        {
            System.out.println(iter++);

            if(Files.list(pathToInputs).count() == checkedFiles)
                continue;

            Set<String> outputFilesSet = Files.list(pathToOutputs)
                    .map(path -> path.getFileName().toString().replaceFirst(ALL_AFTER_DOT_REGEX,EMPTY_STRING))
                    .collect(Collectors.toSet());

            Files.list(pathToInputs)
                            .filter(path -> !outputFilesSet.contains(path.getFileName().toString().replaceFirst("ALL_AFTER_DOT_REGEX","")))
                            .map(fileReader::readFile);

            break;
        }

    }

}
