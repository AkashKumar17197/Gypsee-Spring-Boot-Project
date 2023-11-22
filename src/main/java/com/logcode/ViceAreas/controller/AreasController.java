package com.logcode.ViceAreas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.logcode.ViceAreas.model.Areas;
import com.logcode.ViceAreas.repository.AreasRepository;


@Controller
@RequestMapping("/areas")
public class AreasController {

	@Autowired
    private AreasRepository areasRepository;

    @GetMapping
    public String list(Model model) {
        List<Areas> areas = areasRepository.findAll();
        model.addAttribute("areas", areas);
        return "area/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("area", new Areas());
        return "area/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Areas area) {
    	areasRepository.save(area);
        return "redirect:/areas";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Areas area = areasRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Area id"));
        model.addAttribute("area", area);
        return "area/edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Long id, @ModelAttribute Areas area) {
        // Validation and error handling can be added here
    	area.setArea_id(id);
    	areasRepository.save(area);
        return "redirect:/areas";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
    	areasRepository.deleteById(id);
        return "redirect:/areas";
    }	
	
}
