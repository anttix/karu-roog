package ee.itcollege.example.web;

import ee.itcollege.example.entities.Cage;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "cages", formBackingObject = Cage.class)
@RequestMapping("/cages")
@Controller
public class CageController {
}
