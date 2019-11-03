package ir.amir3398.train.model;

import com.google.gson.annotations.SerializedName;

public class PostItem {
    @SerializedName("id")
    private String postId;
    private String user_id;
    private String description;
    private String image;
    private String image_user;
    private String date;
    private String comment;
    private String countComment;
    private String countLike;
    @SerializedName("comment_id")
    private String commentId;

    public String getCommentId() { return commentId;    }

    public String getCountLike() {
        return countLike;
    }

    public String getCountComment() {
        return countComment;
    }

    public String getComment() {
        return comment;
    }

    public String getPostId() { return postId;    }

    public String getUser_id() {
        return user_id;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public String getDate() {
        return date;
    }

    public String getImage_user() {
        return image_user;
    }
}
