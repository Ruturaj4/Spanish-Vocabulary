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


public class NineFragment extends Fragment {
    public NineFragment() {
        // Required empty public constructor
    }

    String[] listviewTitle = new String[]{
            "los números",
            "Cero", "Uno", "Dos", "Tres",
            "Cuatro", "Cinco", "Seis", "Siete",
            "Ocho", "Nueve", "Diez", "Once",
            "Doce", "Trece", "Catorce", "Veinte", "Veintiuno",
            "Veintidós", "Treinta", "Cien", "Doscientos",
            "Mil", "Diez mil",
    };


    int[] listviewImage = new int[]{
            R.drawable.numbers, R.drawable.zero, R.drawable.number, R.drawable.number,
            R.drawable.number, R.drawable.number, R.drawable.number, R.drawable.number,
            R.drawable.number, R.drawable.number, R.drawable.number, R.drawable.number,
            R.drawable.number, R.drawable.number, R.drawable.number, R.drawable.number,
            R.drawable.number, R.drawable.number, R.drawable.number, R.drawable.number,
            R.drawable.number, R.drawable.number, R.drawable.number, R.drawable.number,
    };

    int[] listviewSound = new int[]{
            R.raw.numbers, R.raw.zero, R.raw.one, R.raw.two,
            R.raw.three, R.raw.four, R.raw.five, R.raw.six,
            R.raw.seven, R.raw.eight, R.raw.nine, R.raw.ten,
            R.raw.eleven, R.raw.twelve, R.raw.thirteen, R.raw.fourteen,
            R.raw.twenty, R.raw.twentyone, R.raw.twentytwo, R.raw.thirty,
            R.raw.hundred, R.raw.twohundred, R.raw.thousand, R.raw.tenthousand,
    };

    String[] listviewShortDescription = new String[]{
            "The numbers",
            "Zero", "One", "Two", "Three",
            "Four", "Five", "Six", "Seven",
            "Eight", "Nine", "Ten", "Eleven",
            "Twelve", "Thirteen", "Fourteen", "Twenty", "Twenty one",
            "Twenty two", "Thirty", "Hundred", "Two hundred",
            "Thousand", "Ten thousand",
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nine, container, false);


        ListView listView= (ListView) view.findViewById(R.id.fragmentNine);

        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < 24; i++) {
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
