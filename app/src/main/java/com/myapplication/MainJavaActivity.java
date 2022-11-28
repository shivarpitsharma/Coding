package com.myapplication;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

/**
 * Copyright (C) 2020 Loconav Inc.
 * <p>
 * Created by Shivarpit Sharma
 * Date: 05.09.2022
 * Time: 10:05 am
 * Email: shivarpit.sharma@loconav.com
 * <p>
 * Description:
 */
class MainJavaActivity extends AppCompatActivity {
    private EditText editText;
    private TextWatcher watcher;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}

