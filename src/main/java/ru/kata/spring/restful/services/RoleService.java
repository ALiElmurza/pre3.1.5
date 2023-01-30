package ru.kata.spring.restful.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.restful.models.Role;
import ru.kata.spring.restful.repositories.RoleRepository;

import java.util.List;
@Component
public class RoleService {
    RoleRepository roleRepository;
    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
