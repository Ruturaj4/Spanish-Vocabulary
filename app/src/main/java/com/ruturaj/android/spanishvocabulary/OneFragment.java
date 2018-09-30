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


public class OneFragment extends Fragment {
    public OneFragment() {
        // Required empty public constructor
    }

    String[] listviewTitle = new String[]{
            "Los animales", "El oso", "El gato", "El ciervo",
            "El perro", "El elefante", "El zorro", "El caballo",
            "El mono", "El ratón", "El pingüino", "El conejo",
            "El Tigre", "El lobo",
    };


    int[] listviewImage = new int[]{
            R.drawable.animals, R.drawable.bear, R.drawable.cat, R.drawable.deer,
            R.drawable.dog, R.drawable.elephant, R.drawable.fox, R.drawable.horse,
            R.drawable.monkey, R.drawable.mouse, R.drawable.penguin, R.drawable.rabbit,
            R.drawable.tiger, R.drawable.wolf,
    };

    int[] listviewSound = new int[]{
            R.raw.animals, R.raw.bear, R.raw.cat, R.raw.deer,
            R.raw.dog, R.raw.elephant, R.raw.fox, R.raw.horse,
            R.raw.monkey, R.raw.mouse, R.raw.penguin, R.raw.rabbit,
            R.raw.tiger, R.raw.wolf,
    };

    String[] listviewShortDescription = new String[]{
            "The animals", "The bear", "The cat", "The deer",
            "The dog", "The elephant", "The fox", "The horse",
            "The monkey", "The mouse", "The penguin", "The rabbit",
            "The tiger", "The wolf",

    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        ListView listView= (ListView) view.findViewById(R.id.fragmentOne);


        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < 14; i++) {
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

        //listView.setAdapter(listViewAdapter);
        listView.setAdapter(simpleAdapter);


        // Inflate the layout for this fragment
        return view;
    }
}
