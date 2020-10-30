package com.example.funnypoker.Enviroment;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;

public class Function extends Application {

    Context context;

    public Function(Context context) {
        this.context = context;
    }

    //Function for opening new Activity
    public static void startActivity(final Class<? extends Activity> ActivityToOpen, Context context)  {
        Intent startMain = new Intent(context, ActivityToOpen);
        context.startActivity(startMain);
    }
}