package ilyalyapunov.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    CarService carService;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String addCar(Model model){
        model.addAttribute("car", new Car());
        return "addCar";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String accept(@Valid @ModelAttribute("car") Car car,
                         BindingResult errors,
                         RedirectAttributes redirectAttributes){

        if (errors.hasErrors()){
            return "addCar";
        }
        carService.saveCar(car);
        redirectAttributes.addFlashAttribute("car", car);
        redirectAttributes.addFlashAttribute("age", carService.countAge());
        return "redirect:/car";
    }

    @RequestMapping(value = "/car",  method = RequestMethod.GET)
    public String showCar(@ModelAttribute("car") Car car,
                          @ModelAttribute("age") int age){
        return "car";
    }

    @ModelAttribute("colors")
    public List<String> getColors(){
        return Arrays.asList("black", "white", "gray", "orange", "blue");
    }
}
