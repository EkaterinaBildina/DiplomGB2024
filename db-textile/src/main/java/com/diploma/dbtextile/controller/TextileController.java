package com.diploma.dbtextile.controller;


import com.diploma.dbtextile.model.Order;
import com.diploma.dbtextile.model.Textile;
import com.diploma.dbtextile.service.TextileService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/textile")
public class TextileController {
    /**
     * Сервис работы с Тканями
     */
    @Autowired
    private final TextileService textileService;

    /**
     * Добавление Ткани
     * @param textile
     * @return ответ с новой Тканью
     */
    @PostMapping("/addNew")
    public ResponseEntity<Textile> addTextile(@RequestBody Textile textile) {
        Textile newTextile = textileService.addTextile(textile);
        return ResponseEntity.ok(newTextile);
    }

    /**
     * Получение всех Тканей
     * @return список тканей
     */
    @GetMapping("/get-all")
    public ResponseEntity<List<Textile>> getAllTextile() {
        List<Textile> textileList = textileService.getAllTextile();
        return ResponseEntity.ok(textileList);
    }

    /**
     * Получение конкретной Ткани
     * @param id индентификатор
     * @return ответ с искомой тканью
     */
    @GetMapping("/{id}")
    public Optional<Textile> getTextileById(@PathVariable String id) {
        return textileService.findById(id);
    }

    /**
     * Обновление информации
     * @param id
     * @param textile
     * @return ответ с обновленной тканью
     */
    @PutMapping("/{id}")
    public ResponseEntity<Textile> updateTextile(@PathVariable String id, @RequestBody Textile textile) {
        Textile updatedTextile = textileService.updateTextile(id, textile);
        return ResponseEntity.ok(updatedTextile);
    }

    /**
     * удаление ткани
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTextile(@PathVariable String id) {
        textileService.deleteTextile(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Списание длины ткани от общего рулона.
     * @param id идентификатор ткани.
     * @param order объект заказа.
     * @return ответ с подтверждением успешного выполнения.
     */
    @PostMapping("{id}")
    public ResponseEntity<Void> reduceRolllength(@PathVariable("id") String id,
                                             @RequestBody Order order){
        textileService.reduceRolllength(id, order.getLength());
        return ResponseEntity.ok().body(null);
    }

    @GetMapping("/test")
    public ResponseEntity<Void> test() {
        return ResponseEntity.ok().build();
    }


}
