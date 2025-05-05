package com.sample.servicestatus

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ServiceStatus : AppCompatActivity() {

    lateinit var bottomNavigationView : BottomNavigationView
    lateinit var recyclerView: RecyclerView
    lateinit var myadapter : MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_status)

        recyclerView = findViewById(R.id.recyclerViewId)
        bottomNavigationView = findViewById(R.id.navBottomId)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val retrofitObject = RetrofitClient.createService(ApiInterface::class.java)
        val getEntireDataFromRetrofit = retrofitObject.getEntireData()

        getEntireDataFromRetrofit.enqueue(object : Callback<List<MyData>?> {
            override fun onResponse(p0: Call<List<MyData>?>, p1: Response<List<MyData>?>) {
                val responseList = p1.body()?: emptyList()
                myadapter = MyAdapter(this@ServiceStatus,responseList)
                recyclerView.adapter = myadapter
            }

            override fun onFailure(p0: Call<List<MyData>?>, p1: Throwable) {
                Toast.makeText(this@ServiceStatus, "Failed to render the data", Toast.LENGTH_SHORT).show()
            }
        })

        bottomNavigationView.setOnItemSelectedListener{ menuItem ->
            when (menuItem.itemId) {
                R.id.homeId -> {
                    true
                }
                R.id.notificationId -> {
                    Log.d("ServiceStatus", "Notification clicked")
                    replaceFragment(Notification_Fragment())
                    true
                }
                else -> false
            }
        }

    }

    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.frameConatiner,fragment).commit()
    }
}