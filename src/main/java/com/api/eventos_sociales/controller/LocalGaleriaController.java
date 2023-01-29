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

import com.api.eventos_sociales.dao.LocalGaleriaDAO;
import com.api.eventos_sociales.model.LocalGaleria;

import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import com.api.eventos_sociales.service.StorageService;

@RestController
@RequestMapping("/local_galeria")
@CrossOrigin(origins = "*")
public class LocalGaleriaController {

    @Autowired
    private StorageService storageService;

    @Autowired
    private LocalGaleriaDAO localGaleriaDAO;

    @GetMapping()
    public List<LocalGaleria> findAll() {
        return localGaleriaDAO.findAll();
    }

    @GetMapping("/findByLocalId/{localId}")
    public List<LocalGaleria> findByLocalId(@PathVariable("localId") int localId) {
        return localGaleriaDAO.findByLocalId(localId);
    }

    @GetMapping("/{id}")
    public Optional<LocalGaleria> findAll(@PathVariable("id") int id) {
        return localGaleriaDAO.findById(id);
    }

    @PostMapping()
    public LocalGaleria save(@RequestBody LocalGaleria localGaleria) {
        return localGaleriaDAO.save(localGaleria);
    }

    @PostMapping("/subirFoto")
    public String subirFoto(@RequestParam("file") MultipartFile file, @RequestParam("localId") int localId,
            RedirectAttributes redirectAttributes) {

        var fileName = UUID.randomUUID().toString().toUpperCase() + "."
                + FilenameUtils.getExtension(file.getOriginalFilename());
        storageService.store(file, fileName);

        var localGaleria = new LocalGaleria();
        localGaleria.setLocalId(localId);
        localGaleria.setFoto(fileName);
        localGaleriaDAO.save(localGaleria);
        return fileName;
    }

    @GetMapping("/fotos/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        // localGaleriaDAO.deleteById(1);

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "image/*").body(file);
    }
}
