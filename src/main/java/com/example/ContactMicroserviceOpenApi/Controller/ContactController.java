package com.example.ContactMicroserviceOpenApi.Controller;


import com.example.ContactMicroserviceOpenApi.Model.Contact;
import com.example.ContactMicroserviceOpenApi.Service.IContactService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Contact Controller")
@RestController
public class ContactController {

    private final IContactService contactService;

    public ContactController(IContactService contactService) {
        this.contactService = contactService;
    }

    @Operation(summary = "contacts", description = "Return the list of contacts")
    @GetMapping(value = "contacts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Contact> show(){
        return contactService.findAll();
    }

    @Operation(summary = "contacts by id", description = "Return a contact by id")
    @GetMapping(value = "contacts/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Contact show(@Parameter(description = "Contact id") @PathVariable(name = "id") int id){
        return contactService.showContact(id);
    }

    @Operation(summary = "add contact", description = "Add a contact received in the request body")
    @PostMapping(value = "contacts",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String addContact(@Parameter(description = "JSON object to add")@RequestBody Contact contact){
        return String.valueOf(contactService.addContact(contact));
    }

    @Operation(summary = "update", description = "Update a contact received in request body")
    @PutMapping(value = "contacts", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@Parameter(description = "JSON object to update")@RequestBody Contact contact){
        contactService.updateContact(contact);
    }

    @Operation(summary = "delete", description = "Delete a contact by id")
    @DeleteMapping(value = "contacts/{id}")
    public void deleteById(@Parameter(description = "Contact id to delete") @PathVariable(name = "id") int id){
        contactService.deleteContact(id);
    }

}
