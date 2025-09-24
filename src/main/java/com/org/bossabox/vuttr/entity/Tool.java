package com.org.bossabox.vuttr.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_tool")
public class Tool {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String title;

  private String link;

  private String description;

  @ElementCollection
  @CollectionTable(
      name = "tb_tag_tool",
      joinColumns = @JoinColumn(name = "tool_id")
  )
  @Column(name = "tag")
  private List<String> tags;

  public Tool(String title, String link, List<String> tags, String description) {
    this.title = title;
    this.link = link;
    this.tags = tags;
    this.description = description;
  }

  public Tool() {}

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  public long getId() {
    return id;
  }
}
