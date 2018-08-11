/**
 * 
 */
package com.boot.learn.ehcache.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.boot.learn.model.Restaurent;
import com.boot.learn.repository.RestaurentRepository;

/**
 * @author Sanjeev
 *
 */

@Component
public class RestaurentCache {

	@Autowired
	RestaurentRepository restRepository;

	@Cacheable(value = "restaurentCache", key = "#restaurentId")
	public Optional<Restaurent> getRestaurentById(long restaurentId) {
		System.out.println("Retrieving from DB and setting to cache for: " + restaurentId);
		return restRepository.findById(restaurentId);
	}

}
