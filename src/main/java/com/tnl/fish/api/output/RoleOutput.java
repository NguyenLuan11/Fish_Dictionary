package com.tnl.fish.api.output;

import java.util.ArrayList;
import java.util.List;

import com.tnl.fish.dto.RoleDTO;

public class RoleOutput {

	private List<RoleDTO> listResult = new ArrayList<>();

	public List<RoleDTO> getListResult() {
		return listResult;
	}

	public void setListResult(List<RoleDTO> listResult) {
		this.listResult = listResult;
	}
}
