package fauzi.hilmy.bottomnavigationlesson.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import fauzi.hilmy.bottomnavigationlesson.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {

        Bundle args = new Bundle();

        HomeFragment fragment = new HomeFragment();
//        fragment.setArguments(args);
        return fragment;
    }

    String [] campur = {"Gado - Gado", "Lontong Sayur", "Nasi Pecel", "Nasi Uduk", "Indomie","Jakarta", "Padang", "Palembang", "Surabaya", "Bandung"};
    int [] imgku = {R.drawable.gado, R.drawable.lontong, R.drawable.pecel, R.drawable.lemak, R.drawable.indomie,R.drawable.jakarta, R.drawable.padang, R.drawable.palembang, R.drawable.surabaya, R.drawable.bandung};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView view = new RecyclerView(getContext());
        view.setLayoutManager(new LinearLayoutManager(getContext()));
        view.setAdapter(new SimpleRVAdapter(campur));
        return view;
    }

    private class SimpleRVAdapter extends RecyclerView.Adapter<SimpleRVAdapter.MyViewHolder> {
        public SimpleRVAdapter(String[] makanan) {
        }

        @Override
        public SimpleRVAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.kuliner_item, null, false);
            return new MyViewHolder(v);
        }

        @Override
        public void onBindViewHolder(SimpleRVAdapter.MyViewHolder holder, int position) {
            holder.judul.setText(campur[position]);
            holder.img.setImageResource(imgku[position]);
        }

        @Override
        public int getItemCount() {
            return campur.length;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView judul;
            ImageView img;
            public MyViewHolder(View itemView) {
                super(itemView);
                judul = itemView.findViewById(R.id.judul);
                img = itemView.findViewById(R.id.img);
            }
        }
    }
}
