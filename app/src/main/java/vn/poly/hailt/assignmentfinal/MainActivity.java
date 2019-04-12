package vn.poly.hailt.assignmentfinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Socket mSocket;
    private RecyclerView rvHotel;
    private HotelAdapter adapter;
    private List<Hotel> hotels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvHotel = findViewById(R.id.rvHotel);

        hotels = new ArrayList<>();
        adapter = new HotelAdapter(this, hotels);
        rvHotel.setLayoutManager(new LinearLayoutManager(this));
        rvHotel.setAdapter(adapter);

        try {
            mSocket = IO.socket("http://192.168.137.54:3000");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        mSocket.connect();

        mSocket.on("server-send-hotel", onListHotel);

    }

    private Emitter.Listener onListHotel = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONObject object = (JSONObject) args[0];
                    try {
                        JSONArray array = object.getJSONArray("hotels");
                        hotels.clear();
                        Log.e("array", array.toString());
                        for (int i = 0; i < array.length(); i++) {
                            JSONObject hotel = array.getJSONObject(i);

                            String hotelId = hotel.getString("_id");
                            String name = hotel.getString("name");
                            String city = hotel.getString("city");
                            String address = hotel.getString("address");
                            String owner = hotel.getString("owner");
                            int licenseNumber = hotel.getInt("license_number");
                            int totalFloor = hotel.getInt("total_floor");

                            hotels.add(new Hotel(hotelId, name, city, address, owner, licenseNumber, totalFloor, ""));
                        }
                        adapter.notifyDataSetChanged();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    };
}
