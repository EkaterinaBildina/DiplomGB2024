package com.diploma.dbpatterns.service;

import com.diploma.dbpatterns.model.PatternSew;
import com.diploma.dbpatterns.repository.PatternRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class PatternService {
    /**
     * Объект репозитория
     */
    @Autowired
    private final PatternRepository patternRepository;

    /**
     * Добавление Выкройки
     * @param pattern
     * @return сохраненный объект
     */
    public PatternSew addPattern(PatternSew pattern) {
        return patternRepository.save(pattern);
    }

    /**
     * Получение списка всех выкроек
     * @return список
     */
    public List<PatternSew> getAllPatterns() {
        return patternRepository.findAll();
    }

    /**
     * Обновление информации в объекте Выкройка
     * @param id идентификатор
     * @param pattern
     * возможно изменить имя и стоимость
     * @return сохраненный объекта
     */
    public PatternSew updatePattern(Long id, PatternSew pattern) {
        PatternSew existingPattern= patternRepository.findById(id).orElseThrow();
        existingPattern.setName(pattern.getName());
        existingPattern.setPrice(pattern.getPrice());
        return patternRepository.save(existingPattern);
    }

    public void deletePattern(Long id) {
        patternRepository.deleteById(id);
    }

    public Optional<PatternSew> findById(Long id) {
        return patternRepository.findById(id);
    }
}
