package com.org.bossabox.vuttr.service;

import com.org.bossabox.vuttr.dto.ToolRequest;
import com.org.bossabox.vuttr.dto.ToolResponse;
import com.org.bossabox.vuttr.entity.Tool;
import com.org.bossabox.vuttr.entity.ToolRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author joao.prado
 */
@Service
public class ToolService {

  private ToolRepository toolRepository;

  public ToolService(ToolRepository toolRepository) {
    this.toolRepository = toolRepository;
  }

  public void validateToolRequest(ToolRequest toolRequest) {
    if (toolRequest == null) {
      throw new IllegalArgumentException("You must provide a tool to execute the method.");
    }
    if (StringUtils.isBlank(toolRequest.title())) {
      throw new IllegalArgumentException("\"title\" is required.");
    }
    if (toolRepository.existsByTitle((toolRequest.title().trim()))) {
      throw new IllegalArgumentException("\"title\" is exclusive and already exists. Try using the update route.");
    }
  }

  public ToolResponse createTool(ToolRequest toolRequest) {
    validateToolRequest(toolRequest);
    Tool createdTool = toolRepository.save(
        new Tool(toolRequest.title(), toolRequest.link(), toolRequest.tags(), toolRequest.description())
    );

    return new ToolResponse(
        String.valueOf(createdTool.getId()),
        createdTool.getTitle(), createdTool.getLink(),
        createdTool.getDescription(),
        createdTool.getTags(),
        null
    );
  }

  public List<ToolResponse> getTools() {
    List<ToolResponse> tools = new ArrayList<>();
    toolRepository.findAll().forEach(tool -> {
      ToolResponse toolResponse = new ToolResponse(
          String.valueOf(tool.getId()),
          tool.getTitle(), tool.getLink(),
          tool.getDescription(),
          tool.getTags(),
          null
      );
      tools.add(toolResponse);
    });
    return tools;
  }
}
