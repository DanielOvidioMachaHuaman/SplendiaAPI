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

import com.api.eventos_sociales.dao.LocalTipoEventoDAO;
import com.api.eventos_sociales.model.LocalTipoEvento;

@RestController
@RequestMapping("/local_tipo_evento")
@CrossOrigin(origins = "*")
public class LocalTipoEventoController {

    @Autowired
    private LocalTipoEventoDAO localTipoEventoDAO;

    @GetMapping()
    public List<LocalTipoEvento> findAll() {
        return localTipoEventoDAO.findAll();
    }

    @GetMapping("/{id}")
    public Optional<LocalTipoEvento> findAll(@PathVariable("id") int id) {
        return localTipoEventoDAO.findById(id);
    }

    @PostMapping()
    public LocalTipoEvento save(@RequestBody LocalTipoEvento tipoEvento) {
        return localTipoEventoDAO.save(tipoEvento);
    }
}
