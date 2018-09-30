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

public class TwoFragment extends Fragment {
    public TwoFragment() {
        // Required empty public constructor
    }

    String[] listviewTitle = new String[]{
            "El cuerpo", "El brazo", "El vientre",
            "El cerebro", "El pecho", "La oreja",
            "El ojo", "El dedo", "El pie", "El cabello",
            "La mano", "La cabeza", "La pierna", "Los labios",
            "La boca", "La nariz", "El estómago", "El diente",
    };

    int[] listviewImage = new int[]{
            R.drawable.body, R.drawable.arm, R.drawable.belly, R.drawable.brain,
            R.drawable.chest, R.drawable.ear, R.drawable.eye, R.drawable.finger,
            R.drawable.foot, R.drawable.hair, R.drawable.hand, R.drawable.head,
            R.drawable.leg, R.drawable.lips, R.drawable.mouth, R.drawable.nose,
            R.drawable.stomach, R.drawable.teeth,
    };

    int[] listviewSound = new int[]{
            R.raw.body, R.raw.arm, R.raw.belly, R.raw.brain,
            R.raw.chest, R.raw.ear, R.raw.eye, R.raw.finger,
            R.raw.foot, R.raw.hair, R.raw.hand, R.raw.head,
            R.raw.leg, R.raw.lips, R.raw.mouth, R.raw.nose,
            R.raw.stomach, R.raw.teeth,
    };

    String[] listviewShortDescription = new String[]{
            "The body", "The arm", "The belly",
            "The brain", "The chest", "The ear",
            "The eye", "The finger", "The foot", "The hair",
            "The hand", "The head", "The leg", "The lips",
            "The mouth", "The nose", "The stomach", "The teeth"
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_two, container, false);

        ListView listView= (ListView) view.findViewById(R.id.fragmentTwo);

        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < 18; i++) {
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
