/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Albert Gonzalez
 */
public class GestionarDepartments {

//    Llistar registres.
//Per exemple per llistar els registres de la taula pel·lícules faríem:
    public List<Departments> selectAll() {
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Departments> pelis = session.createCriteria(Departments.class).list();
        session.close();
        return pelis;
    }
//Afegir registres.
//Per afegir un registre nou a la taula pel·lícules faríem:

    public void afegirDep(String depName, String city, Set employeeses) {
        // Obrir la sessió
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        // Fer l'operació
        Departments dep = new Departments();
        dep.setDepName(depName);
        dep.setCity(city);
        dep.setEmployeeses(employeeses);

        session.save(dep);

        //Tancar la sessió
        session.getTransaction().commit();
        session.close();
    }
    
    
//Esborrar registres.
//Per esborrar un registre de la taula emprem el mètode delete:

    public void esborrarDep(Integer DepCode, String Titol) {
        // Obrir la sessió
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        // Fer l'operació
        Departments dep = new Departments();
        dep.setDepName(Titol);
        session.delete(dep);
        //Tancar la sessió
        session.getTransaction().commit();
        session.close();
    }
    
    
//Modificar registres.
//Per modificar un registre de la taula emprem el mètode merge:

    public void modificarPeli(String depName, String city, Set employeeses) {
        
        // Obrir la sessió
        
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        // Fer l'operació
        
        Departments dep = new Departments();
        dep.setCity(city);
        dep.setDepName(depName);
        dep.setEmployeeses(employeeses);
        session.merge(dep);
        
        //Tancar la sessió
        
        session.getTransaction().commit();
        session.close();
        
    }

}
