package com.tnl.fish.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tnl.fish.api.output.FishesOutput;
import com.tnl.fish.dto.FishesDTO;
import com.tnl.fish.service.imp.FishesService;

@CrossOrigin
@RestController
public class FishesAPI {

	@Autowired
	private FishesService fishesService;
	
	@GetMapping(value = "/api/fishes")
	public FishesOutput showFishes(@RequestParam(value = "page", required = false) Integer page,
									@RequestParam(value = "limit", required = false) Integer limit) {
		FishesOutput result = new FishesOutput();
		
		if(page != null && limit != null) {		// Have page & limit --> paging
			// Set page
			result.setPage(page);
			// Set list of Fishes
			Pageable pageable = new PageRequest(page - 1, limit);
			result.setListResult(fishesService.findAll(pageable));
			// Set total page
			result.setTotaPage((int) Math.ceil((double) fishesService.totalItem() / limit));
		} else {		// Haven't page & limit --> no paging
			// Set list of Fishes
			result.setListResult(fishesService.findAll());
		}
		return result;
	}
	
	@PostMapping(value = "/api/fishes")
	public FishesDTO createFish(@RequestBody FishesDTO model) {
		return fishesService.save(model);
	}
	
	@PutMapping(value = "/api/fishes/{id}")
	public FishesDTO updateFish(@RequestBody FishesDTO model, @PathVariable("id") long id) {
		model.setId(id);
		return fishesService.save(model);
	}
	
	@DeleteMapping(value = "/api/fishes")
	public void deleteFish(@RequestBody long[] ids) {
		fishesService.delete(ids);
	}
}
