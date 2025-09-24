package com.org.bossabox.vuttr.dto;

import java.util.List;

public record ToolRequest(
    String title, String link, String description, List<String> tags
) {
}
