package com.example.ContactMicroserviceOpenApi.Repository;


import com.example.ContactMicroserviceOpenApi.Model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContactRepo extends JpaRepository<Contact, Integer> {

        Contact findByEmail(String email);
        void deleteByEmail(String email);
}
