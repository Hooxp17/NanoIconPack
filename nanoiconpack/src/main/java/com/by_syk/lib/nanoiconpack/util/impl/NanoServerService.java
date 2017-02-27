/*
 * Copyright 2017 By_syk
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.by_syk.lib.nanoiconpack.util.impl;

import com.by_syk.lib.nanoiconpack.bean.ResResBean;
import com.google.gson.JsonArray;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by By_syk on 2017-02-24.
 */

public interface NanoServerService {
    @GET("/")
    Call<ResResBean> testServer();

    @FormUrlEncoded
    @POST("req/{iconpack}")
    Call<ResResBean<Integer>> reqRedraw(@Path("iconpack") String iconPack,
                               @FieldMap Map<String, String> fields);

    @GET("reqnum/{iconpack}/{pkg}")
    Call<ResResBean<Integer>> getReqNum(@Path("iconpack") String iconPack,
                               @Path("pkg") String targetPkg);

    @GET("reqtop/{iconpack}/{user}")
    Call<ResResBean<JsonArray>> getReqTop(@Path("iconpack") String iconPack,
                                          @Path("user") String user,
                                          @Query("limit") int limitNum,
                                          @Query("filter") boolean filter);

    @FormUrlEncoded
    @POST("reqfilter/{iconpack}/{user}")
    Call<ResResBean> filterPkg(@Path("iconpack") String iconPack,
                               @Path("user") String user,
                               @Field("pkg") String filterPkg);

    @DELETE("reqfilter/{iconpack}/{user}")
    Call<ResResBean> undoFilterPkg(@Path("iconpack") String iconPack,
                                   @Path("user") String user,
                                   @Query("pkg") String filterPkg);

    @GET("iconurl/{pkg}")
    Call<ResResBean<String>> getIconUrl(@Path("pkg") String pkg);
}
