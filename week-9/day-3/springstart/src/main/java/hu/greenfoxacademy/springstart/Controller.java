package hu.greenfoxacademy.springstart;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
public class Controller {


    @RequestMapping("/cicák")
    public ArrayList<String> getCicaNames(){
        return new ArrayList<>(
                Arrays.asList(
                        "Cirmi",
                        "Dormi",
                        "Bundas",
                        "Garfield",
                        "Cirmogó"
                )
        );
    }


}
