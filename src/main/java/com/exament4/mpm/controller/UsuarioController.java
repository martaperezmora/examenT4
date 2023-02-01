package com.exament4.mpm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.exament4.mpm.model.Grupo;
import com.exament4.mpm.model.Permiso;
import com.exament4.mpm.model.Usuario;
import com.exament4.mpm.service.GrupoService;
import com.exament4.mpm.service.PermisoService;
import com.exament4.mpm.service.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    GrupoService grupoService;

    @Autowired
    PermisoService permisoService;

    @GetMapping(value = "/list")
    public ModelAndView list(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        List<Usuario> usuarios = usuarioService.findAll();
        modelAndView.addObject("usuarios", usuarios);
        modelAndView.setViewName("usuarios/list");
        return modelAndView;
    }

    @RequestMapping(value = { "/nuevo" })
    public ModelAndView nuevo() {
        ModelAndView modelAndView = new ModelAndView();
        List<Grupo> grupos = grupoService.findAll();
        modelAndView.addObject("usuario", new Usuario());
        modelAndView.addObject("grupos", grupos);
        modelAndView.setViewName("usuarios/nuevo");

        return modelAndView;
    }

    @PostMapping(path = { "/guardar" })
    public ModelAndView guardar(Usuario usuario, @RequestParam(value = "grupos") int[] grupos) {
        ModelAndView modelAndView = new ModelAndView();
        Grupo grupoUsuario = grupoService.findById(grupos[0]);
        usuario.setGrupo(grupoUsuario);
        usuarioService.insert(usuario);
        modelAndView.setViewName("redirect:editar/" + usuario.getCodigo());

        return modelAndView;
    }

    @GetMapping(path = { "/editar/{codigo}" })
    public ModelAndView editar(@PathVariable(name = "codigo", required = true) int codigo) {
        ModelAndView modelAndView = new ModelAndView();
        Usuario usuario = usuarioService.findById(codigo);

        List<Permiso> permisos = permisoService.findAll();
        for (Permiso permiso : permisos) {
            if (usuario.getPermisos().contains(permiso)) {
                permiso.setChecked(true);
            }
        }

        modelAndView.addObject("usuario", usuario);
        modelAndView.addObject("permisos", permisos);
        modelAndView.setViewName("usuarios/editar");

        return modelAndView;
    }

    @PostMapping(path = { "/modificar" })
    public ModelAndView update(Usuario usuario, @RequestParam(value = "ck_permisos") int[] ck_permisos) {

        List<Permiso> permiso = usuario.getPermisos();
        if (permiso == null) {
            permiso = new ArrayList<Permiso>();
        }

        for (int i : ck_permisos) {
            Permiso a = new Permiso(i);
            permiso.add(a);
        }

        usuario.setPermisos(permiso);

        usuarioService.update(usuario);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:editar/" + usuario.getCodigo());
        return modelAndView;
    }

    @GetMapping(path = { "/borrar/{codigo}" })
    public ModelAndView borrar(@PathVariable(name = "codigo", required = true) int codigo) {
        ModelAndView modelAndView = new ModelAndView();

        usuarioService.delete(codigo);
        modelAndView.setViewName("redirect:/usuarios/list");

        return modelAndView;
    }
}
