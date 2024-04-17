package com.diploma.dbpatterns.controller;

import com.diploma.dbpatterns.model.PatternSew;
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
    public ResponseEntity<PatternSew> addPattern(@RequestBody PatternSew pattern) {
        PatternSew newPattern = patternService.addPattern(pattern);
        return ResponseEntity.ok(newPattern);
    }

    /**
     * Получение списка всех Выкроек
     * @return список выкроек
     */
    @GetMapping("/get-all")
    public ResponseEntity<List<PatternSew>> getAllPatterns() {
        List<PatternSew> patterns = patternService.getAllPatterns();
        return ResponseEntity.ok(patterns);
    }

    /**
     * Получение Выкройки по ID
     * @param id
     * @return объект выкройки по идентификатору
     */
    @GetMapping("/{id}")
    public Optional<PatternSew> getPatternById(@PathVariable Long id) {
        return patternService.findById(id);
    }

    /**
     * Обновление инфо в обьекте Выкройка
     * @param id индентификатор
     * @param pattern
     * @return обновленный объект
     */

    @PutMapping("/{id}")
    public ResponseEntity<PatternSew> updatePattern(@PathVariable Long id, @RequestBody PatternSew pattern) {
        PatternSew updatedPattern = patternService.updatePattern(id, pattern);
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
