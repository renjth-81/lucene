package com.example.lucene.controller;

import java.io.IOException;

import org.apache.lucene.queryparser.classic.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.lucene.service.SearchService;

@RestController
public class SearchController {
	
	@Autowired
	SearchService searchService;
	
	@GetMapping("/search/{searchStr}")
	public int search(@PathVariable String searchStr) {
		try {
			return searchService.search(searchStr);
		} catch (ParseException | IOException e) {
			e.printStackTrace();
		}
		return -1;
	}

}
