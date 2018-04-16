/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ads.projeto.praticas.usuario;

import ads.projeto.praticas.persistence.JPARepository;
import java.sql.Connection;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

@JPARepository
@SessionScoped
public class UsuarioRepositoryImpl implements UsuarioRepository {

//    @Inject
//    @JPARepository
//    private Connection connection;
    
    @Override
    public void ola() {
       // System.out.println(connection);
    }
    
}
