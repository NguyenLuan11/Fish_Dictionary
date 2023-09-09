package com.tnl.fish.dto;

public class DiseaseOfFishDTO extends BaseDTO<DiseaseOfFishDTO> {

	private String nameDisease;
	private String manifestations;		
	private String cure;
	private String nameKind;
	
	public String getNameDisease() {
		return nameDisease;
	}

	public void setNameDisease(String nameDisease) {
		this.nameDisease = nameDisease;
	}

	public String getManifestations() {
		return manifestations;
	}

	public void setManifestations(String manifestations) {
		this.manifestations = manifestations;
	}

	public String getCure() {
		return cure;
	}

	public void setCure(String cure) {
		this.cure = cure;
	}

	public String getNameKind() {
		return nameKind;
	}

	public void setNameKind(String nameKind) {
		this.nameKind = nameKind;
	}
}
