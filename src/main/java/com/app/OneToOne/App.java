package com.app.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class App 
{
    public static void main( String[] args )
    {
    	 StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
    	    Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();  
    	      
    	    SessionFactory factory=meta.getSessionFactoryBuilder().build();  
    	    Session session=factory.openSession();  
    	      
    	    Transaction t=session.beginTransaction();   
    	      
    	    Employee e1=new Employee();    
    	    e1.setName("Parth Nayak");    
    	    e1.setEmail("parth@gmail.com");    
    	        
    	    Address address1=new Address();    
    	    address1.setAddressLine1("H-9,kormangla");    
    	    address1.setCity("Bangalore");    
    	    address1.setState("KARNATAKA");    
    	    address1.setCountry("India");    
    	    address1.setPincode(560029);    
    	        
    	    e1.setAddress(address1);    
    	    address1.setEmployee(e1);    
    	        
    	    session.persist(e1);    
    	    t.commit();    
    	        
    	    session.close();    
    	    System.out.println("successfuly OneToOne is implemented");    
    	}    
    }

