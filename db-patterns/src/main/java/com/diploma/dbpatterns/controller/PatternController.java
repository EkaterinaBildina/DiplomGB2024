package com.diploma.dbpatterns.controller;

import com.diploma.dbpatterns.model.Pattern;
import com.diploma.dbpatterns.repository.PatternRepository;
import com.diploma.dbpatterns.service.PatternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/patterns")
public class PatternController {

    @Autowired
    private PatternService patternService;

    @PostMapping("/addNew")
    public ResponseEntity<Pattern> addPattern(@RequestBody Pattern pattern) {
        Pattern newPattern = patternService.addPattern(pattern);
        return ResponseEntity.ok(newPattern);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Pattern>> getAllPatterns() {
        List<Pattern> patterns = patternService.getAllPatterns();
        return ResponseEntity.ok(patterns);
    }

    @GetMapping("/{id}")
    public Optional<Pattern> getPatternById(@PathVariable Long id) {
        return patternService.findById(id);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Pattern> updatePattern(@PathVariable Long id, @RequestBody Pattern pattern) {
        Pattern updatedPattern = patternService.updatePattern(id, pattern);
        return ResponseEntity.ok(updatedPattern);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePattern(@PathVariable Long id) {
        patternService.deletePattern(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/test")
    public ResponseEntity<Void> test() {
        return ResponseEntity.ok().build();
    }

}
