package com.congfandi.quisgame.settings;

import android.content.Context;
import android.content.Intent;

import com.congfandi.quisgame.model.MyInterface;

/**
 * Created by congf on 18/12/2017.
 */

public class Setting {
    Context context;

    public Setting() {
    }

    public Setting(Context context) {
        this.context = context;
    }

    public void gonextPage(Context context, Class<?> cls, MyInterface.Hasil hasil) {
        Intent intent = new Intent(context, cls);
        context.startActivity(intent);
        hasil.hasil();
    }
}
