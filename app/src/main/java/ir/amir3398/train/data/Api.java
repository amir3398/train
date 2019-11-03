package ir.amir3398.train.data;


import ir.amir3398.train.model.JsonResponseModel;
import ir.amir3398.train.model.PostModel;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {

    @FormUrlEncoded
    @POST("reg.php")
    Call<JsonResponseModel> registerUser(@Field("name") String name, @Field("family") String family
            , @Field("sex") String sex, @Field("user") String username, @Field("pass") String password,
                                         @Field("image") String image, @Field("picname") String picname);

    @GET("login.php")
    Call<JsonResponseModel> loginUser(@Query("username") String username, @Query("password") String password);

    @FormUrlEncoded
    @POST("newpost.php")
    Call<JsonResponseModel> newpost(@Field("username") String username, @Field("image") String image,
                                    @Field("picname") String picname, @Field("des") String des);

    @GET("getPost.php")
    Call<PostModel> getPost();

    @GET("getMyPost.php")
    Call<PostModel> getMyPost(@Query("username") String username);


    @GET("getPostFriend.php")
    Call<PostModel> getPostFriend(@Query("username") String username);

    @FormUrlEncoded
    @POST("getSave.php")
    Call<PostModel> getSave(@Field("username") String username);

    @GET("getComment.php")
    Call<PostModel> getComment(@Query("postid") String postid);

    @GET("deletePost.php")
    Call<JsonResponseModel> deletePost(@Query("postid") String postid);

    @GET("getLike.php")
    Call<PostModel> getLike(@Query("postid") String postid);

    @FormUrlEncoded
    @POST("verify.php")
    Call<JsonResponseModel> verify(@Field("username") String username, @Field("os") String os);

    @FormUrlEncoded
    @POST("newComment.php")
    Call<JsonResponseModel> newComment(@Field("username") String username, @Field("comment") String comment,
                                       @Field("postid") String postid);

    @FormUrlEncoded
    @POST("like.php")
    Call<JsonResponseModel> like(@Field("userid") String userid, @Field("postid") String postid);

    @FormUrlEncoded
    @POST("getLikeColor.php")
    Call<JsonResponseModel> getLikeColor(@Field("userid") String userid, @Field("postid") String postid);

    @FormUrlEncoded
    @POST("getCommentColor.php")
    Call<JsonResponseModel> getCommentColor(@Field("userid") String userid, @Field("postid") String postid);

    @FormUrlEncoded
    @POST("getSaveColor.php")
    Call<JsonResponseModel> getSaveColor(@Field("username") String username, @Field("postid") String postid);

    @FormUrlEncoded
    @POST("save.php")
    Call<JsonResponseModel> save(@Field("username") String username, @Field("postid") String postid);

    @FormUrlEncoded
    @POST("newFriend.php")
    Call<JsonResponseModel> newFriend(@Field("username_friend") String username_friend, @Field("username_me") String username_me);

    @FormUrlEncoded
    @POST("getFriend.php")
    Call<JsonResponseModel> getFriend(@Field("username_friend") String username_friend, @Field("username_me") String username_me);


    @FormUrlEncoded
    @POST("block.php")
    Call<JsonResponseModel> block(@Field("username_blocked") String username_blocked, @Field("username_blocker") String username_blocker);

    @FormUrlEncoded
    @POST("getBlock.php")
    Call<JsonResponseModel> getBlock(@Field("username_blocked") String username_blocked, @Field("username_blocker") String username_blocker);

    @FormUrlEncoded
    @POST("updateImageUser.php")
    Call<JsonResponseModel> updateImageUser(@Field("username") String username,
                                            @Field("image") String image, @Field("picname") String picname);

    @FormUrlEncoded
    @POST("updatePasswordUser.php")
    Call<JsonResponseModel> updatePasswordUser(@Field("username") String username,
                                               @Field("password") String password);

    @FormUrlEncoded
    @POST("getPasswordUser.php")
    Call<JsonResponseModel> getPasswordUser(@Field("username") String username,
                                            @Field("password") String password);
    @FormUrlEncoded
    @POST("deleteComment.php")
    Call<JsonResponseModel> deleteComment(@Field("commentid") String commentid);
}
