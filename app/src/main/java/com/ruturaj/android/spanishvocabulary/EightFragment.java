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


public class EightFragment extends Fragment {
    public EightFragment() {
        // Required empty public constructor
    }

    String[] listviewTitle = new String[]{
            "La naturaleza", "El acantilado", "La flor", "El jardín",
            "El césped", "La hierba", "El lago", "Las montañas",
            "El río", "El mar", "La orilla", "La tierra",
            "El árbol", "La cascada",
    };


    int[] listviewImage = new int[]{
            R.drawable.waterfall, R.drawable.cliff, R.drawable.yellow, R.drawable.garden,
            R.drawable.lawn, R.drawable.herb, R.drawable.lake, R.drawable.mountains,
            R.drawable.river, R.drawable.sea, R.drawable.shore, R.drawable.soil,
            R.drawable.tree, R.drawable.waterfall,
    };

    int[] listviewSound = new int[]{
            R.raw.nature, R.raw.cliff, R.raw.flower, R.raw.garden,
            R.raw.lawn, R.raw.herb, R.raw.lake, R.raw.mountains,
            R.raw.river, R.raw.sea, R.raw.shore, R.raw.soil,
            R.raw.tree, R.raw.waterfall,
    };

    String[] listviewShortDescription = new String[]{
            "The nature", "The cliff", "The flower", "The garden",
            "The lawn", "The herb", "The lake", "The mountains",
            "The river", "The sea", "The shore", "The soil",
            "The tree", "The waterfall",
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_eight, container, false);



        ListView listView= (ListView) view.findViewById(R.id.fragmentEight);

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


        String[] from = {"listview_image", "listview_title", "listview_discription"};
        int[] to = {R.id.listview_image, R.id.listview_item_title, R.id.listview_item_short_description};

        SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(), aList, R.layout.listview_activity, from, to);


        listView.setAdapter(simpleAdapter);


        // Inflate the layout for this fragment
        return view;
    }
}
