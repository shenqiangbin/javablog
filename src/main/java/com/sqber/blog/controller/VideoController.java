package com.sqber.blog.controller;

import com.sqber.blog.model.Video;
import com.sqber.blog.model.VideoJi;
import com.sqber.blog.model.VideoSource;
import com.sqber.blog.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VideoController {

    @Autowired
    VideoService videoService;

    @GetMapping("/video")
    public String index(){
        return "video";
    }

    @GetMapping("/video/list")
    public List<Video> videolist(String name){
        return videoService.getByName(name);
    }

    @GetMapping("/videoji/list")
    public List<VideoJi> videoJiList(String videoId){
        return videoService.getJis(videoId);
    }

    @GetMapping("/videoSource/list")
    public List<VideoSource> videoSourceList(String jiId){
        return  videoService.getVideoSourceByJi(jiId);
    }
}
