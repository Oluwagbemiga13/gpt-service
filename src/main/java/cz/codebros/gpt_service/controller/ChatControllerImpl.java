package cz.codebros.gpt_service.controller;

import cz.codebros.gpt_service.service.OpenAiChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatControllerImpl implements ChatController {

    private final OpenAiChatService openAiChatService;

    @Autowired
    public ChatControllerImpl(OpenAiChatService openAiChatService) {
        this.openAiChatService = openAiChatService;
    }

    @Override
    public String chat(String prompt) {
        return openAiChatService.getChatResponse(prompt);
    }

    @Override
    public String testConnection() {
        try {
            // Assuming OpenAiChatService has a method to test the connection
            // For example, listing available models
            openAiChatService.testConnection();
            return "Connection to OpenAI successful.";
        } catch (Exception e) {
            return "Failed to connect to OpenAI: " + e.getMessage();
        }
    }
}