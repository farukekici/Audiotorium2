package com.audiotorium2.service;

import java.util.List;

import com.audiotorium2.entity.SongView;

public interface IMusicService {

	public List<SongView> search(String searchString) throws Exception;
	
	public String getSongPath(int id) throws Exception;
}
