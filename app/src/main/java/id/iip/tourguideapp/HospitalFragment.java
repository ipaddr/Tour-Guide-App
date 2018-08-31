package id.iip.tourguideapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class HospitalFragment extends Fragment {
    private List<Model> models;
    private ListView lv;

    public HospitalFragment(){}

    public static HospitalFragment newInstance(){
        HospitalFragment hf = new HospitalFragment();
        return hf;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        models = new ArrayList<>();
        models.add(new Model(getString(R.string.HospitalMDjamil), R.drawable.rs_djamil));
        models.add(new Model(getString(R.string.HospitalRSUDPadangPanjang), R.drawable.rs_pp2));
        models.add(new Model(getString(R.string.HospitalBMC), R.drawable.rs_bmc));
        models.add(new Model(getString(R.string.HospitalIbnuSina), R.drawable.rs_ibnu));
        models.add(new Model(getString(R.string.HospitalSelaguri), R.drawable.rs_selaguri));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rv = LayoutInflater.from(this.getContext()).inflate(R.layout.event_frag, container, false);
        lv = (ListView)rv.findViewById(R.id.list_event);
        lv.setAdapter(new ArrayAdapter<Model>(getContext(), android.R.layout.simple_list_item_1, models){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = LayoutInflater.from(getActivity()).inflate(R.layout.image_text_item, parent, false);

                ImageView iv = (ImageView)view.findViewById(R.id.iv);
                iv.setImageResource(getItem(position).img);

                TextView tv = (TextView)view.findViewById(R.id.tv);
                tv.setText(getItem(position).name);

                return view;
            }
        });
        return rv;
    }
}
