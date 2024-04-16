package com.diploma.dbtextile.controller;


import com.diploma.dbtextile.model.Textile;
import com.diploma.dbtextile.service.TextileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/textile")
public class TextileController {

    @Autowired
    private final TextileService textileService;


    public TextileController(TextileService textileService) {
        this.textileService = textileService;
    }

    @PostMapping("/addNew")
    public ResponseEntity<Textile> addTextile(@RequestBody Textile textile) {
        Textile newTextile = textileService.addTextile(textile);
        return ResponseEntity.ok(newTextile);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Textile>> getAllTextile() {
        List<Textile> textileList = textileService.getAllTextile();
        return ResponseEntity.ok(textileList);
    }

    @GetMapping("/{id}")
    public Optional<Textile> getTextileById(@PathVariable String id) {
        return textileService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Textile> updateTextile(@PathVariable String id, @RequestBody Textile textile) {
        Textile updatedTextile = textileService.updateTextile(id, textile);
        return ResponseEntity.ok(updatedTextile);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTextile(@PathVariable String id) {
        textileService.deletePattern(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/test")
    public ResponseEntity<Void> test() {
        return ResponseEntity.ok().build();
    }


}
