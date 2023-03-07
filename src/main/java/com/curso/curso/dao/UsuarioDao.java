package com.curso.curso.dao;

import com.curso.curso.models.UsuarioModel;
import com.curso.curso.utils.JWTUtil;  // Necesario para tokens JWT
import de.mkammerer.argon2.Argon2;  // Librería para hashear contraseñas
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.persistence.EntityManager;  // Necesario para las consultas SQL
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Repository
@Transactional  // Manejará las Sentencias SQL de manera transaccional
public class UsuarioDao implements IUsuarioDao {
    @Autowired
    private JWTUtil jwtUtil;
    @PersistenceContext  // Se podrá utilizar el EntityManager en cualquier método que se defina, y las transacciones serán administradas de forma automática.
    EntityManager entityManager;  // Nos permitirá la conexión con la base de datos
    private UsuarioModel verificarCredenciales(UsuarioModel usuario) {
        String sentencia = "FROM UsuarioModel WHERE email = :email";  // Solo verificamos el email ya que del pass se encarga argon2.verify()
        List<UsuarioModel> lista = entityManager.createQuery(sentencia)
                .setParameter("email", usuario.getEmail())
                .getResultList();
        if (lista.isEmpty())  // No encontró ni el correo
            return null;
        String passHashed = lista.get(0).getPass();
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if (argon2.verify(passHashed, usuario.getPass()))
            return lista.get(0);
        return null;
    }
    private boolean verificarToken (String token) {
        String usuarioValido = jwtUtil.getKey(token);
        // Aquí podríamos comprobar si el usuario existe o algunos de los valores guardados en el token existen en la DB y muchas otras comporbaciones.
        return usuarioValido != null;  // Retorna true si 'usuarioValido' != null, false en caso contrario
    }
    @Override
    public List<UsuarioModel> listar(@RequestHeader("Authorization") String token) {
        if (!this.verificarToken(token))
            return null;
        String sentencia = "FROM UsuarioModel"; // UsuarioModel no es el nombre de la tabla si no del modelo que contiene el nombre de la tabla
        return entityManager.createQuery(sentencia).getResultList();  // getResultList devuelve una lista compatible con List<UsuarioModel>
    }
    @Override
    public void eliminar(@RequestHeader("Authorization") String token, Long id) {
        if (!this.verificarToken(token))
            return;
        UsuarioModel usuario = entityManager.find(UsuarioModel.class, id);
        entityManager.remove(usuario);
    }
    @Override
    public void registrar(UsuarioModel usuario) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(2, 1024, 2, usuario.getPass());
        /*Parámetros de la función hash:
            2: 2 iteraciones
            1024: memoria
            2: procesos en paralelo
            El último parámetro es la contraseña a hashear. Debe ser de tipo String*/
        usuario.setPass(hash);
        entityManager.merge(usuario);  // merge en este caso equivale a save
    }
    @Override
    public String login(UsuarioModel usuario) {
        UsuarioModel usuarioLogin = this.verificarCredenciales(usuario);
        if (usuarioLogin != null)
            return jwtUtil.create(String.valueOf(usuarioLogin.getId()), usuarioLogin.getEmail());  // Los parámetros de .create deben ser Strings, por eso el uso de String.valueOf() pra el id
        return null;
    }
}