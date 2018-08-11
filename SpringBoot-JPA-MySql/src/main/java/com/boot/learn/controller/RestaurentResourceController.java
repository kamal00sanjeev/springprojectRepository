/**
 * 
 */
package com.boot.learn.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.learn.ehcache.config.RestaurentCache;
import com.boot.learn.model.Item;
import com.boot.learn.model.Menu;
import com.boot.learn.model.Restaurent;
import com.boot.learn.repository.MenuRepository;
import com.boot.learn.repository.RestaurentRepository;

/**
 * @author Sanjeev
 *
 */

@RestController
@RequestMapping(value = "/rest/restaurent")
public class RestaurentResourceController {

	@Autowired
	private RestaurentRepository restaurentRepository;

	@Autowired
	private MenuRepository menuRepository;
	
	@Autowired
	private RestaurentCache restaurentCache;


	@GetMapping(value = "/")
	public String checkMessage() {
		return "This is restaurent Page. It works fine!";
	}

	@GetMapping(value = "/all")
	public List<Restaurent> getAllRestaurentDetails() {
		return restaurentRepository.findAll();
	}

	@GetMapping(value = "/{id}")
	public Optional<Restaurent> getRestaurentDetailsById(@PathVariable final long id) {
		//return restaurentRepository.findById(id);
		return restaurentCache.getRestaurentById(id);
	}
	

	@PostMapping(value = "/addnew")
	public String persistNewRestaurent(@RequestBody final Restaurent restaurent) {
		restaurentRepository.save(restaurent);
		return "New Resturent added successfully!";
	}

	@DeleteMapping(value = "/delete/{id}")
	public String deleteRestaurent(@PathVariable final long id) {
		restaurentRepository.deleteById(id);
		return "Resturent with Id: " + id + " deleted successfully!";
	}

	//************ Menu related operation *****************
	@GetMapping(value = "/{restId}/menu")
	public Optional<Menu> getMenuDetailsByRestaurentId(@PathVariable final long restId) {
		Restaurent restaurent = restaurentRepository.getOne(restId);
		return menuRepository.findById(restaurent.getMenu().getMenuId());
	}

	@PostMapping(value = "/{restId}/menu")
	public String addMenuToRestaurent(@PathVariable final long restId, @RequestBody final Menu menu) {
		Restaurent restaurent = restaurentRepository.getOne(restId);
		restaurent.setMenu(menu);
		menuRepository.save(menu);
		return "Menu added successfully!";
	}

	//********** Menu-Item related operation ***********
	@PostMapping(value = "/{restId}/menu/item")
	public String addItemToRestaurentMenu(@PathVariable final long restId, @RequestBody final Item newItem) {
		Restaurent restaurent = restaurentRepository.getOne(restId);
		Menu currentMenu = restaurent.getMenu();
		currentMenu.getItems().add(newItem);
		menuRepository.save(currentMenu);
		return "Item - " + newItem.getItemName() + " has been added to Menu";

	}
	
	@GetMapping(value = "/{restId}/menu-items")
	public Set<Item> showRestaurentMenuItems(@PathVariable final long restId) {
		Restaurent restaurent = restaurentRepository.getOne(restId);
		return restaurent.getMenu().getItems();
	}

}
