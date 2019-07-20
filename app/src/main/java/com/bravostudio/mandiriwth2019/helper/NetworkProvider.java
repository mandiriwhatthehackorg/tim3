package com.bravostudio.mandiriwth2019.helper;

import com.bravostudio.mandiriwth2019.datamodel.Response;
import com.bravostudio.mandiriwth2019.datamodel.ResponseProduct;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * Created by jouvyalifpradewo on 2019-07-20.
 */
public interface NetworkProvider {

    @Headers({
            "Accept: application/json",
            "Authorization: Bearer eyJraWQiOiJqd3RrZXkiLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJlNzEyMmRhMy0wMzg1LTRiZjEtYjNiNi02ZmEzYWEwYmUxZjIiLCJhdWQiOlsiZGI4MDA5ODEtNGU3NC00MjNjLWI4MGYtMTBiYmZjMmFkNTI2IiwibWFuZGlyaV9oYWNrYXRob25fdGVhbSJdLCJuYmYiOjE1NjM1ODcxMzksImlzcyI6Imh0dHBzOlwvXC93d3cuYmFua21hbmRpcmkuY28uaWRcLyIsImV4cCI6MTU2MzgwMzEzOSwiaWF0IjoxNTYzNTg3MTM5LCJhcHBfaWQiOiJkYjgwMDk4MS00ZTc0LTQyM2MtYjgwZi0xMGJiZmMyYWQ1MjYifQ.a10ovOBHaB6gCDUtNvm-jXMMxJY7qvP2jbc_Fj0nTn1kAU2WU9aJRUCB1_ontkfNDTOldHgLPxxCj9lndEjtwkM4vZfnwuaLvguJ_UJtv_X_OICc5-32PGnrglA9o6sf_zyBXVFcnl4a2Nc4D-kCQYFkXEM4nXI4vR_a-AMA4y4"
    })
    @GET("customer/{cif}")
    Call<Response> getCustomer(@Path("cif") Long cif);

    @Headers({
            "Accept: application/json",
            "Authorization: Bearer eyJraWQiOiJqd3RrZXkiLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJlNzEyMmRhMy0wMzg1LTRiZjEtYjNiNi02ZmEzYWEwYmUxZjIiLCJhdWQiOlsiZGI4MDA5ODEtNGU3NC00MjNjLWI4MGYtMTBiYmZjMmFkNTI2IiwibWFuZGlyaV9oYWNrYXRob25fdGVhbSJdLCJuYmYiOjE1NjM1ODcxMzksImlzcyI6Imh0dHBzOlwvXC93d3cuYmFua21hbmRpcmkuY28uaWRcLyIsImV4cCI6MTU2MzgwMzEzOSwiaWF0IjoxNTYzNTg3MTM5LCJhcHBfaWQiOiJkYjgwMDk4MS00ZTc0LTQyM2MtYjgwZi0xMGJiZmMyYWQ1MjYifQ.a10ovOBHaB6gCDUtNvm-jXMMxJY7qvP2jbc_Fj0nTn1kAU2WU9aJRUCB1_ontkfNDTOldHgLPxxCj9lndEjtwkM4vZfnwuaLvguJ_UJtv_X_OICc5-32PGnrglA9o6sf_zyBXVFcnl4a2Nc4D-kCQYFkXEM4nXI4vR_a-AMA4y4"
    })
    @GET("product")
    Call<ResponseProduct> getProductList();
}
