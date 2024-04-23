package fetch;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Pet {
    private String name;
    private String ownerId;  

    public Pet() {}

    public Pet(String name, String type, String ownerId) {
        this.name = name;
        this.ownerId = ownerId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
}
