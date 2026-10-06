package ifrn.pi.eventos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ifrn.pi.eventos.models.Evento;
import ifrn.pi.eventos.repositories.EventoRepository;

@Controller
public class EventosController {

    @Autowired
    private EventoRepository er;

    @GetMapping("/")
    public ModelAndView listar() {
        List<Evento> eventos = er.findAll();

        ModelAndView mv = new ModelAndView("index");
        mv.addObject("eventos", eventos);

        return mv;
    }

    @RequestMapping("/eventos/form")
    public String form() {
        System.out.println("ABRIU O FORMULARIO");
        return "formEvento";
    }

    @PostMapping("/eventos")
    public String adicionar(Evento evento) {
        System.out.println("CHEGOU NO POST!");
        System.out.println(evento);

        er.save(evento);

        return "evento-adicionado";
    }
}