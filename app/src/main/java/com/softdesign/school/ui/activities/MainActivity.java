package com.softdesign.school.ui.activities;

import android.os.Build;
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
import android.widget.Toast;

import com.softdesign.school.R;
import com.softdesign.school.utils.Lg;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String VISIBLE_KEY = "visible";

    public final static String COLOR_TOOLBAR_KEY = "ToolBarColor";
    public final static String COLOR_STATUSBAR_KEY = "StatusBarColor";
    /**
     * Начальные цвета Статус бара и тул бара
     */
    int mToolBarColor = R.color.blueToolBar_color;
    int mStatusBarColor = R.color.blueStatusBar_color;

    CheckBox mCheckBox;
    EditText mEditText;
    EditText mEditText2;
    Toolbar mToolbar;
    Button mBtnRed;
    Button mBtnBlue;
    Button mBtnGreen;

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
         * Определение view элементов и обработки OnClick
         */

        mCheckBox = (CheckBox) findViewById(R.id.checkBox);
        mCheckBox.setOnClickListener(this);

        mEditText = (EditText) findViewById(R.id.editText);
        mEditText2 = (EditText) findViewById(R.id.editText2);

        mToolbar = (Toolbar) findViewById(R.id.Toolbar);

        setupToolbar();

        mBtnBlue = (Button) findViewById(R.id.btn_blue);
        mBtnGreen = (Button) findViewById(R.id.btn_green);
        mBtnRed = (Button) findViewById(R.id.btn_red);

        mBtnBlue.setOnClickListener(this);
        mBtnGreen.setOnClickListener(this);
        mBtnRed.setOnClickListener(this);
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
            Toast.makeText(this, "Menu click!", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            /**
             * Если OnClick на CheckBox
             */
            case R.id.checkBox:
                Toast.makeText(this, "Click!", Toast.LENGTH_SHORT).show();
                if (mCheckBox.isChecked()) {
                    mEditText2.setVisibility(View.INVISIBLE);
                } else {
                    mEditText2.setVisibility(View.VISIBLE);
                }
                break;
            /**
             * Если OnClick на кнопки с выбором цветов, сохранение выбранного цвета в переменные
             */
            case R.id.btn_green:
                /**
                 * 6 - уровень лога (ERROR)
                 */
                Lg.msgLog(6, this.getLocalClassName(), "Green Color");
                mToolbar.setBackgroundColor(getResources().getColor(R.color.greenToolBar_color));
                mToolBarColor=R.color.greenToolBar_color;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(getResources().getColor(R.color.greenStatusBar_color));
                    mStatusBarColor=R.color.greenStatusBar_color;
                }
                break;
            case R.id.btn_blue:
                /**
                 * 6 - уровень лога (ERROR)
                 */
                Lg.msgLog(6, this.getLocalClassName(), "Blue Color");
                mToolbar.setBackgroundColor(getResources().getColor(R.color.blueToolBar_color));
                mToolBarColor=R.color.blueToolBar_color;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(getResources().getColor(R.color.blueStatusBar_color));
                    mStatusBarColor=R.color.blueStatusBar_color;
                }
                break;
            case R.id.btn_red:
                /**
                 * 6 - уровень лога (ERROR)
                 */
                Lg.msgLog(6, this.getLocalClassName(), "Red Color");
                mToolbar.setBackgroundColor(getResources().getColor(R.color.redToolBar_color));
                mToolBarColor=R.color.redToolBar_color;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(getResources().getColor(R.color.redStatusBar_color));
                    mStatusBarColor=R.color.redStatusBar_color;
                }
                break;
        }
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
        /**
         * Сохранение значения видимости EditText2
         * */
        outState.putBoolean(VISIBLE_KEY, mEditText2.getVisibility() == View.VISIBLE);

        /**
         * Сохранение значений цветов
         */
        outState.putInt(COLOR_TOOLBAR_KEY, mToolBarColor);
        outState.putInt(COLOR_STATUSBAR_KEY, mStatusBarColor);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        /**
         * 6 - уровень лога (ERROR)
         */
        Lg.msgLog(6, this.getLocalClassName(), "onRestoreInstanceState()");
        /**
         * Возвращаем значение видимости
         */
        int visibleState = savedInstanceState.getBoolean(VISIBLE_KEY) ? View.VISIBLE : View.INVISIBLE;
        mEditText2.setVisibility(visibleState);

        /**
         * Переменные для сохраненных значений цветов
         */
        int mTBColor = savedInstanceState.getInt(COLOR_TOOLBAR_KEY);
        int mSBColor = savedInstanceState.getInt(COLOR_STATUSBAR_KEY);

        /**
         * Красим статус бар
         */
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(mSBColor));
        }
        /**
         * Красим тул бар
         */
        mToolbar.setBackgroundColor(getResources().getColor(mTBColor));
    }
}
