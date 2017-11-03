package com.example.kody.cookwarehome;

import android.content.Context;
import android.util.Base64;
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

/**
 * Created by Kody on 2/07/2017.
 */

public class HttpMessage {
    private TextView mTextView;
    private Context mContext;

    public HttpMessage(TextView textView, Context context){
        mContext = context;
        mTextView = textView;
    }


    public void postNewComment(String url, Map<String,String> mParams, String mAction){
        final Map<String,String> params = mParams;
        final String action = mAction;

        //mPostCommentResponse.requestStarted();
        RequestQueue queue = Volley.newRequestQueue(mContext);
        StringRequest sr = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                mTextView.setText(String.format("%s Success", action));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mTextView.setText(String.format("%s Failed", action));
            }
        }){
            @Override
            protected Map<String,String> getParams(){

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


    public void getNewComment(String url, Map<String,String> mParams, String mAction){
        final Map<String,String> params = mParams;
        final String action = mAction;

        //mPostCommentResponse.requestStarted();
        RequestQueue queue = Volley.newRequestQueue(mContext);
        StringRequest sr = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                mTextView.setText(String.format("%s Success", action));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mTextView.setText(String.format("%s Failed", action));
            }
        }){
            @Override
            protected Map<String,String> getParams(){
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                // Include headers here if nessecary

                // PROJECTOR SPECIFIC
                String creds = String.format("%s:%s","user1","panasonic");
                String auth = "Basic " + Base64.encodeToString(creds.getBytes(), Base64.DEFAULT);
                params.put("Authorization", auth);

                return params;
            }
        };
        queue.add(sr);
    }
}
