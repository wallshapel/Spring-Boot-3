package com.curso.curso.dao;

import com.curso.curso.models.UsuarioModel;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

public interface IUsuarioDao {
    List<UsuarioModel> listar(@RequestHeader("Authorization") String token);
    void eliminar(@RequestHeader("Authorization") String token, Long id);
    void registrar(UsuarioModel usuario);
    String login(UsuarioModel usuario);
}