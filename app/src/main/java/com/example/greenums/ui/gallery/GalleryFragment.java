package com.example.greenums.ui.gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.greenums.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {

    RecyclerView pcRecycler, cityRecycler, convoRecycler, otherEventRecycler;
    GalleryAdapter adapter;

    DatabaseReference reference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        pcRecycler = view.findViewById(R.id.pcRecycler);
        cityRecycler = view.findViewById(R.id.cityRecycler);
        convoRecycler = view.findViewById(R.id.convoRecycler);
        otherEventRecycler = view.findViewById(R.id.otherEventRecycler);

        reference = FirebaseDatabase.getInstance().getReference().child("gallery");

        getPcImage();
        getCityImage();
        getConvoImage();
        getOtherEventImage();

        return view;
    }

    private void getPcImage() {
        reference.child("Permanent Campus").addValueEventListener(new ValueEventListener() {

            final List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                    String data = String.valueOf(snapshot.getValue());
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(), imageList);
                pcRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                pcRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getCityImage() {
        reference.child("City Campus").addValueEventListener(new ValueEventListener() {

            final List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                    String data = String.valueOf(snapshot.getValue());
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(), imageList);
                cityRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                cityRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getConvoImage() {
        reference.child("Convocation").addValueEventListener(new ValueEventListener() {

            final List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                    String data = String.valueOf(snapshot.getValue());
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(), imageList);
                convoRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                convoRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getOtherEventImage() {
        reference.child("Others Event");
        reference.addValueEventListener(new ValueEventListener() {

            final List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String data = String.valueOf(snapshot.getValue());
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(), imageList);
                otherEventRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                otherEventRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}