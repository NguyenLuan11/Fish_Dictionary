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

import com.tnl.fish.api.output.RoleOutput;
import com.tnl.fish.dto.RoleDTO;
import com.tnl.fish.service.imp.RoleService;

@CrossOrigin
@RestController
public class RoleAPI {

	@Autowired
	private RoleService roleService;
	
	@GetMapping(value = "/api/role")
	public RoleOutput showRole() {
		RoleOutput result = new RoleOutput();
		result.setListResult(roleService.findAll());
		return result;
	}
	
	@PostMapping(value = "/api/role")
	public RoleDTO createRole(@RequestBody RoleDTO model) {
		return roleService.save(model);
	}
	
	@PutMapping(value = "/api/role/{id}")
	public RoleDTO updateRole(@RequestBody RoleDTO model, @PathVariable("id") long id) {
		model.setId(id);
		return roleService.save(model);
	}
	
	@DeleteMapping(value = "/api/role")
	public void deleteRole(@RequestBody long[] ids) {
		roleService.delete(ids);
	}
}
