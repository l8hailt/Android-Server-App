package vn.poly.hailt.assignmentfinal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.HotelHolder> {

    private Context context;
    private List<Hotel> hotels;
    private OnClickListener listener;

    HotelAdapter(Context context, List<Hotel> hotels) {
        this.context = context;
        this.hotels = hotels;
    }

    public interface OnClickListener {
        void onItemClick(int position);
    }

    void setOnItemClickActionListener(OnClickListener listener) {
        this.listener = listener;
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
        holder.tvName.setText(context.getString(R.string.h_name, hotel.getName()));
        holder.tvCity.setText(context.getString(R.string.h_city, hotel.getCity()));
        holder.tvAddress.setText(context.getString(R.string.h_address, hotel.getAddress()));
        holder.tvOwner.setText(context.getString(R.string.h_owner, hotel.getOwner()));
        holder.tvLicenseNumber.setText(context.getString(R.string.h_license_number, hotel.getLicenseNumber()));
        holder.tvTotalFloor.setText(context.getString(R.string.h_total_floor, hotel.getTotalFloor()));

        String pathImage = HotelActivity.SERVER_URI + hotel.getImage().replace("\\", "/");
        Glide.with(context).load(pathImage).into(holder.imgHotel);
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
            tvCity = itemView.findViewById(R.id.tvFloor);
            tvAddress = itemView.findViewById(R.id.tvHotel);
            tvOwner = itemView.findViewById(R.id.tvSingleRoom);
            tvLicenseNumber = itemView.findViewById(R.id.tvPrice);
            tvTotalFloor = itemView.findViewById(R.id.tvStatus);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(getLayoutPosition());
                }
            });
        }
    }

}
