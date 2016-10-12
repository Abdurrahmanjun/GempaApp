package gempa.kampusdeveloper.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import gempa.kampusdeveloper.R;
import gempa.kampusdeveloper.model.Gempa;

/**
 * Created by Dodi Rivaldi on 12/10/2016.
 */

public class DataGempaHolder extends RecyclerView.ViewHolder{

    TextView txttgl, txtwaktu, txtlintangbujur, txtmagnitude, txtkedalaman, txtlokasi, txtdirasakan;
    ImageView img;

    public DataGempaHolder(View itemView) {
        super(itemView);
        txttgl = (TextView) itemView.findViewById(R.id.txttgl);
        txtwaktu = (TextView) itemView.findViewById(R.id.txtwaktu);
        txtlintangbujur = (TextView) itemView.findViewById(R.id.txtlintangbujur);
        txtmagnitude = (TextView) itemView.findViewById(R.id.txtmagnitude);
        txtkedalaman = (TextView) itemView.findViewById(R.id.txtkedalaman);
        txtlokasi = (TextView) itemView.findViewById(R.id.txtlokasi);
        txtdirasakan = (TextView) itemView.findViewById(R.id.txtdirasakan);
        img = (ImageView) itemView.findViewById(R.id.img);
    }

    public void bind(Context context, Gempa gempa) {
        txttgl.setText("Tanggal : " + gempa.getTgl()+"");
        txtwaktu.setText("Waktu : " + gempa.getWaktu()+"");
        txtlintangbujur.setText("Lintang Bujur : " + gempa.getLintang_bujur()+"");
        txtmagnitude.setText("Magnitudo " + gempa.getMagnitudo()+"");
        txtkedalaman.setText("Kedalaman : " + gempa.getKedalaman()+"");
        txtlokasi.setText("Lokasi : " + gempa.getLokasi()+"");
        txtdirasakan.setText("Dirasakan : " + gempa.getDirasakan()+"");
        Glide.with(context).load(gempa.getImg()).into(img);
    }
}



