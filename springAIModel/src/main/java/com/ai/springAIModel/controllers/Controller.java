package com.ai.springAIModel.controllers;


import com.ai.springAIModel.services.ChatService;
import com.ai.springAIModel.services.ImageService;
import com.ai.springAIModel.services.RecipeService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ai.image.ImageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/")
@CrossOrigin
public class Controller {

    @Autowired
    ChatService chatService;

    @Autowired
    ImageService imageService;

    @Autowired
    RecipeService recipeService;

    @GetMapping("chat")
    public String getChatResponse(@RequestParam String prompt){
        return chatService.getChatServiceResponse(prompt);
    }

    @GetMapping("image")
    public List<String> getImageResponse(HttpServletResponse response,
                                         @RequestParam String prompt,
                                         @RequestParam(defaultValue = "hd") String quality,
                                         @RequestParam(defaultValue = "1") Integer n,
                                         @RequestParam(defaultValue = "256") Integer width,
                                         @RequestParam(defaultValue = "256") Integer height) throws IOException {
        try{
            ImageResponse imageResponse=imageService.getImageResponse(prompt,quality,n,width,height);
            List<String> imageUrls = imageResponse.getResults().stream()
                    .map(result -> result.getOutput().getUrl())
                    .collect(Collectors.toList());
            return imageUrls;
        }catch (Exception e){
            return  null;
        }

    }

    @GetMapping("recipe")
    public  String createRecipe(
            @RequestParam String ingredients,
            @RequestParam(defaultValue = "any") String cuisine,
            @RequestParam(defaultValue = "") String dietaryRestriction
    ){
        return recipeService.createRecipe(ingredients,cuisine,dietaryRestriction);
    }
}
