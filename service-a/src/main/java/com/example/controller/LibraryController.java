package com.example.controller;


import com.example.entity.Library;
import com.example.exception.ResourceNotFoundException;
import com.example.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping("/library/{id}")
    public ResponseEntity<Library> getLibraryById(@PathVariable Long id) {
        // Assuming some logic to fetch a library
        if (id <= 0) {
            throw new ResourceNotFoundException("Library not found with id: " + id);
        }
         Library library = libraryService.findLibraryById(id).orElseThrow(() -> new ResourceNotFoundException("Library not found with id: " + id));
        return ResponseEntity.ok().body(library);

    }


    
}