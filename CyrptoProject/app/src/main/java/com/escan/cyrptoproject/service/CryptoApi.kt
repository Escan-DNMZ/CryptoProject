package com.escan.cyrptoproject.service

import com.escan.cyrptoproject.model.CryptoModel
import retrofit2.http.GET

interface CryptoApi {
    // https://raw.githubusercontent.com/atilsamancioglu/K21-JSONDataSet/master/crypto.json
    @GET("atilsamancioglu/K21-JSONDataSet/master/crypto.json")
    fun getData():io.reactivex.Observable<List<CryptoModel>>


    /* You can use Call if you want,
    but Rxjava is clearer than call but for this project the call is sufficient. */
   // fun getData():Call<List<CryptoModel>>

}