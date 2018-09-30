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


public class FiveFragment extends Fragment {
    public FiveFragment() {
        // Required empty public constructor
    }

    String[] listviewTitle = new String[]{
            "Los países", "Argentina", "Canadá", "China",
            "Costa Rica", "Cuba", "El Salvador", "Inglaterra",
            "Francia", "Alemania", "Japón", "Líbano",
            "Méjico", "España", "Estados Unidos",
    };


    int[] listviewImage = new int[]{
            R.drawable.countries, R.drawable.argentina, R.drawable.canada, R.drawable.china,
            R.drawable.costa_rica, R.drawable.cuba, R.drawable.el_salvador, R.drawable.england,
            R.drawable.france, R.drawable.germany, R.drawable.japan, R.drawable.lebanon,
            R.drawable.mexico, R.drawable.spain, R.drawable.usa,
    };

    int[] listviewSound = new int[]{
            R.raw.countries, R.raw.argentina, R.raw.canada, R.raw.china,
            R.raw.costa_rica, R.raw.cuba, R.raw.el_salvador, R.raw.england,
            R.raw.france, R.raw.germany, R.raw.japan, R.raw.lebanon,
            R.raw.mexico, R.raw.spain, R.raw.usa,
    };

    String[] listviewShortDescription = new String[]{
            "The countries", "Argentina", "Canada", "China",
            "Costa Rica", "Cuba", "El Salvador", "England",
            "France", "Germany", "Japan", "Lebanon",
            "Mexico", "Spain", "United States",
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_five, container, false);



        ListView listView= (ListView) view.findViewById(R.id.fragmentFive);


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

        String[] from = {"listview_image", "listview_title", "listview_discription"};
        int[] to = {R.id.listview_image, R.id.listview_item_title, R.id.listview_item_short_description};

        SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(), aList, R.layout.listview_activity, from, to);



        listView.setAdapter(simpleAdapter);

        // Inflate the layout for this fragment
        return view;
    }
}
