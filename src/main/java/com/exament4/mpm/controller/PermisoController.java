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

import com.exament4.mpm.model.Permiso;
import com.exament4.mpm.service.PermisoService;

@Controller
@RequestMapping("/permisos")
public class PermisoController {

    @Autowired
    PermisoService permisoService;

    @GetMapping(value = "/list")
    public ModelAndView list(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        List<Permiso> permisos = permisoService.findAll();
        modelAndView.addObject("permisos", permisos);
        modelAndView.setViewName("permisos/list");
        return modelAndView;
    }

    @RequestMapping(value = { "/nuevo" })
    public ModelAndView nuevo() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("permisos/nuevo");

        return modelAndView;
    }

    @PostMapping(path = { "/guardar" })
    public ModelAndView guardar(Permiso permiso) {
        ModelAndView modelAndView = new ModelAndView();
        permisoService.insert(permiso);
        modelAndView.setViewName("redirect:editar/" + permiso.getCodigo());

        return modelAndView;
    }

    @GetMapping(path = { "/editar/{codigo}" })
    public ModelAndView editar(@PathVariable(name = "codigo", required = true) int codigo) {
        ModelAndView modelAndView = new ModelAndView();
        Permiso permiso = permisoService.findById(codigo);
        modelAndView.addObject("permiso", permiso);
        modelAndView.setViewName("permisos/editar");

        return modelAndView;

    }

    @PostMapping(path = { "/modificar" })
    public ModelAndView modificar(Permiso permiso) {

        ModelAndView modelAndView = new ModelAndView();
        permisoService.update(permiso);
        modelAndView.setViewName("redirect:editar/" + permiso.getCodigo());

        return modelAndView;
    }

    @GetMapping(path = { "/borrar/{codigo}" })
    public ModelAndView borrar(@PathVariable(name = "codigo", required = true) int codigo) {
        ModelAndView modelAndView = new ModelAndView();

        permisoService.delete(codigo);
        modelAndView.setViewName("redirect:../list");

        return modelAndView;
    }

}
