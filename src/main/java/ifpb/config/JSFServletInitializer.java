/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ads.projeto.praticas.config;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


/**
 *
 * @author ifpb
 */
@WebListener
public class JSFServletInitializer implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().addServlet("*.xhtml", FacesServlet.class);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
    }

    
}
