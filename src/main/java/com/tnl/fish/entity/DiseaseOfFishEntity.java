package com.tnl.fish.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "disease_of_fish")
public class DiseaseOfFishEntity extends BaseEntity {
	
	@Column
	private String nameDisease;
	
	@Column
	private String manifestations;		// Biểu hiện
	
	@Column
	private String cure;		// Chữa trị

	// Foreign key kindoffish_diseaseoffish
	@ManyToOne
	@JoinColumn(name = "kind_id")
	private KindOfFishEntity kind;

	public KindOfFishEntity getKind() {
		return kind;
	}

	public void setKind(KindOfFishEntity kind) {
		this.kind = kind;
	}

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
}
