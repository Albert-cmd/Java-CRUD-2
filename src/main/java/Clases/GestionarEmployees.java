/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Albert Gonzalez
 */
public class GestionarEmployees {
    //    Llistar registres.
//Per exemple per llistar els registres de la taula pel·lícules faríem:
    public List<Employees> selectAll() {
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Employees> employees = session.createCriteria(Employees.class).list();
        session.close();
        return employees;
    }
//Afegir registres.
//Per afegir un registre nou a la taula pel·lícules faríem:

    public void afegirEmployee(Departments departments, String empName, String position, BigDecimal salary) {
        // Obrir la sessió
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        // Fer l'operació
        Employees emp = new Employees();
        
        emp.setDepartments(departments);
        emp.setEmpName(empName);
        emp.setPosition(position);
        emp.setSalary(salary);

        session.save(emp);

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
