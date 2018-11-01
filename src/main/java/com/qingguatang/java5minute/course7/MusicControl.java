package com.qingguatang.java5minute.course7;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Pinquan
 * @date 2018/10/31
 */
@Controller
public class MusicControl {
    private static final Map<String,String> musics = new HashMap<>();
    @RequestMapping(value = "/song/music")
    @ResponseBody
    public String getMusicSrc(String songId) {
        return musics.get(songId);
    }
    @PostConstruct
    public void init() {
        musics.put("35847388", "http://153.37.232.146/amobile.music.tc.qq.com/C400000Cq7te18mQsP.m4a?guid=9000099046&vkey=C1FE008DE98F96D4185865DC2791FBEE4DD8D48F5E49CBC58171BE947689A218B868BEE55A7DB0479EF89155090CDC0D5ED679BE4E3DDBDB&uin=0&fromtag=66");
        musics.put("2117009",
                "https://m10.music.126.net/20181101125628/ffc63f4dcb706058c9ac742cf6db8490/ymusic/56e1/ec67/c249/c07799185b858908bd85268507f44b1e.mp3");
    }
}
