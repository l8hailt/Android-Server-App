package vn.poly.hailt.assignmentfinal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.HotelHolder> {

    private Context context;
    private List<Hotel> hotels;

    public HotelAdapter(Context context, List<Hotel> hotels) {
        this.context = context;
        this.hotels = hotels;
    }

    @NonNull
    @Override
    public HotelHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_hotel, viewGroup, false);
        return new HotelHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelHolder holder, int i) {
        Hotel hotel = hotels.get(i);
        holder.tvName.setText(hotel.getName());
        holder.tvCity.setText(hotel.getCity());
        holder.tvAddress.setText(hotel.getAddress());
        holder.tvOwner.setText(hotel.getOwner());
        holder.tvLicenseNumber.setText("" + hotel.getLicenseNumber());
        holder.tvTotalFloor.setText("" + hotel.getTotalFloor());

    }

    @Override
    public int getItemCount() {
        if (hotels == null) return 0;
        return hotels.size();
    }

    class HotelHolder extends RecyclerView.ViewHolder {

        private ImageView imgHotel;
        private TextView tvName;
        private TextView tvCity;
        private TextView tvAddress;
        private TextView tvOwner;
        private TextView tvLicenseNumber;
        private TextView tvTotalFloor;


        HotelHolder(@NonNull View itemView) {
            super(itemView);

            imgHotel = itemView.findViewById(R.id.imgHotel);
            tvName = itemView.findViewById(R.id.tvName);
            tvCity = itemView.findViewById(R.id.tvCity);
            tvAddress = itemView.findViewById(R.id.tvAddress);
            tvOwner = itemView.findViewById(R.id.tvOwner);
            tvLicenseNumber = itemView.findViewById(R.id.tvLicenseNumber);
            tvTotalFloor = itemView.findViewById(R.id.tvTotalFloor);
        }
    }

}
