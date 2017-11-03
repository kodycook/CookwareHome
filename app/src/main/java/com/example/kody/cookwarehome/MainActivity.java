package com.example.kody.cookwarehome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {
    HttpMessage manCaveProjector;
    HttpMessage manCaveScreen;
    TelnetMessage manCaveDoorLock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manCaveScreen = new HttpMessage((TextView) findViewById(R.id.ScreenSuccess), getApplicationContext());
        manCaveProjector = new HttpMessage((TextView) findViewById(R.id.ProjectorSuccess), getApplicationContext());
    }

    public void ProjectorOn (View view){
        String action = "Projector On";
        Map<String,String> params = new HashMap<String, String>();
        params.put("key", "pow_on");
        params.put("lang", "e");
        params.put("osd", "on");
        manCaveProjector.getNewComment("http://10.1.1.16/cgi-bin/proj_ctl.cgi?key=pow_on&lang=e&osd=on", params, action);
        System.out.println(action);
    }

    public void ProjectorOff (View view){
        String action = "Projector Off";
        Map<String,String> params = new HashMap<String, String>();
        params.put("key", "pow_off");
        params.put("lang", "e");
        params.put("osd", "on");
        manCaveProjector.getNewComment("http://10.1.1.16/cgi-bin/proj_ctl.cgi?key=pow_off&lang=e&osd=on", params, action);
        System.out.println(action);
    }

    public void ScreenUp(View view){
        String action = "Screen up";
        Map<String,String> params = new HashMap<String, String>();
        params.put("Up1", "Up");
        manCaveScreen.postNewComment("http://10.1.1.20/ADirectControl.html", params, action);
        System.out.println(action);
    }

    public void ScreenStop(View view){
        String action = "Screen Stop";
        Map<String,String> params = new HashMap<String, String>();
        params.put("Stop1", "Stop");
        manCaveScreen.postNewComment("http://10.1.1.20/ADirectControl.html", params, action);
        System.out.println(action);
    }

    public void ScreenDown(View view) {
        String action = "Screen Down";
        Map<String,String> params = new HashMap<String, String>();
        params.put("Down1", "Down");
        manCaveScreen.postNewComment("http://10.1.1.20/ADirectControl.html", params, action);
        System.out.println(action);
    }

    public void UnlockShedDoor(View view){
        manCaveDoorLock = new TelnetMessage();
        manCaveDoorLock.postNewComment("U");
        System.out.println("Unlocking Shed Door");
    }

    public void LockShedDoor(View view){
        manCaveDoorLock = new TelnetMessage();
        manCaveDoorLock.postNewComment("L");
        System.out.println("Locking Shed Door");
    }

    public void ToggleGarageDoor(View view){
        manCaveDoorLock = new TelnetMessage();
        manCaveDoorLock.postNewComment("G");
        System.out.println("Toggling Garage Door");
    }
}