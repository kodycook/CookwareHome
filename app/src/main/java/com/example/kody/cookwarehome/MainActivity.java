package com.example.kody.cookwarehome;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ScreenUp(View view){

        postNewComment("Up1", "Up");
        System.out.println("Screen Up");
    }

    public void ScreenStop(View view){

        postNewComment("Stop1", "Stop");
        System.out.println("Screen Stop");
    }

    public void ScreenDown(View view) {

        postNewComment("Down1", "Down");
        System.out.println("Making Request");
    }


    public void postNewComment(String inKey, String inValue){
        final TextView mTextView = (TextView) findViewById(R.id.SampleText);
        final String key = inKey;
        final String value = inValue;

        //mPostCommentResponse.requestStarted();
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        StringRequest sr = new StringRequest(Request.Method.POST,"http://10.1.1.20/ADirectControl.html", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                mTextView.setText(String.format("Screen %s success", value));
                //mPostCommentResponse.requestCompleted();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mTextView.setText(String.format("Screen %s failed", value));
                //mPostCommentResponse.requestEndedWithError(error);
            }
        }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put(key, value);

                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                // Include headers here if nessecary

                return params;
            }
        };
        queue.add(sr);
    }
}