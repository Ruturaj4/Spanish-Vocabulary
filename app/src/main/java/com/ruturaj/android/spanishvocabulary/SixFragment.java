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


public class SixFragment extends Fragment {
    public SixFragment() {
        // Required empty public constructor
    }

    String[] listviewTitle = new String[]{
            "La familia", "La tía", "El novio", "El hermano",
            "El primo", "El padre", "La hija", "El novio",
            "El amigo", "La novia", "La abuela", "El abuelo",
            "El esposo", "La mamá", "El sobrino", "La sobrina",
            "La hermana", "El hijo", "El tío", "La esposa",
    };


    int[] listviewImage = new int[]{
            R.drawable.family, R.drawable.aunt, R.drawable.boyfriend, R.drawable.friend,
            R.drawable.cousin, R.drawable.dad, R.drawable.daughter, R.drawable.fiance,
            R.drawable.friend, R.drawable.girlfriend, R.drawable.grandma, R.drawable.granpa,
            R.drawable.dad, R.drawable.mother, R.drawable.nephew, R.drawable.niece,
            R.drawable.sister, R.drawable.son, R.drawable.uncle, R.drawable.mother,
    };

    int[] listviewSound = new int[]{
            R.raw.family, R.raw.aunt, R.raw.boyfriend, R.raw.brother,
            R.raw.cousin, R.raw.dad, R.raw.daughter, R.raw.fiance,
            R.raw.friend, R.raw.girlfriend, R.raw.grandma, R.raw.granpa,
            R.raw.husband, R.raw.mother, R.raw.nephew, R.raw.niece,
            R.raw.sister, R.raw.son, R.raw.uncle, R.raw.wife,
    };

    String[] listviewShortDescription = new String[]{
            "The family", "The aunt", "The boyfriend", "The brother",
            "The cousin", "The dad", "The daughter", "The fiance",
            "The friend", "The girlfriend", "The grandma", "The grandpa",
            "The husband", "The mom", "The nephew", "The niece",
            "The sister", "The son", "The uncle", "The wife",
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_six, container, false);



        ListView listView= (ListView) view.findViewById(R.id.fragmentSix);

        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < 20; i++) {
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
