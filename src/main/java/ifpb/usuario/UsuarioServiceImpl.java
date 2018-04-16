/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.usuario;

import ifpb.persistence.JPARepository;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;


/**
 *
 * @author ifpb
 */
@RequestScoped
public class UsuarioServiceImpl implements UsuarioService{
    
    @Inject
    @JPARepository
    private UsuarioRepository repository;

    @Override
    public void ola() {
        repository.ola();
    }
    
}
