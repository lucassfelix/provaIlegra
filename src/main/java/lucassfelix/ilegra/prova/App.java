package lucassfelix.ilegra.prova;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App{

    private static final String PATH_TO_INPUTS = "/data/in";
    private static final String PATH_TO_OUTPUTS = "/data/out";

    public static void main(String[] args) throws IOException {

        Path workingDirectory = Paths.get(System.getProperty("user.dir"));

        Path pathToInputs = Paths.get(workingDirectory  + PATH_TO_INPUTS);
        Path pathToOutputs = Paths.get(workingDirectory + PATH_TO_OUTPUTS);

        System.out.println("Working directory = " + System.getProperty("user.dir"));

        if(Files.notExists(pathToInputs))
        {
            throw new InputDirectoryDoesNotExist("Input directory does not exist or is not on the required path.");
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
                    .map(path -> path.getFileName().toString().replaceFirst("[.].+$",""))
                    .collect(Collectors.toSet());

            Files.list(pathToInputs)
                            .filter(path -> !outputFilesSet.contains(path.getFileName().toString().replaceFirst("[.].+$","")))
                            .forEach(path -> fileReader.ReadFile(path));

            break;
        }

    }

}
