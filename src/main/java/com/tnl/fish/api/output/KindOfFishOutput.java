package com.tnl.fish.api.output;

import java.util.ArrayList;
import java.util.List;

import com.tnl.fish.dto.KindOfFishDTO;


public class KindOfFishOutput {

	private List<KindOfFishDTO> listResult = new ArrayList<>();

	public List<KindOfFishDTO> getListResult() {
		return listResult;
	}

	public void setListResult(List<KindOfFishDTO> listResult) {
		this.listResult = listResult;
	}
}
