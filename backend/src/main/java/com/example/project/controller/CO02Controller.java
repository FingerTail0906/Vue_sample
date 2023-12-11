package com.example.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.entity.TNoticeEntity;
import com.example.project.service.CO01Service;

@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:8081" })
@RestController
@RequestMapping("/")
public class CO02Controller {

	@Autowired
	CO01Service cO01Service;

	@GetMapping("/CO02")
	public List<TNoticeEntity> init() {
		System.out.println("CCC");
		List<TNoticeEntity> list = cO01Service.getTNoticeList();
		return list;
	}

	// パラメータ受信
	@GetMapping("/CO02/AAA")
	public String getTest(@RequestParam("key1") String key1, @RequestParam("key2") String key2) {
		System.out.println("AAA");
		return "aaa";
	}
}