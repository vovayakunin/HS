package com.example.hs.controller;

import com.example.hs.model.Faculty;
import com.example.hs.service.FacultyService;
import org.springframework.cglib.proxy.Factory;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    private final FacultyService facultyService;


    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }
    @GetMapping
    public Collection<Faculty> getAll(){
        return facultyService.getALl();
    }

    @GetMapping("/{id}")
    public Faculty getById(@PathVariable("id")Long id) {
        return facultyService.getById(id);
    }

    @GetMapping("/filtered")
    public Collection<Faculty> getByColor(@RequestParam("color") String color) {
        return facultyService.getByColor(color);
    }

    @PostMapping
    public Faculty create (@RequestBody Faculty faculty) {
        return facultyService.create(faculty);
    }

    @PutMapping("/{id}")
    public Faculty update(@PathVariable("id") Long id, @RequestBody Faculty faculty) {
        return facultyService.update(id, faculty);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Long id) {
        facultyService.delete(id);
    }
}


