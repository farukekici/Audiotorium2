package com.audiotorium2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.audiotorium2.entity.SongView;
import com.audiotorium2.service.IMusicService;

@RestController
@RequestMapping("/music")
public class MusicController {

	@Autowired
	IMusicService musicService;
	
	
	public List<SongView> search(String searchString) throws Exception {
		return musicService.search(searchString);
	}
	
	public String getSongPath(int id) throws Exception {
		return musicService.getSongPath(id);
	}
	
}
