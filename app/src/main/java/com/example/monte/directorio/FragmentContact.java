package com.example.monte.directorio;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FragmentContact extends Fragment {

    View v;
    private RecyclerView recyclerview;
    private List<Contacts> contactlist;
    private ContentResolver contentResolver;

    public FragmentContact() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.contact_fragment, container, false );
        recyclerview = (RecyclerView) v.findViewById(R.id.contact_recycler);
        RecyclerViewAdapter recyclerviewad = new RecyclerViewAdapter(getContext(), contactlist);
        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerview.setAdapter(recyclerviewad);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        contactlist = new ArrayList<>();
        contactlist.add(new Contacts("Aaron Jones", "78716096", R.drawable.ic_call));
        contactlist.add(new Contacts("Tom Jones", "74739179", R.drawable.ic_call));
        contactlist.add(new Contacts("Indica Badu", "73528491", R.drawable.ic_call));
        contactlist.add(new Contacts("Miles Morales", "70991680", R.drawable.ic_call));
        contactlist.add(new Contacts("Jessie Eisenberg", "74829105", R.drawable.ic_call));
        contactlist.add(new Contacts("Tom Holland", "78716094", R.drawable.ic_call));
        contactlist.add(new Contacts("Josh Brolin", "74739579", R.drawable.ic_call));
        contactlist.add(new Contacts("Javier Bardem", "73828491", R.drawable.ic_call));
        contactlist.add(new Contacts("Eric Andre", "70991681", R.drawable.ic_call));
        contactlist.add(new Contacts("Menelaus", "74829568", R.drawable.ic_call));
        contactlist.add(new Contacts("Nostradamus", "7482905", R.drawable.ic_call));
        contactlist.add(new Contacts("Fatima Rumualdo", "78716096", R.drawable.ic_call));
        contactlist.add(new Contacts("Jessica Alba", "74821105", R.drawable.ic_call));
        contactlist.add(new Contacts("Tony Stark", "78716096", R.drawable.ic_call));
        contactlist.add(new Contacts("Steve Rogers", "71429105", R.drawable.ic_call));
        contactlist.add(new Contacts("Zoe Saldana", "78716096", R.drawable.ic_call));
        contactlist.add(new Contacts("Johanna Carranza", "79814205", R.drawable.ic_call));

    }


    public ContentResolver getContentResolver() {
        return contentResolver;
    }
}
