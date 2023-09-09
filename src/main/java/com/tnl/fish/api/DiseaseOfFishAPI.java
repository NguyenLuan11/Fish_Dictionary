package com.tnl.fish.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tnl.fish.api.output.DiseaseOfFishOutput;
import com.tnl.fish.dto.DiseaseOfFishDTO;
import com.tnl.fish.service.imp.DiseaseOfFishService;

@CrossOrigin
@RestController
public class DiseaseOfFishAPI {

	@Autowired
	private DiseaseOfFishService diseaseOfFishService;
	
	@GetMapping(value = "/api/disease-of-fish")
	public DiseaseOfFishOutput showDisease() {
		DiseaseOfFishOutput result = new DiseaseOfFishOutput();
		result.setListResult(diseaseOfFishService.findAll());
		return result;
	}
	
	@PostMapping(value = "/api/disease-of-fish")
	public DiseaseOfFishDTO createDisease(@RequestBody DiseaseOfFishDTO model) {
		return diseaseOfFishService.save(model);
	}
	
	@PutMapping(value = "/api/disease-of-fish/{id}")
	public DiseaseOfFishDTO updateDisease(@RequestBody DiseaseOfFishDTO model, @PathVariable("id") long id) {
		model.setId(id);
		return diseaseOfFishService.save(model);
	}
	
	@DeleteMapping(value = "/api/disease-of-fish")
	public void deleteDisease(@RequestBody long[] ids) {
		diseaseOfFishService.delete(ids);
	}
}
