package com.matrix.demotestapp.controller;

import com.matrix.demotestapp.model.Person;
import com.matrix.demotestapp.service.PersonalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/personal")
public class PersonController {

    private final PersonalService personalService;

    @GetMapping("/person")
    public String selectPersonById(@RequestParam(name = "id") int id){
       return personalService.selectPersonById(id);
    }

    @GetMapping("/allPerson")
    public List<Person> selectAll(){
        return personalService.selectAll();
    }

    @PostMapping("/")
    public String setPerson(@RequestBody Person person){
        if(personalService.setPerson(person))
            return "1 row successfully ADDED ✅";
        else
            return "Unsuccessfully adding process!!!";
    }

    @PutMapping("/")
    public String updatePerson(@RequestBody Person person){
        if(personalService.updatePerson(person))
            return "1 row successfully UPDATED ✅";
        else
            return "Unsuccessfully updating process!!!";
    }

    @DeleteMapping("/del")
    public String deletePerson(@RequestBody Person person){
        if(personalService.deletePerson(person.getId()))
            return "1 row DELETED successfully ✅";
        else
            return "Unsuccessfully deleting process!!!";
    }

}
