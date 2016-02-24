package com.softdesign.school.ui.activities;

import android.os.Build;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.softdesign.school.R;
import com.softdesign.school.data.storage.models.User;
import com.softdesign.school.ui.fragments.ContactsFragment;
import com.softdesign.school.ui.fragments.ProfileFragment;
import com.softdesign.school.ui.fragments.SettingFragment;
import com.softdesign.school.ui.fragments.TasksFragment;
import com.softdesign.school.ui.fragments.TeamFragment;
import com.softdesign.school.utils.Lg;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String VISIBLE_KEY = "visible";

    /**
     * Начальные цвета Статус бара и тул бара
     */
    int mToolBarColor = R.color.newColorPrimary;
    int mStatusBarColor = R.color.newColorPrimaryDark;

    private Toolbar mToolbar;
    private NavigationView mNavigationView;
    private DrawerLayout mNavigationDrawer;
    private Fragment mFragment;
    public AppBarLayout mAppBar;
    public CollapsingToolbarLayout mCollapsingToolBar;
    private FrameLayout mFrameConteiner;
    private View mHeaderLayout;

    public AppBarLayout.LayoutParams params = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /**
         * 6 - уровень лога (ERROR)
         */
        Lg.msgLog(6, this.getLocalClassName(), "==========================");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Lg.msgLog(6, this.getClass().getSimpleName(), "onCreate()");

        /**
         * Смена названия
         */
        setTitle("School Design Lesson 1");

        /**
         * Определение элементов
         */
        mToolbar = (Toolbar) findViewById(R.id.Toolbar);
        mNavigationDrawer = (DrawerLayout) findViewById(R.id.navigation_drawer);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        mAppBar = (AppBarLayout) findViewById(R.id.appbar);
        mCollapsingToolBar = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbar);
        setupToolbar();
        setupDrawer();

        if (savedInstanceState != null) {

        } else {
            getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_container, new ProfileFragment()).commit();
        }
    }

    private void setupToolbar() {
        /**
         * Описание тул бара (определение, иконка меню)
         */
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public void appBarLock(boolean collapse, int number_fragment) {
        params = (AppBarLayout.LayoutParams) mCollapsingToolBar.getLayoutParams();
        params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL | AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED | AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP);
        mCollapsingToolBar.setLayoutParams(params);
        if(collapse) {
            /*Свернуть AppBar*/
            mAppBar.setExpanded(false);}
        /*Развернуть AppBar*/
        else {
            mAppBar.setExpanded(true);
            params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL | AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED | AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP);
            mCollapsingToolBar.setLayoutParams(params);
        }

        /*Смена Title в зависимости от выбранного фрагмента*/
        switch (number_fragment) {
            case 1:
                mCollapsingToolBar.setTitle(getResources().getString(R.string.fio));
                break;
            case 2:
                mCollapsingToolBar.setTitle(getResources().getString(R.string.drawer_contacts));
                break;
            case 3:
                mCollapsingToolBar.setTitle(getResources().getString(R.string.drawer_team));
                break;
            case 4:
                mCollapsingToolBar.setTitle(getResources().getString(R.string.drawer_tasks));
                break;
            case 5:
                mCollapsingToolBar.setTitle(getResources().getString(R.string.drawer_setting));
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /**
         * Обработка Menu click
         */
        if (item.getItemId() == android.R.id.home) {
            /**
             * 6 - уровень лога (ERROR)
             */
            Lg.msgLog(6, this.getClass().getName(), "openNavigationDrawer");
            mNavigationDrawer.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

    }

    @Override
    protected void onStart() {
        super.onStart();
        /**
         * 6 - уровень лога (ERROR)
         */
        Lg.msgLog(6, this.getLocalClassName(), "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        /**
         * 6 - уровень лога (ERROR)
         */
        Lg.msgLog(6, this.getLocalClassName(), "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        /**
         * 6 - уровень лога (ERROR)
         */
        Lg.msgLog(6, this.getLocalClassName(), "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        /**
         * 6 - уровень лога (ERROR)
         */
        Lg.msgLog(6, this.getLocalClassName(), "onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        /**
         * 6 - уровень лога (ERROR)
         */
        Lg.msgLog(6, this.getLocalClassName(), "onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /**
         * 6 - уровень лога (ERROR)
         */
        Lg.msgLog(6, this.getLocalClassName(), "onDestroy()");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        /**
         * 6 - уровень лога (ERROR)
         */
        Lg.msgLog(6, this.getLocalClassName(), "onSaveInstanceState()");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        /**
         * 6 - уровень лога (ERROR)
         */
        Lg.msgLog(6, this.getLocalClassName(), "onRestoreInstanceState()");
    }

    private void setupDrawer() {
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.drawer_profile:
                        mFragment = new ProfileFragment();
                        /* 6 - уровень лога (ERROR) */
                        Lg.msgLog(6, this.getClass().getName(), "ProfileFragment");
                        Toast.makeText(MainActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.drawer_contacts:
                        mFragment = new ContactsFragment();
                        /* 6 - уровень лога (ERROR) */
                        Lg.msgLog(6, this.getClass().getName(), "ContactsFragment");
                        Toast.makeText(MainActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.drawer_tasks:
                        mFragment = new TasksFragment();
                        /* 6 - уровень лога (ERROR) */
                        Lg.msgLog(6, this.getClass().getName(), "TasksFragment");
                        Toast.makeText(MainActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.drawer_team:
                        mFragment = new TeamFragment();
                        /* 6 - уровень лога (ERROR) */
                        Lg.msgLog(6, this.getClass().getName(), "TeamFragment");
                        Toast.makeText(MainActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.drawer_setting:
                        mFragment = new SettingFragment();
                        /* 6 - уровень лога (ERROR) */
                        Lg.msgLog(6, this.getClass().getName(), "SettingFragment");
                        Toast.makeText(MainActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                        break;
                }

                if (mFragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_container, mFragment).addToBackStack(null).commit();
                }

                mNavigationDrawer.closeDrawers();
                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        Fragment findingFragment = (Fragment) getSupportFragmentManager().findFragmentById(R.id.main_frame_container);
        if (findingFragment != null && findingFragment instanceof ProfileFragment) {
            getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
        super.onBackPressed();
    }

}