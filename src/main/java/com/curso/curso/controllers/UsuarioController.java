package com.curso.curso.controllers;

import com.curso.curso.dao.UsuarioDao;
import com.curso.curso.models.UsuarioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("usuarios")  // profijo 'usuarios' para las rutas
public class UsuarioController {
    @Autowired
    private UsuarioDao usuarioDao;
    @GetMapping
    public List<UsuarioModel> listar(@RequestHeader("Authorization") String token) {
        return usuarioDao.listar(token);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@RequestHeader("Authorization") String token, @PathVariable Long id) {
        usuarioDao.eliminar(token, id);
    }
    @PostMapping
    public void registar(@RequestBody UsuarioModel usuario) {
        usuarioDao.registrar(usuario);
    }
}