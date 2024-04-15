package com.diploma.dbpatterns.service;

import com.diploma.dbpatterns.model.Pattern;
import com.diploma.dbpatterns.repository.PatternRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PatternService {
    @Autowired
    private final PatternRepository patternRepository;

    public PatternService(PatternRepository patternRepository) {
        this.patternRepository = patternRepository;
    }

    public Pattern addPattern(Pattern pattern) {
        return patternRepository.save(pattern);
    }

    public List<Pattern> getAllPatterns() {
        return patternRepository.findAll();
    }

    public Pattern updatePattern(Long id, Pattern pattern) {
        Pattern existingPattern= patternRepository.findById(id).orElseThrow();
        existingPattern.setName(pattern.getName());
        existingPattern.setPrice(pattern.getPrice());
        return patternRepository.save(existingPattern);
    }

    public void deletePattern(Long id) {
        patternRepository.deleteById(id);
    }

    public Optional<Pattern> findById(Long id) {
        return patternRepository.findById(id);
    }
}
