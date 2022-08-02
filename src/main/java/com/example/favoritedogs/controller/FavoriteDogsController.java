package com.example.favoritedogs.controller;

import com.example.favoritedogs.service.FavoriteDogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
public class FavoriteDogsController {

    @Autowired
    private FavoriteDogsService favoriteDogsService;

    @PostMapping(value="savefavorites")
    @CrossOrigin(origins = "*")
    public void saveFavoriteDogs(@RequestBody String[] favDogs) throws IOException {
        favoriteDogsService.saveFavoriteDogs(favDogs);
    }
    @GetMapping(value="favorites")
    @CrossOrigin(origins = "*")
    public String[] displayFavoriteDogs() throws FileNotFoundException {
        return favoriteDogsService.displayFavoriteDogs();
    }
}
