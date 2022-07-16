package webclient.backend.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/")
public class ClientController {

    @RequestMapping("/")
    @ResponseBody
    public String welcomaPage() {
        return "Welcome to WebApplication. Enjoy it!";
    }
}
