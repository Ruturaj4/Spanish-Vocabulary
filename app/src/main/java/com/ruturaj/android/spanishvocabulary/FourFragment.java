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


public class FourFragment extends Fragment {
    public FourFragment() {
        // Required empty public constructor
    }

    String[] listviewTitle = new String[]{
            "Los colores", "El negro", "El azul", "El cafe",
            "El verde", "La naranja", "El rosado", "El morado",
            "El rojo", "El blanco", "El amarillo",
    };


    int[] listviewImage = new int[]{
            R.drawable.colors, R.drawable.black, R.drawable.blue, R.drawable.brown,
            R.drawable.green, R.drawable.orange, R.drawable.pink, R.drawable.purple,
            R.drawable.red, R.drawable.white, R.drawable.yellow,
    };

    int[] listviewSound = new int[]{
            R.raw.colors, R.raw.black, R.raw.blue, R.raw.brown,
            R.raw.green, R.raw.orange, R.raw.pink, R.raw.purple,
            R.raw.red, R.raw.white, R.raw.yellow,
    };

    String[] listviewShortDescription = new String[]{
            "The colors", "The black", "The blue", "The brown",
            "The green", "The orange", "The pink", "The purple",
            "The red", "The white", "The yellow",
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_four, container, false);



        ListView listView= (ListView) view.findViewById(R.id.fragmentFour);

        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < 11; i++) {
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
