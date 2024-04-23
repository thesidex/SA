package fetch;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
import java.util.stream.Collectors;

@Document
public class Owner {

	@Id
    private String name;
    private List<Pet> pets;
    
	public Owner() {
	}

	public Owner(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Pet> getPets() {
		return pets;
	}
	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}  
	
	@Override
    public String toString() {
        return "Owner{" +
               "name='" + name + '\'' +
               ", pets=" + (pets != null ? pets.stream().map(Pet::toString).collect(Collectors.joining(", ")) : "No Pets") +
               '}';
    }
}