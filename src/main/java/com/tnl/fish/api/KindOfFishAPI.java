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

import com.tnl.fish.api.output.KindOfFishOutput;
import com.tnl.fish.dto.KindOfFishDTO;
import com.tnl.fish.service.imp.KindOfFishService;

@CrossOrigin
@RestController
public class KindOfFishAPI {

	@Autowired
	private KindOfFishService kindOfFishService;
	
	@GetMapping(value = "/api/kind-of-fish")
	public KindOfFishOutput showKindOfFish() {
		KindOfFishOutput result = new KindOfFishOutput();
		result.setListResult(kindOfFishService.findAll());
		return result;
	}
	
	@PostMapping(value = "/api/kind-of-fish")
	public KindOfFishDTO createKind(@RequestBody KindOfFishDTO model) {
		return kindOfFishService.save(model);
	}
	
	@PutMapping(value = "/api/kind-of-fish/{id}")
	public KindOfFishDTO updateKind(@RequestBody KindOfFishDTO model, @PathVariable("id") long id) {
		model.setId(id);
		return kindOfFishService.save(model);
	}
	
	@DeleteMapping(value = "/api/kind-of-fish")
	public void deleteKind(@RequestBody long[] ids) {
		kindOfFishService.delete(ids);
	}
}
