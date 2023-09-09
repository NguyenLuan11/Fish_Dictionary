package com.tnl.fish.api.output;

import java.util.ArrayList;
import java.util.List;

import com.tnl.fish.dto.DiseaseOfFishDTO;


public class DiseaseOfFishOutput {

	private List<DiseaseOfFishDTO> listResult = new ArrayList<>();

	public List<DiseaseOfFishDTO> getListResult() {
		return listResult;
	}

	public void setListResult(List<DiseaseOfFishDTO> listResult) {
		this.listResult = listResult;
	}
}
