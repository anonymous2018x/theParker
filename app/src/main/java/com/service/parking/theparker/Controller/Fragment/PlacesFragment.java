package com.service.parking.theparker.Controller.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.service.parking.theparker.Controller.Activity.Register.LoginActivity;
import com.service.parking.theparker.Controller.Activity.ProfileActivity;
import com.service.parking.theparker.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class PlacesFragment extends Fragment {

    @BindView(R.id.lb)
    Button mlogin;

    @BindView(R.id.fragment_name)
    TextView mFragmentName;

    @BindView(R.id.custom_bar_image)
    CircleImageView mProfileView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_places, container, false);

        ButterKnife.bind(this,view);

        mFragmentName.setText("Places");

        mlogin.setOnClickListener(v -> startActivity(new Intent(getContext(), LoginActivity.class)));

        mlogin.setOnLongClickListener(v -> {

//            SharedPreferences sh = getContext().getSharedPreferences("myinfo",MODE_PRIVATE);
//            SharedPreferences.Editor edit = sh.edit();
//            edit.clear();

            FirebaseAuth.getInstance().signOut();

            return false;
        });

        mProfileView.setOnClickListener(v1 -> startActivity(new Intent(getContext(), ProfileActivity.class)));

        return view;
    }

    public PlacesFragment() {
        // Required empty public constructor
    }

}