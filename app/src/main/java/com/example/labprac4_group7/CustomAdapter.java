package com.example.labprac4_group7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    ArrayList<Professor> profList;
    Context context;

    CustomAdapter(Context c){
        profList = new ArrayList<Professor>();
        this.context = c;

        String[] profName = c.getResources().getStringArray(R.array.names);
        String[] codeName = c.getResources().getStringArray(R.array.classCode);
        String[] descName = c.getResources().getStringArray(R.array.classDesc);
        //int[] image = c.getResources().getIntArray(R.array.logo);
        int[] image = {R.drawable.cabero, R.drawable.cosme, R.drawable.delfinado, R.drawable.maglalang, R.drawable.santos, R.drawable.sideno};

        for(int i = 0; i<profName.length; i++){
            profList.add(new Professor(profName[i], codeName[i], descName[i], image[i]) );
        }
    }

    @Override
    public int getCount() {
        return profList.size();
    }

    @Override
    public Object getItem(int i) {
        return profList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewRef = inflater.inflate(R.layout.row, viewGroup, false);
        TextView txtName = viewRef.findViewById(R.id.profName);
        TextView txtClassCode = viewRef.findViewById(R.id.classCode);
        ImageView profPic = viewRef.findViewById(R.id.profPic);

        Professor temp = profList.get(i);

        txtName.setText(temp.name);
        txtClassCode.setText(temp.code);
        profPic.setImageResource(temp.pic);

        return viewRef;
    }
}
