package com.logistics.controller;

import com.logistics.model.Role;
import com.logistics.model.User;
import com.logistics.model.clearance;
import com.logistics.repository.clearanceRepo;
import com.logistics.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@Controller
public class AuthController {
    @Autowired
    UserService userService;
    @Autowired
    clearanceRepo clearancerepo;
//    private User user;

    @GetMapping(value ="/login")
    public String login(){
        return "/login";
    }

    @RequestMapping(value = {"/register"}, method = RequestMethod.GET)
    public String register(Model model){
        model.addAttribute("user", new User());
        return "/register";
    }
    @GetMapping(value ="/home")
public String getLoginpage()
{
    return "/register";
}
    @RequestMapping(value = {"/register"}, method = RequestMethod.POST)
    public String registerUser(Model model, @RequestParam String fname,
        @RequestParam String lname,@RequestParam String pnumber,@RequestParam String email,
        @RequestParam String password,@RequestParam Role role) throws ParseException {
            User user=new User();
            user.setPassword(password);
            user.setEmail(email);
            user.setFirstName(fname);
            user.setMobile(pnumber);
            user.setRole(role);
            user.setLastName(lname);
            userService.saveUser(user);
            return "redirect:/login";
        }
        @PostMapping("/saveclearance")
        public String saveclearance(@RequestParam int id,@RequestParam String name,@RequestParam String email,
        @RequestParam String phone,@RequestParam String compname,
        @RequestParam String cltype) throws ParseException {
            clearance cl = new clearance(id,name,email,phone,compname,cltype);
            clearancerepo.save(cl);
            return "redirect:/all";
        }
        @GetMapping("/all")
        public String getAllclearance(Model model)
        {
            List<clearance> clearanceList = clearancerepo.findAll();
            model.addAttribute("clearanceList",clearanceList);
            return "/ViewData";
        }

        @GetMapping("/clearance")
        public String clearance(Model model){
            return "/logistic";
        }

        @GetMapping("/all/{clearance}/delete")
        public String getAllclearance(@RequestParam("clearance") int clearance_id)
        {
            clearancerepo.deleteById(clearance_id);

            return "redirect: /all";
        }}

