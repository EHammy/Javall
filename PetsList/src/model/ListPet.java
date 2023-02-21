package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pets")
public class ListPet {
	@Id
	@Column(name = "NAME")
	private String name;
	
	@Column(name="BREED")
	private String breed;
	
	@Column(name = "WEIGHT")
	private String weight;
	
	
	//default no arg constructor
	public ListPet() {
		
	}
	//helper constructor
	public ListPet(String name, String breed, String weight){
		this.name = name;
		this.breed = breed;
		this.weight = weight;
	}
	public String getName() {
		return name;
	}
	public String getBreed() {
		return breed;
	}
	public String getWeight() {
		return weight;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	//helper method
	@Override
	public String toString(){
		return this.name + " --- " + this.breed + " --- " + this.weight;
	}
}
