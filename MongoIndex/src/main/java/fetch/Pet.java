package fetch;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pets")
public class Pet {
    @Id
    private String id;

	private String name;

    @Indexed(direction = IndexDirection.ASCENDING)
    private String ownerId;

    @Indexed(direction = IndexDirection.ASCENDING)
    private String type;

    public Pet() {
	}

	public Pet(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
    public String toString() {
        return "Pet: " + this.name;
    }
}