package com.diploma.dbtextile.service;

import com.diploma.dbtextile.model.Textile;
import com.diploma.dbtextile.repository.TextileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TextileService {
    @Autowired
    private final TextileRepository textileRepository;


    public TextileService(TextileRepository textileRepository) {
        this.textileRepository = textileRepository;
    }

    public Textile addTextile(Textile textile) {
        return textileRepository.save(textile);
    }

    public List<Textile> getAllTextile() {
        return textileRepository.findAll();
    }

    public Textile updateTextile(String id, Textile textile) {
        Textile existingTextile= textileRepository.findById(Long.valueOf(id)).orElseThrow();
        existingTextile.setName(textile.getName());
        existingTextile.setPrice(textile.getPrice());
        return textileRepository.save(existingTextile);
    }

    public void deletePattern(String id) {
        textileRepository.deleteById(Long.valueOf(id));
    }

    public Optional<Textile> findById(String id) {
        return textileRepository.findById(Long.valueOf(id));
    }
}
