package com.example.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.bean.CO0TableBean;
import com.example.project.form.CO01Form;
import com.example.project.service.CO01Service;

@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:8081" })
@RestController
@RequestMapping("/")
public class CO01Controller {

	@Autowired
	CO01Service cO01Service;

	// 初期表示
	@GetMapping("/CO01")
	public List<CO0TableBean> init(@ModelAttribute CO01Form form) {
		return cO01Service.getSearch(form);
	}

	// searchボタン押下
	@GetMapping("/CO01Search")
	public List<CO0TableBean> getTest(@ModelAttribute CO01Form form) {
		return cO01Service.getSearch(form);
	}
}