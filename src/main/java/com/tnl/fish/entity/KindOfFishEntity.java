package com.tnl.fish.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "kind_of_fish")
public class KindOfFishEntity extends BaseEntity {
	
	@Column
	private String nameKind;
	
	@Column
	private String behavior;	// Hành vi
	
	@Column
	private String reproduction;	// Sinh sản
	
	@Column
	private String origin;		// Nguồn gốc
	
	@Column
	private String wiki_reference;
	
	// Foreign key kindoffish_fishes
	@OneToMany(mappedBy = "kind")
	private List<FishesEntity> fishes = new ArrayList<>();
	
	// Foreign key kindoffish_diseaseoffish
	@OneToMany(mappedBy = "kind")
	private List<DiseaseOfFishEntity> diseases = new ArrayList<>();

	public String getNameKind() {
		return nameKind;
	}

	public void setNameKind(String nameKind) {
		this.nameKind = nameKind;
	}

	public String getBehavior() {
		return behavior;
	}

	public void setBehavior(String behavior) {
		this.behavior = behavior;
	}

	public String getReproduction() {
		return reproduction;
	}

	public void setReproduction(String reproduction) {
		this.reproduction = reproduction;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getWiki_reference() {
		return wiki_reference;
	}

	public void setWiki_reference(String wiki_reference) {
		this.wiki_reference = wiki_reference;
	}

	public List<FishesEntity> getFishes() {
		return fishes;
	}

	public void setFishes(List<FishesEntity> fishes) {
		this.fishes = fishes;
	}

	public List<DiseaseOfFishEntity> getDiseases() {
		return diseases;
	}

	public void setDiseases(List<DiseaseOfFishEntity> diseases) {
		this.diseases = diseases;
	}
}
