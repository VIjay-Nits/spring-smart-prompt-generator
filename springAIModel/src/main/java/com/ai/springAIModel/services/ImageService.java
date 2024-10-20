package com.ai.springAIModel.services;

import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {


    private final OpenAiImageModel openAiImageModel;

    @Autowired
    public ImageService(OpenAiImageModel openAiImageModel) {
        this.openAiImageModel = openAiImageModel;
    }

//    public ImageResponse getImageResponse(String prompt){
//        ImageResponse imageResponse = openAiImageModel.call(
//                new ImagePrompt(prompt,
//                        OpenAiImageOptions.builder()
//
//                                .withHeight(1024)
//                                .withWidth(1024)
//                                .build()));
//        return imageResponse;
//    }

    public ImageResponse getImageResponse(String prompt,
                                          String quality,
                                          Integer n,
                                          Integer width,
                                          Integer height){
        ImageResponse imageResponse = openAiImageModel.call(
                new ImagePrompt(prompt,
                        OpenAiImageOptions.builder()
                                .withModel("dall-e-2")
                                .withQuality(quality)
                                .withN(n)
                                .withHeight(height)
                                .withWidth(width)
                                .build()));
        return imageResponse;
    }


}
