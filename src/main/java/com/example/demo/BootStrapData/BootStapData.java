package com.example.demo.BootStrapData;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.entities.Customer;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class BootStapData {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private DivisionRepository divisionRepository;

    @PostConstruct
    public void loadInitialData() {

        if(customerRepository.count() == 1) {

            Customer customer1 = new Customer();
            customer1.setFirstName("Stephen");
            customer1.setLastName("Blackwell");
            customer1.setAddress("1111 Western Street");
            customer1.setPostal_code("80000");
            customer1.setPhone("(502)502-1234");
            customer1.setDivision(divisionRepository.findAll().get(16));
            customer1.setCreate_date(new Date());
            customer1.setLast_update(new Date());

            Customer customer2 = new Customer();
            customer2.setFirstName("Adelyn");
            customer2.setLastName("Diaz");
            customer2.setAddress("1111 Western Street");
            customer2.setPostal_code("80000");
            customer2.setPhone("(502)502-9843");
            customer2.setDivision(divisionRepository.findAll().get(16));
            customer2.setCreate_date(new Date());
            customer2.setLast_update(new Date());

            Customer customer3 = new Customer();
            customer3.setFirstName("Craig");
            customer3.setLastName("Cunningham");
            customer3.setAddress("1234 Pop Street");
            customer3.setPostal_code("4000");
            customer3.setPhone("(502)999-9999");
            customer3.setDivision(divisionRepository.findAll().get(47));
            customer3.setCreate_date(new Date());
            customer3.setLast_update(new Date());

            Customer customer4 = new Customer();
            customer4.setFirstName("Luna");
            customer4.setLastName("Baby");
            customer4.setAddress("100 Cat Street");
            customer4.setPostal_code("80001");
            customer4.setPhone("(502)111-1111");
            customer4.setDivision(divisionRepository.findAll().get(04));
            customer4.setCreate_date(new Date());
            customer4.setLast_update(new Date());

            Customer customer5 = new Customer();
            customer5.setFirstName("Pam");
            customer5.setLastName("Martinez");
            customer5.setAddress("900 Bestie Street");
            customer5.setPostal_code("10010");
            customer5.setPhone("(502)555-5553");
            customer5.setDivision(divisionRepository.findAll().get(11));
            customer5.setCreate_date(new Date());
            customer5.setLast_update(new Date());

            customerRepository.save(customer1);
            customerRepository.save(customer2);
            customerRepository.save(customer3);
            customerRepository.save(customer4);
            customerRepository.save(customer5);

            System.out.print("Sample customers added!");
        } else {
            System.out.print("Sample customer could not be added.");
        }
    }
}
