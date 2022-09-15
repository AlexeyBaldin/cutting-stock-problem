package util;

import model.Dataset;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class Reader {

    public static final String DIRECTORY = "resources";

    private Reader() {}

    public static ArrayList<File> files = new ArrayList<>();

    static {
        try (Stream<Path> paths = Files.walk(Paths.get(DIRECTORY))) {
            paths.filter(Files::isRegularFile)
                    .forEach(path -> files.add(new File(path.toString())));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Dataset> getDatasets() {
        ArrayList<Dataset> datasets = new ArrayList<>();

        files.forEach(file -> {
            try {
                Scanner scanner = new Scanner(file);
                int length = scanner.nextInt();
                ArrayList<Integer> permutation = new ArrayList<>();
                while(scanner.hasNext()) {
                    permutation.add(scanner.nextInt());
                }
                datasets.add(new Dataset(length, permutation, file.toString()));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

        return datasets;
    }







}
