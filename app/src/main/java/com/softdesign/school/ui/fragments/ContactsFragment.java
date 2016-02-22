package com.softdesign.school.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.design.widget.FloatingActionButton;

import com.softdesign.school.R;
import com.softdesign.school.ui.activities.MainActivity;
import com.softdesign.school.data.storage.models.User;
import com.softdesign.school.ui.adapters.RecycleUsersAdapter;

import java.util.ArrayList;

/**
 * Created by Rodnoy on 02.02.2016.
 */
public class ContactsFragment extends Fragment {

private ArrayList<User> mUsers = new ArrayList<User>();
private RecyclerView mRecyclerView;
private RecyclerView.LayoutManager mLayoutManager;
private RecyclerView.Adapter mAdapter;

private View mContactView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /*Свернуть CollapsingToolbar и сменить Title*/
        ((MainActivity) getActivity()).appBarLock(true,2);
        if (mContactView == null) {
            mContactView = inflater.inflate(R.layout.fragment_contacts, container, false);
        }
        /* Определение активного пункта меню (сбивалось при повороте экрана)*/
        NavigationView mNavigationView = (NavigationView) getActivity().findViewById(R.id.navigation_view);
        mNavigationView.getMenu().findItem(R.id.drawer_profile).setChecked(false);
        mNavigationView.getMenu().findItem(R.id.drawer_contacts).setChecked(true);
        mNavigationView.getMenu().findItem(R.id.drawer_team).setChecked(false);
        mNavigationView.getMenu().findItem(R.id.drawer_tasks).setChecked(false);
        mNavigationView.getMenu().findItem(R.id.drawer_setting).setChecked(false);

        /*Генерация данных контактов*/
        generateData();

        /*Инициализация RecyclerView*/
        mRecyclerView = (RecyclerView) mContactView.findViewById(R.id.contacts_recyclerview);
        /*Расположение карточек контактов*/
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        /*Наполнение адаптера*/
        mAdapter = new RecycleUsersAdapter(mUsers);
        /*Устанвить адаптер в RecyclerView*/
        mRecyclerView.setAdapter(mAdapter);

    return mContactView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        FloatingActionButton mFloationgActionButton = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) mFloationgActionButton.getLayoutParams();
        /* Привязка кнопки к coordinator_layout*/
        params.setAnchorId(R.id.coordinator_layout);
        /* Позиция кнопки в coordinator_layout*/
        params.anchorGravity = Gravity.BOTTOM | Gravity.END;
        mFloationgActionButton.setLayoutParams(params);
        /*Изменение иконки кнопки*/
        mFloationgActionButton.setImageResource(R.drawable.ic_add_24dp);
    }

    private void generateData() {
        mUsers.add(new User(getResources().getDrawable(R.mipmap.av_11), "Гаррисон", "Форд"));
        mUsers.add(new User(getResources().getDrawable(R.mipmap.av_2), "Шон", "Бин"));
        mUsers.add(new User(getResources().getDrawable(R.mipmap.av_3), "Кейт", "Бланшетт"));
        mUsers.add(new User(getResources().getDrawable(R.mipmap.av_4), "Мартин", "Фримен"));
        mUsers.add(new User(getResources().getDrawable(R.mipmap.av_5), "Джулия", "Робертс"));
        mUsers.add(new User(getResources().getDrawable(R.mipmap.av_6), "Орландо", "Блум"));
        mUsers.add(new User(getResources().getDrawable(R.mipmap.av_7), "Бенедикт", "Камбербэтч"));
        mUsers.add(new User(getResources().getDrawable(R.mipmap.av_8), "Сандра", "Баллок"));
        mUsers.add(new User(getResources().getDrawable(R.mipmap.av_9), "Дэниэл", "Крейг"));
        mUsers.add(new User(getResources().getDrawable(R.mipmap.av_10), "Роберт", "Дауни"));
    }
}
