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

import com.tnl.fish.api.output.UserOutput;
import com.tnl.fish.dto.UserDTO;
import com.tnl.fish.service.imp.UserService;

@CrossOrigin
@RestController
public class UserAPI {

	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/api/user")
	public UserOutput showUser(@RequestParam(value = "page", required = false) Integer page,
								@RequestParam(value = "limit", required = false) Integer limit) {
		UserOutput result = new UserOutput();
		
		if(page != null && limit != null) {		// Have page & limit --> paging
			// Set page
			result.setPage(page);
			// Set list of User
			Pageable pageable = new PageRequest(page - 1, limit);
			result.setListResult(userService.findAll(pageable));
			// Set total page
			result.setTotalPage((int) Math.ceil((double) userService.totalItem() / limit));
		} else {
			result.setListResult(userService.findAll());
		}
		return result;
	}
	
	@PostMapping(value = "/api/user")
	public UserDTO createUser(@RequestBody UserDTO model) {
		return userService.save(model);
	}
	
	@PutMapping(value = "/api/user/{id}")
	public UserDTO updateUser(@RequestBody UserDTO model, @PathVariable("id") long id) {
		model.setId(id);
		return userService.save(model);
	}
	
	@DeleteMapping(value =  "/api/user")
	public void deleteUser(@RequestBody long[] ids) {
		userService.delete(ids);
	}
}
