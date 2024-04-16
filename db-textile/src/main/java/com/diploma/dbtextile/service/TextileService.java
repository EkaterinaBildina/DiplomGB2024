package com.diploma.dbtextile.service;

import com.diploma.dbtextile.exceptions.ShortageLengthException;
import com.diploma.dbtextile.model.Textile;
import com.diploma.dbtextile.repository.TextileRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class TextileService {
    /**
     * Объект репозитория
     */
    @Autowired
    private final TextileRepository textileRepository;

    /**
     * Добавление ткани
     *
     * @param textile
     * @return сохранение ткани
     */
    public Textile addTextile(Textile textile) {
        return textileRepository.save(textile);
    }

    /**
     * Получение всех тканей
     *
     * @return список тканей
     */
    public List<Textile> getAllTextile() {
        return textileRepository.findAll();
    }

    /**
     * Обновление информации о тканях
     *
     * @param id      идентификатор
     * @param textile ткань
     *                обновление имени / цены на метр / количества метров в рулоне
     * @return сохраненный измененный обьект ткань
     */
    public Textile updateTextile(String id, Textile textile) {
        Textile existingTextile = textileRepository.findById(Long.valueOf(id)).orElseThrow();
        existingTextile.setName(textile.getName());
        existingTextile.setPrice(textile.getPrice());
        existingTextile.setRolllength(textile.getRolllength());
        return textileRepository.save(existingTextile);
    }

    /**
     * Удаление ткани по Id
     *
     * @param id
     */
    public void deleteTextile(String id) {
        textileRepository.deleteById(Long.valueOf(id));
    }

    /**
     * Поиск ткани по id
     *
     * @param id
     * @return объект ткани
     */
    public Optional<Textile> findById(String id) {
        return textileRepository.findById(Long.valueOf(id));
    }

    /**
     * Получение инфо о конкретной ткани на складе.
     *
     * @param id идентификатор.
     * @return объект ткани.
     */
    public Textile getTextileById(String id) {
        return textileRepository.findById(Long.valueOf(id)).orElseThrow();
    }

    /**
     * Уменьшение остатка длины рулона Ткани на складе.
     *
     * @param id          идентификатор Ткани.
     * @param consumption количество для уменьшения (значение в Pattern int consumption).
     * @throws ShortageLengthException исключение при нехватке остатка ткани
     */
    @Transactional
    public void reduceRolllength(@PathVariable String id, Double consumption)
            throws ShortageLengthException {
        Textile textile = getTextileById(id);
        if (consumption > textile.getRolllength())
            throw new ShortageLengthException("Количества ткани не достаточно для выполнения заказа");
        textile.setRolllength(textile.getRolllength() - consumption);
        textileRepository.save(textile);
    }
}

