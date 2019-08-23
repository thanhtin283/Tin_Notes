package com.thanhtin.inotes.controller;

import com.thanhtin.inotes.model.User;
import com.thanhtin.inotes.repository.UserRepository;
import com.thanhtin.inotes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;
        @GetMapping("/login")
        public ModelAndView login(){
        ModelAndView modelAndView =new ModelAndView("/home/login");
        return modelAndView;
        }

        @PostMapping("/login")
    public ModelAndView loginForm(@ModelAttribute("user")User user, HttpSession session, Model model){
            User user1 =userRepository.findByName(user.getName());
            if((user1 !=null)&&(user1.getPassword().equals(user.getPassword()))){
                ModelAndView modelAndView = new ModelAndView("/home/homes");
                session.setAttribute("myUser", user1.getName());
                return modelAndView;
            }   else {
                ModelAndView modelAndView=new ModelAndView("/home/login");
                return modelAndView;
            }
        }
        @GetMapping("/logout")
        public String logout(HttpServletRequest request)
        {
            HttpSession session = request.getSession();
            session.invalidate();
            return "redirect:/homes";
        }
}
