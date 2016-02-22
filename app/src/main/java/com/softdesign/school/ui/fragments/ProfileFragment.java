package com.softdesign.school.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.view.Gravity;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softdesign.school.R;
import com.softdesign.school.ui.activities.MainActivity;


/**
 * Created by Rodnoy on 02.02.2016.
 */

public class ProfileFragment extends Fragment {

    View ProfileView = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View ProfileView = inflater.inflate(R.layout.fragment_profile,null,false);

        ((MainActivity) getActivity()).appBarLock(false, 1);

        /* Определение активного пункта меню (сбивалось при повороте экрана)*/
        NavigationView mNavigationView = (NavigationView) getActivity().findViewById(R.id.navigation_view);
        mNavigationView.getMenu().findItem(R.id.drawer_profile).setChecked(true);
        mNavigationView.getMenu().findItem(R.id.drawer_contacts).setChecked(false);
        mNavigationView.getMenu().findItem(R.id.drawer_team).setChecked(false);
        mNavigationView.getMenu().findItem(R.id.drawer_tasks).setChecked(false);
        mNavigationView.getMenu().findItem(R.id.drawer_setting).setChecked(false);

        return ProfileView;
    }

    @Override
   public void onActivityCreated(Bundle savedInstanceState) {
       super.onActivityCreated(savedInstanceState);
       FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
       CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) fab.getLayoutParams();
       params.setAnchorId(R.id.appbar);
       params.anchorGravity = Gravity.BOTTOM | Gravity.RIGHT;
       fab.setLayoutParams(params);
       fab.setImageResource(R.drawable.ic_edit_24dp);
   }

}