package com.qingguatang.java5minute.course5;

import java.util.*;

import com.qingguatang.java5minute.course4.model.Comment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Pinquan
 * @date 2018/10/29
 */

@Controller
public class CommentPostControl {
    private static Map<String,List<Comment>> comments = new HashMap<>();

    @RequestMapping(value = "/comment/post")
    public String post(@RequestParam(value =  "songId")String songId,Comment comment){
        Date commentTime = new Date();
        comment.setCommentTime(commentTime);
        comment.setId(UUID.randomUUID().toString());
        // xxx-xxx-xxx-xxx
        comments.computeIfAbsent(songId,k->new ArrayList<>()).add(comment);

        List<Comment> commentList = comments.get(songId);
        Collections.sort(commentList, new Comparator<Comment>() {
            @Override
            public int compare(Comment o1, Comment o2) {
                if(o1.getCommentTime().after(o2.getCommentTime())){
                    return -1;
                }
                return 0;
            }
        });
        return "redirect:/songinfo?songId="+songId;

    }
    public List<Comment>getComments(String songId){
        return comments.get(songId);
    }
}
