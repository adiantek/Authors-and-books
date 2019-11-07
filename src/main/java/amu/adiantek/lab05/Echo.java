package amu.adiantek.lab05;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/echo")
public class Echo {

    @GetMapping("{word}")
    public WordReceiver zad1(@PathVariable("word") String word) {
        WordReceiver wr = new WordReceiver();
        wr.word = word;
        return wr;
    }

    @GetMapping
    public String zad2(@RequestParam("word") String word) {
        return word;
    }

    /*@PostMapping
    public String zad3(@RequestBody String word) {
        return word;
    }*/

    @PostMapping
    public String zad4(@RequestBody WordReceiver word) {
        return word.word;
    }

    public static class WordReceiver {
        public String word;
    }
}
