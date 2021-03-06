package com.audiotorium2;

import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.audiotorium2.controller.MusicController;
import com.audiotorium2.entity.SongView;

@ManagedBean
@RequestScoped
@Component
@ViewScoped
public class SearchManagedBean {

	private String searchString;
	private List<SongView> songList;
	private int musicId;
	private String path;
	private String songName;
	private String artistName;
	
	@Autowired
	MusicController musicController;
	
	public String search() {
		
		try {
			songList= musicController.search(searchString);
		} catch (Exception e) {
			e.printStackTrace();
			RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
			return null; 
		}
		return "search-result.xhtml";
	}
	
	public String playMusic() {
		Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		try {
			path =musicController.getSongPath(Integer.parseInt(params.get("musicId")));
			songName = params.get("musicName");
			artistName = params.get("artistName");
		} catch (Exception e) {
			e.printStackTrace();
			RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
			return null; 
		}
		return "Music.xhtml";
	}
	
	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}


	public List<SongView> getSongList() {
		return songList;
	}


	public void setSongList(List<SongView> songList) {
		this.songList = songList;
	}

	public int getMusicId() {
		return musicId;
	}

	public void setMusicId(int musicId) {
		this.musicId = musicId;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	
	
}
