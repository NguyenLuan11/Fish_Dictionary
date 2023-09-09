package com.tnl.fish.dto;

public class KindOfFishDTO extends BaseDTO<KindOfFishDTO> {
	
	private String nameKind;
	private String behavior;
	private String reproduction;	
	private String origin;
	private String wiki_reference;
	
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
}
