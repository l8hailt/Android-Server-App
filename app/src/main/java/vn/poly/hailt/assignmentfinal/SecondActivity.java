package vn.poly.hailt.assignmentfinal;

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

public class SecondActivity extends AppCompatActivity {

    private RequestQueue mQueue;

    private RoomAdapter adapter;
    private List<Room> rooms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Phòng");

        RecyclerView rvRoom = findViewById(R.id.rvRoom);

        mQueue = Volley.newRequestQueue(this);

        rooms = new ArrayList<>();
        adapter = new RoomAdapter(this, rooms);
        rvRoom.setLayoutManager(new LinearLayoutManager(this));
        rvRoom.setAdapter(adapter);

        getRooms();
    }

    private void getRooms() {
        String hotelId = getIntent().getStringExtra("hotelId");
        String url = MainActivity.SERVER_URI + "/api/rooms/" + hotelId;

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray array = response.getJSONArray("rooms");
                            rooms.clear();
                            Log.e("arrayRoom", array.toString());
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject room = array.getJSONObject(i);

                                String roomId = room.getString("_id");
                                String roomNumber = room.getString("room_number");
                                Log.e("roomNum", "run: " + roomNumber);
                                int floor = room.getInt("floor");

                                //hotel id
                                JSONObject hotel = room.getJSONObject("hotel_id");
                                String hotelId = hotel.getString("name");
                                Log.e("hotel", "run: " + hotel.getString("name"));

                                boolean singleRoom = room.getBoolean("single_room");
                                int price = room.getInt("price");
                                int status = room.getInt("status");
                                String image = room.getString("image");
                                String detail = room.getString("detail");

                                rooms.add(new Room(roomId, roomNumber, floor, hotelId, singleRoom, price, status, image, detail));
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

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
