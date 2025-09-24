package com.org.bossabox.vuttr.controller;

import com.org.bossabox.vuttr.dto.ToolRequest;
import com.org.bossabox.vuttr.dto.ToolResponse;
import com.org.bossabox.vuttr.dto.Error;
import com.org.bossabox.vuttr.service.ToolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class ToolController {

  private ToolService toolService;

  public ToolController(ToolService toolService) {
    this.toolService = toolService;
  }

  @GetMapping("/tools")
  public ResponseEntity<List<ToolResponse>> getTools() {
    try {
      List<ToolResponse> tools = toolService.getTools();
      return ResponseEntity.status(HttpStatus.OK).body(tools);
    } catch (Exception e) {
      List<Error> errors = new ArrayList<>(
          Collections.singleton(new Error("400", e.getClass().getSimpleName(), e.getMessage()))
      );
      List<ToolResponse> toolResponses = new ArrayList<>();
      toolResponses.add(new ToolResponse(null, null, null, null, null,  errors));
      return ResponseEntity.badRequest().body(toolResponses);
    }
  }

  @PostMapping("/tools")
  public ResponseEntity<ToolResponse> createTools(@RequestBody ToolRequest toolRequest) {
    try {
      ToolResponse toolResponse = toolService.createTool(toolRequest);
      return ResponseEntity.status(HttpStatus.CREATED).body(toolResponse);
    } catch (Exception e) {
      List<Error> errors = new ArrayList<>(
          Collections.singleton(new Error("400", e.getClass().getSimpleName(), e.getMessage()))
      );
      return ResponseEntity.badRequest().body(new ToolResponse(null, null, null, null, null,  errors));
    }
  }
}
