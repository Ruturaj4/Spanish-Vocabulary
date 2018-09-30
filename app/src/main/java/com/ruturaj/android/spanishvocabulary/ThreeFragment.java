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

public class ThreeFragment extends Fragment {
    public ThreeFragment() {
        // Required empty public constructor
    }

    String[] listviewTitle = new String[]{
            "La ropa", "El abrigo", "El vestido", "Los guantes",
            "El sombrero", "La chaqueta", "Los pantalones", "La bolsa",
            "Las camisas", "Los zapatos", "Las faldas",
            "Las medias", "El traje", "El suéter", "La corbata",
    };


    int[] listviewImage = new int[]{
            R.drawable.clothes, R.drawable.coat, R.drawable.dress, R.drawable.gloves,
            R.drawable.hat, R.drawable.jacket, R.drawable.pants, R.drawable.purse,
            R.drawable.shirt, R.drawable.shoes, R.drawable.skirt, R.drawable.socks,
            R.drawable.suit, R.drawable.sweater, R.drawable.tie,
    };

    int[] listviewSound = new int[]{
            R.raw.clothes, R.raw.coat, R.raw.dress, R.raw.gloves,
            R.raw.hat, R.raw.jacket, R.raw.pants, R.raw.purse,
            R.raw.shirt, R.raw.shoes, R.raw.skirt, R.raw.socks,
            R.raw.suit, R.raw.sweater, R.raw.tie,
    };

    String[] listviewShortDescription = new String[]{
            "The clothes", "The coat", "The dress", "The gloves",
            "The hat", "The jacket", "The pants", "The purse",
            "The shirts", "The shoes", "The skirts",
            "The socks", "The suit", "The sweater", "The tie",
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_three, container, false);


        ListView listView= (ListView) view.findViewById(R.id.fragmentThree);

        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < 15; i++) {
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

        /*ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                menuItems
        );*/

        String[] from = {"listview_image", "listview_title", "listview_discription"};
        int[] to = {R.id.listview_image, R.id.listview_item_title, R.id.listview_item_short_description};

        SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(), aList, R.layout.listview_activity, from, to);



        listView.setAdapter(simpleAdapter);

        // Inflate the layout for this fragment
        return view;

    }
}
