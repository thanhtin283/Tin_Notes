package com.thanhtin.inotes.controller;

import com.thanhtin.inotes.model.Note;
import com.thanhtin.inotes.model.Type;
import com.thanhtin.inotes.service.NoteService;
import com.thanhtin.inotes.service.TypeService;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Controller
public class NoteController {
    @Autowired
    private NoteService noteService;

    @Autowired
    private TypeService typeService;


    @ModelAttribute("types")
    public Iterable<Type> types(){
        return typeService.findAll();
    }
    @GetMapping("/homes")
    public String  goHome(){

        return "/home/homes";
    }
    @RequestMapping("/note")
    public ModelAndView listNote(@RequestParam("s") Optional <String> s, Pageable pageable){
        Page<Note> notes;
        Iterable<Type> types=typeService.findAll();
        if(s.isPresent()){
            notes = noteService.findAllByContentContaining(s.get(), pageable);
        } else {
            notes = noteService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/home/index");
        modelAndView.addObject("notes", notes);

        modelAndView.addObject("types",types);
        return modelAndView;
    }



    @GetMapping("/create-note")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/home/addProduct");
        modelAndView.addObject("n",new Note());
        return modelAndView;
    }
    @PostMapping("/create-note")
    public ModelAndView saveNote(@ModelAttribute("note") Note note){
    noteService.save(note);

    ModelAndView modelAndView = new ModelAndView("/home/addProduct");
    modelAndView.addObject("n",new Note());
    modelAndView.addObject("message","new Note create successfully");
    return modelAndView;
    }

    @GetMapping("/edit-note/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Note note = noteService.findById(id);
        if (note !=null){
            ModelAndView modelAndView = new ModelAndView("/note/edit");
            modelAndView.addObject("note",note);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-note")
    public ModelAndView updateNote(@ModelAttribute("note")Note note){
        noteService.save(note);
        ModelAndView modelAndView = new ModelAndView("/note/edit");
        modelAndView.addObject("note",note);
        modelAndView.addObject("message","Note updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-note/{id}")
    public String showDeleteForm(@PathVariable("id") Long id){
        noteService.remove(id);
        return "redirect:/note";
    }
//    @GetMapping("/delete-note/{id}")
//    public ModelAndView showDeleteForm(@PathVariable Long id){
//        Note note = noteService.findById(id);
//        if (note != null){
//            ModelAndView modelAndView = new ModelAndView("/note/delete");
//            modelAndView.addObject("n",note);
//            return modelAndView;
//        }else {
//            ModelAndView modelAndView = new ModelAndView("/error.404");
//            return modelAndView;
//        }
//    }
//
//    @PostMapping("/delete-note")
//    public String deleteNote(@ModelAttribute("note")Note note){
//        noteService.remove(note.getId());
//        return "redirect:note";
//    }
}
