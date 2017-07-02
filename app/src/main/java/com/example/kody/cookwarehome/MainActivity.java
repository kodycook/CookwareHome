package com.example.kody.cookwarehome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    HttpMessage manCaveScreen;
    TelnetMessage manCaveDoorLock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manCaveScreen = new HttpMessage((TextView) findViewById(R.id.SampleText), getApplicationContext());
        manCaveDoorLock = new TelnetMessage();
    }

    public void ScreenUp(View view){
        manCaveScreen.postNewComment("Up1", "Up");
        System.out.println("Screen Up");
    }

    public void ScreenStop(View view){
        manCaveScreen.postNewComment("Stop1", "Stop");
        System.out.println("Screen Stop");
    }

    public void ScreenDown(View view) {
        manCaveScreen.postNewComment("Down1", "Down");
        System.out.println("Making Request");
    }

    public void UnlockShedDoor(View view){
        manCaveDoorLock.postNewComment("U");
        System.out.println("Unlocking Shed Door");
    }

    public void LockShedDoor(View view){
        manCaveDoorLock.postNewComment("L");
        System.out.println("Locking Shed Door");
    }
}