// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.itcollege.example.web;

import ee.itcollege.example.entities.Bear;
import ee.itcollege.example.entities.Ingredient;
import ee.itcollege.example.entities.Menu;
import java.io.UnsupportedEncodingException;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect MenuController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST)
    public String MenuController.create(@Valid Menu menu, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("menu", menu);
            return "menus/create";
        }
        uiModel.asMap().clear();
        menu.persist();
        return "redirect:/menus/" + encodeUrlPathSegment(menu.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String MenuController.createForm(Model uiModel) {
        uiModel.addAttribute("menu", new Menu());
        return "menus/create";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String MenuController.show(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("menu", Menu.findMenu(id));
        uiModel.addAttribute("itemId", id);
        return "menus/show";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String MenuController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            uiModel.addAttribute("menus", Menu.findMenuEntries(page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
            float nrOfPages = (float) Menu.countMenus() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("menus", Menu.findAllMenus());
        }
        return "menus/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String MenuController.update(@Valid Menu menu, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("menu", menu);
            return "menus/update";
        }
        uiModel.asMap().clear();
        menu.merge();
        return "redirect:/menus/" + encodeUrlPathSegment(menu.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
    public String MenuController.updateForm(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("menu", Menu.findMenu(id));
        return "menus/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String MenuController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Menu.findMenu(id).remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/menus";
    }
    
    @ModelAttribute("bears")
    public Collection<Bear> MenuController.populateBears() {
        return Bear.findAllBears();
    }
    
    @ModelAttribute("ingredients")
    public Collection<Ingredient> MenuController.populateIngredients() {
        return Ingredient.findAllIngredients();
    }
    
    @ModelAttribute("menus")
    public Collection<Menu> MenuController.populateMenus() {
        return Menu.findAllMenus();
    }
    
    String MenuController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        }
        catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
    
}