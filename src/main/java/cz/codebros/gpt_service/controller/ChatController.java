package cz.codebros.gpt_service.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "Chat Controller", description = "The chat controller for handling chat requests")
public interface ChatController {

    @Operation(summary = "Get chat response", description = "Returns a response from the chat service based on the provided prompt",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successful operation",
                            content = @Content(schema = @Schema(implementation = String.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid request")
            })
    @GetMapping("/chat")
    String chat(@Parameter(description = "The prompt to send to the chat service") @RequestParam String prompt);

    @GetMapping("/testConnection")
    String testConnection();
}

