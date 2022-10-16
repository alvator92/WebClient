package webclient.backend.controller;

import liquibase.pro.packaged.S;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import webclient.backend.common.StringConstant;
import webclient.backend.configuration.db.jpa.JpaConfig;
import webclient.backend.model.User;
import webclient.backend.service.SecurityService;
import webclient.backend.validator.UserValidator;

/**
 * Controller for {@link webclient.backend.model.User}'s pages.
 *
 * @author Kabanets Vladislav
 * @version 1.0
 */
@RestController
public class UserController {

    @Autowired
    private JpaConfig jpaConfig;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

        @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if(bindingResult.hasErrors()) {
            return "registration";
        }

        jpaConfig.userService().save(userForm);

        securityService.autoLogin(userForm.getEmail(), userForm.getConfirmPassword());

        return "redirect:/welcome.jsp";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if(error!=null) {
            model.addAttribute("error", StringConstant.WRONG_EMAIL_PASS);
        }

        if(logout!=null) {
            model.addAttribute("message", StringConstant.LOGOUT);
        }

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome.jsp"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "Welcome to WebApplication. Enjoy it!";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "admin";
    }
}
