package com.diploma.dbpatterns.controller;

import com.diploma.dbpatterns.model.Pattern;
import com.diploma.dbpatterns.service.PatternService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@AllArgsConstructor
@RequestMapping("/patterns")
public class PatternController {

    /**
     * Объект сервиса выкроек
     */
    @Autowired
    private PatternService patternService;

    /**
     * Добавление Выкройки
     * @param pattern
     * @return
     */
    @PostMapping("/addNew")
    public ResponseEntity<Pattern> addPattern(@RequestBody Pattern pattern) {
        Pattern newPattern = patternService.addPattern(pattern);
        return ResponseEntity.ok(newPattern);
    }

    /**
     * Получение списка всех Выкроек
     * @return список выкроек
     */
    @GetMapping("/get-all")
    public ResponseEntity<List<Pattern>> getAllPatterns() {
        List<Pattern> patterns = patternService.getAllPatterns();
        return ResponseEntity.ok(patterns);
    }

    /**
     * Получение Выкройки по ID
     * @param id
     * @return объект выкройки по идентификатору
     */
    @GetMapping("/{id}")
    public Optional<Pattern> getPatternById(@PathVariable Long id) {
        return patternService.findById(id);
    }

    /**
     * Обновление инфо в обьекте Выкройка
     * @param id индентификатор
     * @param pattern
     * @return обновленный объект
     */

    @PutMapping("/{id}")
    public ResponseEntity<Pattern> updatePattern(@PathVariable Long id, @RequestBody Pattern pattern) {
        Pattern updatedPattern = patternService.updatePattern(id, pattern);
        return ResponseEntity.ok(updatedPattern);
    }

    /**
     * Удаление выкройки
     * @param id
     * @return отсутствие объекта
     */
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
