/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.persistence;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author ifpb
 */
public class PersistenceProducers implements Serializable{
    
    @Produces
    public EntityManager createEntityManager() {
        return Persistence.createEntityManagerFactory("BASEH-PU").createEntityManager();
    }    
    
//    @Produces
//    @JPARepository
//    public Connection createConnection() throws SQLException{
//        Connection connection = DriverManager.getConnection("jdbc:h2:mem:" , "sa", "");
//        return connection;
//    }
//    
//    @Produces
//    @XMLRepository
//    public Connection createConnectionT() throws SQLException{
//        Connection connection = DriverManager.getConnection("jdbc:h2:mem:" , "sa", "");
//        return connection;
//    }
    
}
