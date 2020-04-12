package sjsu.cmpe277.myandroidmulti.Network

import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://api.openweathermap.org"//


/**
 * Use the Retrofit builder to build a retrofit object using a Scalar converter
 * want Retrofit to fetch a JSON response from the web service, and return it as a String
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create()) //Retrofit has a ScalarsConverter that supports strings and other primitive types
    .baseUrl(BASE_URL)
    .build() //create the Retrofit object.


/**
 * A public interface that exposes the [getProperties] method
 */
interface WeatherApiService {
    @GET("/data/2.5/weather") //realestate Retrofit appends the endpoint to the base URL
    fun getProperties(@Query("q") city: String, @Query("appid") apiKey: String):
            Call<String>
//    fun getProperties():
//            Call<String>
}

/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 * each time your app calls WeatherApi.retrofitService, it will get a singleton Retrofit object that implements ApiService.
 */
object WeatherApi {
    val retrofitService : WeatherApiService by lazy {
        retrofit.create(WeatherApiService::class.java) }
    //The Retrofit create() method creates the Retrofit service itself with the ApiService interface.
}
