package com.ruturaj.android.spanishvocabulary;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class TenFragment extends Fragment {
    public TenFragment() {
        // Required empty public constructor
    }

    String[] listviewTitle = new String[]{
            "El clima", "La nube", "La niebla", "La humedad",
            "El huracán", "La lluvia", "La nieve", "El sol",
            "La temperatura",
    };


    int[] listviewImage = new int[]{
            R.drawable.weather, R.drawable.cloud, R.drawable.fog, R.drawable.humidity,
            R.drawable.hurricane, R.drawable.rain, R.drawable.snow, R.drawable.sun,
            R.drawable.temperature,
    };

    int[] listviewSound = new int[]{
            R.raw.weather, R.raw.cloud, R.raw.fog, R.raw.humidity,
            R.raw.hurricane, R.raw.rain, R.raw.snow, R.raw.sun,
            R.raw.temperature,
    };

    String[] listviewShortDescription = new String[]{
            "The weather", "The cloud", "The fog", "The humidity",
            "The hurricane", "The rain", "The snow", "The sun",
            "The temperature",
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ten, container, false);


        ListView listView= (ListView) view.findViewById(R.id.fragmentTen);

        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < 9; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("listview_title", listviewTitle[i]);
            hm.put("listview_discription", listviewShortDescription[i]);
            hm.put("listview_image", Integer.toString(listviewImage[i]));
            aList.add(hm);
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    MediaPlayer animals = MediaPlayer.create(getContext(), listviewSound[position]);
                    animals.start();
            }
        });

        String[] from = {"listview_image", "listview_title", "listview_discription"};
        int[] to = {R.id.listview_image, R.id.listview_item_title, R.id.listview_item_short_description};

        SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(), aList, R.layout.listview_activity, from, to);

        listView.setAdapter(simpleAdapter);

        // Inflate the layout for this fragment
        return view;
    }
}
