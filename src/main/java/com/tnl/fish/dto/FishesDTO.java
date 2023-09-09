package com.tnl.fish.dto;

public class FishesDTO extends BaseDTO<FishesDTO> {

	private String nameFish;
	private String image;
	private String color;
	private String shortDescription;
	private String nameKind;

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

	public String getNameKind() {
		return nameKind;
	}

	public void setNameKind(String nameKind) {
		this.nameKind = nameKind;
	}
}
