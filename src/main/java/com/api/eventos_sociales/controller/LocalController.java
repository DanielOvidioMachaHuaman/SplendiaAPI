package com.api.eventos_sociales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.api.eventos_sociales.dao.LocalDAO;
import com.api.eventos_sociales.dao.LocalGaleriaDAO;
import com.api.eventos_sociales.dto.LocalItem;
import com.api.eventos_sociales.dto.LocalResponse;
import com.api.eventos_sociales.model.Local;



@RestController
@RequestMapping("/local")
@CrossOrigin(origins = "*")
public class LocalController {

    

    @Autowired
    private LocalDAO localDAO;

    @Autowired
    private LocalGaleriaDAO localGaleriaDAO;

    @GetMapping()
    public List<Local> findAll() {
        return localDAO.findAll();
    }

    @GetMapping("findByParaMatrimoniosTrue")
    public List<LocalItem> findByParaMatrimoniosTrue() {
        return localDAO.findByParaMatrimoniosTrue();
    }

    @GetMapping("findByParaFiestasInfantilesTrue")
    public List<LocalItem> findByParaFiestasInfantilesTrue() {
        return localDAO.findByParaFiestasInfantilesTrue();
    }

    @GetMapping("findByParaEventosCorporativosTrue")
    public List<LocalItem> findByParaEventosCorporativosTrue() {
        return localDAO.findByParaEventosCorporativosTrue();
    }

    @GetMapping("findByParaCumpleanosTrue")
    public List<LocalItem> findByParaCumpleanosTrue() {
        return localDAO.findByParaCumpleanosTrue();
    }

    @GetMapping("/{id}")
    public LocalResponse findById(@PathVariable("id") int id) {

        var _local = localDAO.findById(id);

        var localResponse = new LocalResponse();
        if (_local.isPresent())
            localResponse.setLocal(_local.get());
        localResponse.setGaleria(localGaleriaDAO.findByLocalId(id));
        return localResponse;
    }

    @PostMapping()
    public Local save(@RequestBody Local local) {

        var _local = new Local();
        if (local.getId() != 0)
            _local = localDAO.findById(local.getId()).get();

        _local.setNombre(local.getNombre());
        _local.setAforo(local.getAforo());
        _local.setDimensiones(local.getDimensiones());
        _local.setEstado(local.getEstado());
        _local.setPrecio(local.getPrecio());
        _local.setCalificacion(0);
        _local.setDescripcion(local.getDescripcion());
        _local.setUbicacion(local.getUbicacion());

        return localDAO.save(local);
    }



}
