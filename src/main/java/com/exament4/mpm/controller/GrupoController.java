package com.exament4.mpm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.exament4.mpm.model.Grupo;
import com.exament4.mpm.service.GrupoService;

@Controller
@RequestMapping("/grupos")
public class GrupoController {

    @Autowired
    GrupoService grupoService;

    @GetMapping(value = "/list")
    public ModelAndView list(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        List<Grupo> grupos = grupoService.findAll();
        modelAndView.addObject("grupos", grupos);
        modelAndView.setViewName("grupos/list");
        return modelAndView;
    }

    @RequestMapping(value = { "/nuevo" })
    public ModelAndView nuevo() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("grupos/nuevo");

        return modelAndView;
    }

    @PostMapping(path = { "/guardar" })
    public ModelAndView guardar(Grupo grupo) {
        ModelAndView modelAndView = new ModelAndView();
        grupoService.insert(grupo);
        modelAndView.setViewName("redirect:editar/" + grupo.getCodigo());

        return modelAndView;
    }

    @GetMapping(path = { "/editar/{codigo}" })
    public ModelAndView editar(@PathVariable(name = "codigo", required = true) int codigo) {
        ModelAndView modelAndView = new ModelAndView();
        Grupo grupo = grupoService.findById(codigo);
        modelAndView.addObject("grupo", grupo);
        modelAndView.setViewName("grupos/editar");

        return modelAndView;

    }

    @PostMapping(path = { "/modificar" })
    public ModelAndView modificar(Grupo grupo) {

        ModelAndView modelAndView = new ModelAndView();
        grupoService.update(grupo);
        modelAndView.setViewName("redirect:editar/" + grupo.getCodigo());

        return modelAndView;
    }

    @GetMapping(path = { "/borrar/{codigo}" })
    public ModelAndView borrar(@PathVariable(name = "codigo", required = true) int codigo) {
        ModelAndView modelAndView = new ModelAndView();

        grupoService.delete(codigo);
        modelAndView.setViewName("redirect:../list");

        return modelAndView;
    }

}
