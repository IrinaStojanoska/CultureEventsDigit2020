package com.example.cultureevents;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;

import com.example.cultureevents.models.Event;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class CalendarFragment extends Fragment {

  //  CalendarView calendar;
    CalendarView calendar;
    View view;
    RecyclerView recyclerView;
    FirebaseDatabase database;
    DatabaseReference ref;

    List<String> names=new ArrayList<>();
    List<String> dates=new ArrayList<>();
    List<String> times=new ArrayList<>();
    List<String> description=new ArrayList<>();


    Event event;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_calendar, container, false);
        recyclerView=view.findViewById(R.id.recyclerView);
        database = FirebaseDatabase.getInstance();
        ref = database.getReference("Events");
        calendar=view.findViewById(R.id.calendar);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                final String datePicked= i2 +"-"+(i1+1)+"-"+i;
                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                      names.clear();
                      times.clear();
                      description.clear();
                      dates.clear();

                        for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                            String date=snapshot.child("date").getValue(String.class);
                            if (date.equals(datePicked)){
                               // eventList.add((Event) snapshot.getValue());
                                String n=snapshot.child("name").getValue(String.class);
                                String t=snapshot.child("time").getValue(String.class);
                                String d=snapshot.child("date").getValue(String.class).substring(0,2);
                                String ds=snapshot.child("description").getValue(String.class);
                                names.add(n);
                                times.add(t);
                                dates.add(d);
                                description.add(ds);

                            }
                        }
                        EventsAdapter adapter=new EventsAdapter(getActivity(), names, dates, times, description);
                        recyclerView.setAdapter(adapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // TODO: Use the ViewModel
    }

}