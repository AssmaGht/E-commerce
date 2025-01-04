package com.example.demo6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo6.entitie.Role;
import com.example.demo6.repository.RoleRepository;

@RestController
@RequestMapping("roles")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @DeleteMapping("supprimer/{id}")
    public String deleteRole( Long id) {
        roleRepository.deleteById(id);
        return "Role supprimé avec succès.";
    } 
    @PutMapping("modifier/{id}")
    public String updaterole( Long id, @RequestBody Role r) {
        Role ro = this.roleRepository.findById(id).get();
        
        ro.setProfile(r.getProfile());
       
        return "Role modifiée avec succès";
    }

}
