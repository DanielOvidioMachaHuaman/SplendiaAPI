package com.api.eventos_sociales.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.eventos_sociales.dao.TipoEventoDAO;
import com.api.eventos_sociales.model.TipoEvento;

@RestController
@RequestMapping("/tipo_evento")
@CrossOrigin(origins = "*")
public class TipoEventoController {

    @Autowired
    private TipoEventoDAO tipoEventoDAO;

    @GetMapping()
    public List<TipoEvento> findAll() {
        return tipoEventoDAO.findAll();
    }

    @GetMapping("/{id}")
    public Optional<TipoEvento> findById(@PathVariable("id") int id) {
        return tipoEventoDAO.findById(id);
    }

    @PostMapping()
    public TipoEvento save(@RequestBody TipoEvento tipoEvento) {
        return tipoEventoDAO.save(tipoEvento);
    }
}
