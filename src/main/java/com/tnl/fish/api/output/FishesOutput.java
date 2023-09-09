package com.tnl.fish.api.output;

import java.util.ArrayList;
import java.util.List;

import com.tnl.fish.dto.FishesDTO;


public class FishesOutput {

	private List<FishesDTO> listResult = new ArrayList<>();
	private int page;
	private int totaPage;

	public List<FishesDTO> getListResult() {
		return listResult;
	}

	public void setListResult(List<FishesDTO> listResult) {
		this.listResult = listResult;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotaPage() {
		return totaPage;
	}

	public void setTotaPage(int totaPage) {
		this.totaPage = totaPage;
	}
}
