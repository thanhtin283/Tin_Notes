package com.thanhtin.inotes.controller;

import com.thanhtin.inotes.model.Note;
import com.thanhtin.inotes.model.Type;
import com.thanhtin.inotes.service.NoteService;
import com.thanhtin.inotes.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TypeController {

    @Autowired
    private TypeService typeService;

    @Autowired
    private NoteService noteService;

    @GetMapping("/type")
    public ModelAndView listType(){
        Iterable<Type> types=typeService.findAll();
        ModelAndView modelAndView = new ModelAndView("/type/list");
        modelAndView.addObject("types",types);
        return modelAndView;
    }

    @GetMapping("/create-type")
    public ModelAndView showTypeForm(){
        ModelAndView modelAndView = new ModelAndView("/type/create");
        modelAndView.addObject("type",new Type());
        return modelAndView;
    }

    @PostMapping("/create-type")
    public ModelAndView saveType(@ModelAttribute("type")Type type){
        typeService.save(type);

        ModelAndView modelAndView = new ModelAndView("/type/create");
        modelAndView.addObject("type",new Type());
        modelAndView.addObject("message","New type create successfully");
        return modelAndView;
    }

    @GetMapping("/edit-type/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Type type = typeService.findById(id);
        if(type != null) {
            ModelAndView modelAndView = new ModelAndView("/type/edit");
            modelAndView.addObject("type", type);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-type")
    public ModelAndView updateProvince(@ModelAttribute("type") Type type){
        typeService.save(type);

        ModelAndView modelAndView = new ModelAndView("/type/edit");
        modelAndView.addObject("type", type);
        modelAndView.addObject("message", "Province updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-type/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Type type = typeService.findById(id);
        if(type != null) {
            ModelAndView modelAndView = new ModelAndView("/type/delete");
            modelAndView.addObject("type", type);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-type")
    public String deleteProvince(@ModelAttribute("type") Type type){
        typeService.remove(type.getId());
        return "redirect:type";
    }

    @GetMapping("/view-type/{id}")
    public ModelAndView viewType(@PathVariable("id")Long id){
        Type type = typeService.findById(id);
        if (type == null){
            return new ModelAndView("/error.404");
        }

        Iterable<Note> notes=noteService.findAllByType(type);

        ModelAndView modelAndView = new ModelAndView("/type/view");
        modelAndView.addObject("type",type);
        modelAndView.addObject("notes",notes);
        return modelAndView;

    }
}
