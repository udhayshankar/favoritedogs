package com.example.favoritedogs.service;

import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

@Service
public class FavoriteDogsService {

    public void saveFavoriteDogs(String[] favDogs) throws IOException {
        String filePath = "static/files/tmp/ok.txt";
        if (Files.notExists(Path.of(filePath))) {
            Path pathToFile = Paths.get(filePath);
            Files.createDirectories(pathToFile.getParent());
            Files.createFile(pathToFile);
        }
        try (
                FileWriter fw = new FileWriter(filePath, true);
                BufferedWriter writer = new BufferedWriter(fw);) {
            for(String val:favDogs) {
                writer.write(val);
                writer.write("\n\n");
            }
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }

    }
    public String[] displayFavoriteDogs() throws FileNotFoundException {
        ArrayList<String> favDogs = new ArrayList<>();
        Scanner s = new Scanner(new File("static/files/tmp/ok.txt"));
        while (s.hasNext()){
            favDogs.add(s.next());
        }
        s.close();
        return favDogs.toArray(String[]::new);
    }
}
