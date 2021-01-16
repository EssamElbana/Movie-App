package com.example.movieapp

object Repository {
//    private val serverGateway = ServerGateway
//    private val jsonPlaceHolderApi: JsonPlaceHolderApi = serverGateway.createService(
//        JsonPlaceHolderApi::class.java)
//
//    override fun getPosts(callback: IRepository.Callback<List<Post>>) {
//        val call: Call<List<Post>> = jsonPlaceHolderApi.getPosts()
//
//        call.enqueue(object : Callback<List<Post>> {
//            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
//                if (!response.isSuccessful)
//                    callback.onFailure(response.message())
//                else {
//                    callback.onSuccess(response.body()!!)
//                }
//            }
//
//            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
//                callback.onFailure(t.message!!)
//            }
//        })
//    }
//
//    override fun getPostComments(postId: Int, callback: IRepository.Callback<List<Comment>>) {
//        val call: Call<List<Comment>> = jsonPlaceHolderApi.getPostComments(postId)
//
//        call.enqueue(object : Callback<List<Comment>> {
//            override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
//                if (!response.isSuccessful)
//                    callback.onFailure(response.message())
//                else {
//                    callback.onSuccess(response.body()!!)
//                }
//            }
//
//            override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
//                callback.onFailure(t.message!!)
//            }
//        })
//    }
}