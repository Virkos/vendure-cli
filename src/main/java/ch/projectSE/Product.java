package ch.projectSE;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {
    private String id;
    private String name;
    private String slug;
    private String description;

    public Product() {}

    public Product(String id, String name, String slug, String description) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.description = description;
    }
    public String getId() { return id;}
    public String setId(String Id) {
        return this.id = Id; }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
   public String getSlug() {
        return slug;
   }
   public void setSlug(String slug) {
       this.slug = slug;
   }
   public String getDescription() {
        return description;
   }
   public void setDescription(String description) {
        this.description = description;
   }
}
