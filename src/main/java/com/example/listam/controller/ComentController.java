package com.example.listam.controller;

import com.example.listam.entity.Category;
import com.example.listam.entity.Coment;
import com.example.listam.entity.Item;
import com.example.listam.repository.ComentRepository;
import com.example.listam.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ComentController {
    @Autowired
    private ComentRepository comentRepository;
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/coments")
    public String comentsPage(ModelMap modelMap) {
        List<Coment> all = comentRepository.findAll();
        modelMap.addAttribute("coments", all);
        return "coments";
    }


    @GetMapping("/coments/add")
    public String comentsAddPage(ModelMap modelMap) {
        List<Item> all = itemRepository.findAll();
        modelMap.addAttribute("coments", all);
        return "addComent";
    }

    @PostMapping("/coments/add")
    public String comentsAdd(@ModelAttribute Coment coment) {
        comentRepository.save(coment);
        return "redirect:/coments";
    }

    @GetMapping("/coments/remove")
    public String removeCategory(@RequestParam("id") int id) {
        comentRepository.deleteById(id);
        return "redirect:/coments";
    }
}