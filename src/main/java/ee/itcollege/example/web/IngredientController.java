package ee.itcollege.example.web;

import javax.validation.Valid;

import ee.itcollege.example.entities.Ingredient;
import ee.itcollege.example.entities.Menu;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RooWebScaffold(path = "ingredients", formBackingObject = Ingredient.class)
@RequestMapping("/ingredients")
@Controller
public class IngredientController {
    /**
     * Create a new ingredient.
     *
     * Once the ingredient is successfully created, the user is redirected to
     * the associated menu details view.
     *
     * @param ingredient
     * @param bindingResult
     * @param uiModel
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public String create(@Valid Ingredient ingredient,
            BindingResult bindingResult, Model uiModel) {

        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("ingredient", ingredient);
            return "ingredients/create";
        }
        uiModel.asMap().clear();
        ingredient.persist();

        return "redirect:/menus/" + ingredient.getMenu().getId();
    }

    /**
     * Show a new ingredient form. Use optional request parameter "menu" to
     * automatically associate the created ingredient with a menu.
     *
     * @param menu an ID of the menu the new ingredient will be associated with
     * @param uiModel Model object passed on to the view
     * @return
     */
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String createForm(@RequestParam(required = false) Long menu,
            Model uiModel) {

    Ingredient i = new Ingredient();
    if(menu != null)
        i.setMenu(Menu.findMenu(menu));
        uiModel.addAttribute("ingredient", i);
        return "ingredients/create";
    }

    /**
     * Update an existing ingredient.
     *
     * Once the ingredient is successfully updated, the user is redirected to
     * the associated menu details view.
     *
     * @param ingredient
     * @param bindingResult
     * @param uiModel
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT)
    public String update(@Valid Ingredient ingredient,
            BindingResult bindingResult, Model uiModel) {

        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("ingredient", ingredient);
            return "ingredients/update";
        }
        uiModel.asMap().clear();
        ingredient.merge();

       return "redirect:/menus/" + ingredient.getMenu().getId();
    }
}
