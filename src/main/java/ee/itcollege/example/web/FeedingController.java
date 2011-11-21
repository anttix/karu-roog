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
    private transient org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(getClass());

    @RequestMapping
    public String index(Model uiModel) {
        log.debug("index(...)");

    	List<FeedingRation> data = new ArrayList<FeedingRation>();
    	
    	for(Cage c: Cage.findAllCages()) {
            log.debug("Processing cage: {} ({})", new Object[] { c.getName(), c.getId() });
    		data.add(FeedingRation.findRationsForCage(c));
    	}
        log.debug("Number of Feeding rations loaded: {}", data.size());
    	
    	uiModel.addAttribute("data", data);
        return "feeding/index";
    }
}
