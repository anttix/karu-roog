package ee.itcollege.example.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ee.itcollege.example.entities.Cage;

@RequestMapping("/feeding/**")
@Controller
public class FeedingController {
    @RequestMapping
    public String index(Model uiModel) {
    	List<FeedingRation> data = new ArrayList<FeedingRation>();
    	
    	for(Cage c: Cage.findAllCages()) {
    		data.add(FeedingRation.findRationsForCage(c));
    	}
    	
    	uiModel.addAttribute("data", data);
        return "feeding/index";
    }
}
