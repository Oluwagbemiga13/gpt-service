package cz.codebros.gpt_service.service;


import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.CompletionResult;
import com.theokanning.openai.model.Model;
import com.theokanning.openai.service.OpenAiService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OpenAiChatService {

    private static final Logger log = LoggerFactory.getLogger(OpenAiChatService.class);


    private final OpenAiService openAiService;

    @Autowired
    public OpenAiChatService(OpenAiService openAiService) {
        this.openAiService = openAiService;
    }

    public String getChatResponse(String prompt) {
        CompletionRequest completionRequest = CompletionRequest.builder()
                .model("gpt-3.5-turbo-0125")
                .prompt(prompt)
                .maxTokens(150)
                .build();
        CompletionResult completionResult = openAiService.createCompletion(completionRequest);
        return completionResult.getChoices().get(0).getText();
    }

    public void testConnection() {
        // This is a simple operation to test the connection
        List<Model> models = openAiService.listModels();
        log.info("Connection to OpenAI successful.\n");
        log.debug("Models available: {}", models);
    }
}


