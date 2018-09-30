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


public class SevenFragment extends Fragment {
    public SevenFragment() {
        // Required empty public constructor
    }

    String[] listviewTitle = new String[]{
            "La comida", "El aperitivo", "El aguacate", "El plátano",
            "Los frijoles", "La remolacha", "El desayuno", "El caramelo",
            "El queso", "El pollo", "El desierto",
            "La cena", "El huevo", "El pescado", "La uva",
            "La miel", "El jamon", "El jugo", "El ketchup",
            "La lechuga", "La cal", "El almuerzo", "La leche",
            "La piña", "Las papas", "El rábano", "La ensalada",
            "El sandwich", "La sopa", "El azúcar", "El tomate",
            "El agua",
    };


    int[] listviewImage = new int[]{
            R.drawable.food, R.drawable.appet, R.drawable.avocado, R.drawable.banana,
            R.drawable.beans, R.drawable.beet, R.drawable.brown, R.drawable.candy,
            R.drawable.cheese, R.drawable.chicken, R.drawable.desert,
            R.drawable.lunch, R.drawable.egg, R.drawable.fish, R.drawable.grapes,
            R.drawable.honey, R.drawable.jam, R.drawable.juice, R.drawable.ketchup,
            R.drawable.green, R.drawable.lime, R.drawable.lunch, R.drawable.milk,
            R.drawable.pina, R.drawable.potatoes, R.drawable.radish, R.drawable.salad,
            R.drawable.sandwich, R.drawable.soup, R.drawable.sugar, R.drawable.tomato,
            R.drawable.water,
    };

    int[] listviewSound = new int[]{
            R.raw.food, R.raw.appet, R.raw.avocado, R.raw.banana,
            R.raw.beans, R.raw.beet, R.raw.breakfast, R.raw.candy,
            R.raw.cheese, R.raw.chicken, R.raw.desert,
            R.raw.dinner, R.raw.egg, R.raw.fish, R.raw.grapes,
            R.raw.honey, R.raw.jam, R.raw.juice, R.raw.ketchup,
            R.raw.lettuce, R.raw.lime, R.raw.lunch, R.raw.milk,
            R.raw.pina, R.raw.potatoes, R.raw.radish, R.raw.salad,
            R.raw.sandwich, R.raw.soup, R.raw.sugar, R.raw.tomato,
            R.raw.water,
    };

    String[] listviewShortDescription = new String[]{
            "The food", "The appetizer", "The avocado", "The banana",
            "The beans", "The beet", "The breakfast", "The candy",
            "The cheese", "The chicken", "The desert",
            "The dinner", "The egg", "The fish", "The grape",
            "The honey", "The jam", "The juice", "The ketchup",
            "The lettuce", "The lime", "The lunch", "The milk",
            "The pineapple", "The potatoes", "The radish", "The salad",
            "The sandwich", "The soup", "The sugar", "The tomato",
            "The water",

    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_seven, container, false);



        ListView listView= (ListView) view.findViewById(R.id.fragmentSeven);

        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < 32; i++) {
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
