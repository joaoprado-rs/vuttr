CREATE TABLE tb_tool (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    title VARCHAR NOT NULL,
    link VARCHAR NOT NULL,
    description VARCHAR NOT NULL,
)

CREATE TABLE tb_tag_tool (
    tool_id BIGINT NOT NULL,
    tool VARCHAR NOT NULL,
    FOREIGN KEY (tool_id) REFERENCES tb_tool(id)
)