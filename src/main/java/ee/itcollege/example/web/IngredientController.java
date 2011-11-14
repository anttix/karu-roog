package ee.itcollege.example.web;

import ee.itcollege.example.entities.Ingredient;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "ingredients", formBackingObject = Ingredient.class)
@RequestMapping("/ingredients")
@Controller
public class IngredientController {
}
