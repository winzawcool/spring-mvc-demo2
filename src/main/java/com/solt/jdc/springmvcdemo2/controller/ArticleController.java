package com.solt.jdc.springmvcdemo2.controller;

import com.solt.jdc.springmvcdemo2.dao.ArticleDao;
import com.solt.jdc.springmvcdemo2.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.websocket.server.PathParam;

@Controller
public class ArticleController {
    @Autowired
    private ArticleDao articleDao;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("articles",articleDao.findAll());
        model.addAttribute("new article",new Article());
        return "index";
    }

    @PostMapping("save-article")
    public String saveArticle(@ModelAttribute Article article) {
        articleDao.save(article);
        return "redirect:/";
    }

    @PostMapping("delete-article")
    public String deleteArticle(@PathParam("id")int id) {
        articleDao.deleteById(id);
        return "redirect:/";
    }
}
