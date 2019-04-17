package vn.poly.hailt.assignmentfinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String SERVER_URI = "http://192.168.137.222:3000";

    private RequestQueue mQueue;

    private HotelAdapter adapter;
    private List<Hotel> hotels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Khách sạn");

        RecyclerView rvHotel = findViewById(R.id.rvHotel);

        mQueue = Volley.newRequestQueue(this);

        hotels = new ArrayList<>();
        adapter = new HotelAdapter(this, hotels);
        rvHotel.setLayoutManager(new LinearLayoutManager(this));
        rvHotel.setAdapter(adapter);
        adapter.setOnItemClickActionListener(new HotelAdapter.OnClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("hotelId", hotels.get(position).getHotelId());
                startActivity(intent);
            }
        });

        getHotels();

    }

    private void getHotels() {
        String url = SERVER_URI + "/api/hotels";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray array = response.getJSONArray("hotels");
                            hotels.clear();
                            Log.e("arrayHotel", array.toString());
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject hotel = array.getJSONObject(i);

                                String hotelId = hotel.getString("_id");
                                String name = hotel.getString("name");
                                String city = hotel.getString("city");
                                String address = hotel.getString("address");
                                String owner = hotel.getString("owner");
                                long licenseNumber = hotel.getLong("license_number");
                                int totalFloor = hotel.getInt("total_floor");
                                String image = hotel.getString("image");

                                hotels.add(new Hotel(hotelId, name, city, address, owner, licenseNumber, totalFloor, image));
                            }
                            adapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mQueue.add(request);

    }
}
