package com.sqber.blog.service;

import com.sqber.blog.base.SQLHelper;
import com.sqber.blog.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VideoService {

    @Autowired
    private SQLHelper sqlHelper;

    public Video getVideoById(Integer id) {
        String sql = "SELECT * from video where status = 1 and id = " + id;

        List<Video> list = sqlHelper.query(sql, null, Video.class);
        if (list != null && list.size() > 0)
            return list.get(0);
        return null;
    }

    public List<Video> getByName(String cartoonName) {
        String sql = "SELECT * from video where status = 1";
        List<Object> params = new ArrayList<>();
        params.add("%" + cartoonName + "%");

        List<Video> list = sqlHelper.query(sql, null, Video.class);
        return list;
    }

    public List<VideoJi> getJis(String videoId) {
        String sql = "SELECT * from videoJi where videoId = ?";
        List<Object> params = new ArrayList<>();
        params.add(videoId);
        List<VideoJi> list = sqlHelper.query(sql, params, VideoJi.class);
        return list;
    }

    public List<VideoSource> getVideoSourceByJi(String jiId) {
        String sql = "SELECT * from videoSource where videoJiId = ?";
        List<Object> params = new ArrayList<>();
        params.add(jiId);
        List<VideoSource> list = sqlHelper.query(sql, params, VideoSource.class);
        return list;
    }

}
