package org.heapifyman.bootin.controller;

import java.util.Optional;

import org.heapifyman.bootin.model.Person;
import org.heapifyman.bootin.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "persons", produces = APPLICATION_JSON_VALUE)
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping(method = GET)
    public HttpEntity<Iterable<Person>> findAll(@RequestParam Optional<String> lastName) {
        if (lastName.isPresent()) {
            return new ResponseEntity<>(personRepository.findByLastName(lastName.get()), OK);
        }
        return new ResponseEntity<>(personRepository.findAll(), OK);
    }

}
