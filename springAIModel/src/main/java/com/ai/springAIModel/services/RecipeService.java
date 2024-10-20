package com.ai.springAIModel.services;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RecipeService {


    private final ChatModel chatModel;

    @Autowired
    public RecipeService(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String createRecipe(
            String ingredients,
            String cuisine,
            String dietaryRestriction){

        var template = """
                I want to create a recipe using the following ingredients: {ingredients}.
                The cuisine type I prefer is {cuisine}.
                Please consider the following dietary restrictions: {dietaryRestriction}.
                Please provide me with a detailed recipe including title, list of ingredients and cooking instructions.
                """;

        PromptTemplate promptTemplate = new PromptTemplate(template);

        // these will map with template params
        Map<String,Object> params = Map.of(
                "ingredients",ingredients,
                "cuisine", cuisine,
                "dietaryRestriction",dietaryRestriction
        );

        Prompt prompt = promptTemplate.create(params);

        return chatModel.call(prompt).getResult().getOutput().getContent();
    }

}
