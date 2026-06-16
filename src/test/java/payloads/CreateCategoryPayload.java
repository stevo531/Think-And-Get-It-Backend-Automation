package payloads;

public class CreateCategoryPayload {
private String name;
private String description;
private String parentId;

public CreateCategoryPayload(String name, String description, String parentId){
    this.name = name;
    this.description = description;
    this.parentId = parentId;

}

public String getName() {
    return name;
}
public String getDescription() {
    return description;
}
public String getParentId() {
    return parentId;
}
}
