package com.tnl.fish.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "fishes")
public class FishesEntity extends BaseEntity {

	@Column
	private String nameFish;
	
	@Column
	private String image;
	
	@Column
	private String color;
	
	@Column
	private String shortDescription;
	
	// Foreign key kindoffish_fishes
	@ManyToOne
	@JoinColumn(name = "kind_id")
	private KindOfFishEntity kind;

	public KindOfFishEntity getKind() {
		return kind;
	}

	public void setKind(KindOfFishEntity kind) {
		this.kind = kind;
	}

	public String getNameFish() {
		return nameFish;
	}

	public void setNameFish(String nameFish) {
		this.nameFish = nameFish;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
}
