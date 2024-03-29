package com.spaikdeveloper.tourpal;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class HomeFragment extends Fragment {

    private ImageButton addIBT;
    private Context context;
    private AddEventListener addEventListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        addEventListener = (AddEventListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        addIBT = view.findViewById(R.id.addIBT);


        addIBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             addEventListener.onAddEventListener();

            }
        });
    }


    public interface AddEventListener{
        void onAddEventListener();
    }
}
