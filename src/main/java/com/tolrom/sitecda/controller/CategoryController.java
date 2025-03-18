package com.tolrom.sitecda.controller;

import com.tolrom.sitecda.model.Category;
import com.tolrom.sitecda.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String showCategories(Model model) {
        Iterable<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "categories";
    }

    @GetMapping("/{id}")
    public String showCategoryById(@PathVariable int id, Model model) {
        Category category = categoryService.getCategoryById(id).orElse(null);
        model.addAttribute("category", category);
        return "category";
    }

    @GetMapping("/add")
    public String addCategory(Model model){
        Category category = new Category();
        model.addAttribute("category", category);
        return "category_add";
    }

    @PostMapping("/add")
    public String saveCategory(Category category) {
        categoryService.saveCategory(category);
        return "redirect:/categories";
    }

}
