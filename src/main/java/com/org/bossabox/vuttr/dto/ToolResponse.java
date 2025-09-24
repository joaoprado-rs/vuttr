package com.org.bossabox.vuttr.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record ToolResponse(
    String id, String title, String link, String description, List<String> tags, List<Error> errors
) {
}
