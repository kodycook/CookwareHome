package com.example.kody.cookwarehome;

import android.content.Context;
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


    public void postNewComment(String inKey, String inValue){
        final String key = inKey;
        final String value = inValue;

        //mPostCommentResponse.requestStarted();
        RequestQueue queue = Volley.newRequestQueue(mContext);
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
