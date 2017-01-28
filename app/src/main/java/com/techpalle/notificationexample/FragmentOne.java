package com.techpalle.notificationexample;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentOne extends Fragment {
    EditText ed1, ed2, ed3, ed4;
    Button b, b2;
    NotificationManager notificationManager;
    NotificationCompat.Builder builder;

    public FragmentOne() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment_one, container, false);
        ed1 = (EditText) v.findViewById(R.id.edit_text_info);
        ed2 = (EditText) v.findViewById(R.id.edit_text_title);
        ed3 = (EditText) v.findViewById(R.id.edit_text_detail);
        ed4 = (EditText) v.findViewById(R.id.edit_text_extra_info);
        b = (Button) v.findViewById(R.id.button_submit);
        b2 = (Button) v.findViewById(R.id.button_update);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //UPDATE notification
                builder.setContentTitle("Selected !");
                notificationManager.notify(1, builder.build());
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notificationManager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
                builder = new NotificationCompat.Builder(getActivity());
                builder.setSmallIcon(R.mipmap.ic_launcher);
                builder.setTicker(ed1.getText().toString());
                BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(R.drawable.image1);
                builder.setLargeIcon(bitmapDrawable.getBitmap());
                builder.setContentTitle(ed2.getText().toString());
                builder.setContentText(ed3.getText().toString());
                builder.setContentInfo(ed4.getText().toString());
                //for handling notification
                Intent intent = new Intent(getActivity(), MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(getActivity(), 0, intent, 0);
                builder.setContentIntent(pendingIntent);
                builder.setAutoCancel(true);
                //PUSH NOTIFICATION TO TOP BAR
                notificationManager.notify(1, builder.build());
                //delete particular notification
//                notificationManager.cancel(1);
//                notificationManager.cancelAll();
            }
        });
        return v;
    }

}
