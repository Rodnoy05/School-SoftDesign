package com.softdesign.school.ui.activities;

import android.os.Build;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.softdesign.school.R;
import com.softdesign.school.ui.fragments.ContactsFragment;
import com.softdesign.school.ui.fragments.ProfileFragment;
import com.softdesign.school.ui.fragments.SettingFragment;
import com.softdesign.school.ui.fragments.TasksFragment;
import com.softdesign.school.ui.fragments.TeamFragment;
import com.softdesign.school.utils.Lg;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String VISIBLE_KEY = "visible";

    /**
     * Начальные цвета Статус бара и тул бара
     */
    int mToolBarColor = R.color.newColorPrimary;
    int mStatusBarColor = R.color.newColorPrimaryDark;

    Toolbar mToolbar;

    private NavigationView mNavigationView;
    private DrawerLayout mNavigationDrawer;
    private Fragment mFragment;
    private FrameLayout mFrameConteiner;


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
        mNavigationDrawer = (DrawerLayout) findViewById(R.id.navigation_drawer);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);

        mToolbar = (Toolbar) findViewById(R.id.Toolbar);

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
                        mNavigationView.getMenu().findItem(R.id.drawer_profile).setChecked(true);
                        /**
                         * 6 - уровень лога (ERROR)
                         */
                        Lg.msgLog(6, this.getClass().getName(), "ProfileFragment");
                        Toast.makeText(MainActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.drawer_contacts:
                        mFragment = new ContactsFragment();
                        mNavigationView.getMenu().findItem(R.id.drawer_contacts).setChecked(true);
                        /**
                         * 6 - уровень лога (ERROR)
                         */
                        Lg.msgLog(6, this.getClass().getName(), "ContactsFragment");
                        Toast.makeText(MainActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.drawer_tasks:
                        mFragment = new TasksFragment();
                        mNavigationView.getMenu().findItem(R.id.drawer_tasks).setChecked(true);
                        /**
                         * 6 - уровень лога (ERROR)
                         */
                        Lg.msgLog(6, this.getClass().getName(), "TasksFragment");
                        Toast.makeText(MainActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.drawer_team:
                        mFragment = new TeamFragment();
                        mNavigationView.getMenu().findItem(R.id.drawer_team).setChecked(true);
                        /**
                         * 6 - уровень лога (ERROR)
                         */
                        Lg.msgLog(6, this.getClass().getName(), "TeamFragment");
                        Toast.makeText(MainActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.drawer_setting:
                        mFragment = new SettingFragment();
                        mNavigationView.getMenu().findItem(R.id.drawer_setting).setChecked(true);
                        /**
                         * 6 - уровень лога (ERROR)
                         */
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