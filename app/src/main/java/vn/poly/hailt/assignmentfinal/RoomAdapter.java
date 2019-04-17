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

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.RoomHolder> {

    private Context context;
    private List<Room> rooms;

    RoomAdapter(Context context, List<Room> rooms) {
        this.context = context;
        this.rooms = rooms;
    }

    @NonNull
    @Override
    public RoomHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_room, viewGroup, false);
        return new RoomHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomHolder holder, int i) {
        Room room = rooms.get(i);
        holder.tvRoomNumber.setText(context.getString(R.string.r_number, room.getRoomNumber()));
        holder.tvFloor.setText(context.getString(R.string.r_floor, room.getFloor()));
        holder.tvHotel.setText(context.getString(R.string.r_hotel, room.getHotelId()));
        holder.tvSingleRoom.setText(context.getString(R.string.r_single_room, room.isSingleRoom() ? "Phòng đơn" : "Khác"));
        holder.tvPrice.setText(context.getString(R.string.r_price, room.getPrice()));
        String roomStatus;
        if (room.getStatus() == 1) {
            roomStatus = "Đang trống";
        } else if (room.getStatus() == 2) {
            roomStatus = "Đã đặt";
        } else {
            roomStatus = "Không sử dụng";
        }
        holder.tvStatus.setText(context.getString(R.string.r_status, roomStatus));
        holder.tvDetail.setText(context.getString(R.string.r_detail, room.getDetail()));

        String pathImage = MainActivity.SERVER_URI + room.getImage().replace("\\", "/");
        Glide.with(context).load(pathImage).into(holder.imgRoom);
    }

    @Override
    public int getItemCount() {
        if (rooms == null) return 0;
        return rooms.size();
    }

    class RoomHolder extends RecyclerView.ViewHolder {

        private ImageView imgRoom;
        private TextView tvRoomNumber;
        private TextView tvFloor;
        private TextView tvHotel;
        private TextView tvSingleRoom;
        private TextView tvPrice;
        private TextView tvStatus;
        private TextView tvDetail;


        RoomHolder(@NonNull View itemView) {
            super(itemView);

            imgRoom = itemView.findViewById(R.id.imgRoom);
            tvRoomNumber = itemView.findViewById(R.id.tvRoomNumber);
            tvFloor = itemView.findViewById(R.id.tvFloor);
            tvHotel = itemView.findViewById(R.id.tvHotel);
            tvSingleRoom = itemView.findViewById(R.id.tvSingleRoom);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvStatus = itemView.findViewById(R.id.tvStatus);
            tvDetail = itemView.findViewById(R.id.tvDetail);
        }
    }

}
