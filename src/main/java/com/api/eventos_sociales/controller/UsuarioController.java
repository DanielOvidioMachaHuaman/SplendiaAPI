package com.api.eventos_sociales.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import com.api.eventos_sociales.dao.UsuarioDAO;
import com.api.eventos_sociales.dto.EmailBody;
import com.api.eventos_sociales.dto.LoginRequest;
import com.api.eventos_sociales.dto.UsuarioRequest;
import com.api.eventos_sociales.model.Usuario;
import com.api.eventos_sociales.service.EmailService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

    // @Autowired
    // private JavaMailSender emailSender;
    @Autowired
    private SpringTemplateEngine templateEngine;

    @Autowired
    private UsuarioDAO usuarioDAO;
    @Autowired
    private EmailService emailService;

    @GetMapping()
    public List<Usuario> findAll() {
        return usuarioDAO.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> findById(@PathVariable("id") int id) {
        return usuarioDAO.findById(id);
    }

    @PostMapping()
    public Usuario save(@RequestBody UsuarioRequest usuario) {
        var _usuario = new Usuario();

        if (usuario.getId() != 0) {
            _usuario = usuarioDAO.findById(usuario.getId()).get();
        } else {
            _usuario.setClave(usuario.getClave());
        }

        _usuario.setNombre(usuario.getNombre());
        _usuario.setDni(usuario.getDni());
        _usuario.setCorreo(usuario.getCorreo());
        _usuario.setUsuario(usuario.getUsuario());
        _usuario.setTipo(usuario.getTipo());
        return usuarioDAO.save(_usuario);
    }

    @PostMapping("saveCliente")
    public Usuario saveCliente(@RequestBody UsuarioRequest usuario) {
        var ctx = new Context();
        var emailBody = new EmailBody();
        var _usuario = new Usuario();

        _usuario.setNombre(usuario.getNombre());
        _usuario.setDni(usuario.getDni());
        _usuario.setCorreo(usuario.getCorreo());
        _usuario.setUsuario(usuario.getUsuario());
        _usuario.setClave(usuario.getClave());
        _usuario.setTipo("CLIENT");

        _usuario = usuarioDAO.save(_usuario);
        if (_usuario != null) {
            ctx.setVariable("nombre", usuario.getNombre());
            final String htmlContent = templateEngine.process("html/bienvenida.html", ctx);
            emailBody.setSubject(usuario.getNombre());
            emailBody.setEmail(usuario.getCorreo());
            emailBody.setContent(htmlContent);
            emailService.sendEmail(emailBody);
        }
        return _usuario;
    }

    @PostMapping("login")
    public Usuario login(@RequestBody LoginRequest loginRequest) {
        var usuario = usuarioDAO.findByUsuario(loginRequest.getUsuario()).get(0);
        if (usuario != null && loginRequest.getClave().equals(usuario.getClave()))
            return usuario;
        else
            return null;
    }

    @PostMapping(value = "/send")
    @ResponseBody
    public boolean SendEmail(@RequestBody EmailBody emailBody) {
        var ctx = new Context();
        ctx.setVariable("nombre", "ElberQF");
        // ctx.setVariable("subscriptionDate", new Date());
        // ctx.setVariable("imageResourceName",
        // "https://cdn.icon-icons.com/icons2/2596/PNG/512/check_one_icon_155665.png");
        // // so that we can reference it from HTML

        final String htmlContent = templateEngine.process("html/bienvenida.html", ctx);
        emailBody.setContent(htmlContent);
        return emailService.sendEmail(emailBody);
    }
}
