package ee.itcollege.example.web;

import ee.itcollege.example.entities.Menu;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "menus", formBackingObject = Menu.class)
@RequestMapping("/menus")
@Controller
public class MenuController {
}
