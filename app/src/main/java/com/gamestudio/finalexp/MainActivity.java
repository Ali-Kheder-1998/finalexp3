package com.gamestudio.finalexp;

import
        androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends Activity {
    private RecyclerView usersTableView;

    // Arraylist for storing data
    private ArrayList<UserRecordModel> userRecordModelArrayList;
    Button GetApi = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GetApi = (Button) findViewById(R.id.GetApi);

    }

        public void getApi (View view){
            setContentView(R.layout.users_layout);
            usersTableView = findViewById(R.id.usersInfoTable);

            String url = "https://gorest.co.in/public/v2/users";
            RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
            StringRequest pingStringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            runOnUiThread(() -> {
                                Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                                JSONArray jsonArray = null;
                                try {
                                    jsonArray = new JSONArray(response);
                                    userRecordModelArrayList = new ArrayList<>();
                                    for (int i = 0; i < jsonArray.length(); i++) {
                                        JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                                        userRecordModelArrayList.add(new UserRecordModel(
                                                jsonObject.getString("id"),
                                                jsonObject.getString("name"),
                                                jsonObject.getString("email"),
                                                jsonObject.getString("gender"),
                                                jsonObject.getString("status")));
                                    }

                                    // we are initializing our adapter class and passing our arraylist to it.
                                    UserLayoutAdapter userLayoutAdapter = new UserLayoutAdapter(getApplicationContext(), userRecordModelArrayList);

                                    // below line is for setting a layout manager for our recycler view.
                                    // here we are creating vertical list so we will provide orientation as vertical
                                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);

                                    // in below two lines we are setting layoutmanager and adapter to our recycler view.
                                    usersTableView.setLayoutManager(linearLayoutManager);
                                    usersTableView.setAdapter(userLayoutAdapter);
                                    Log.d("jArray:", Integer.toString(jsonArray.length()));
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            });
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    runOnUiThread(() -> {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    });
                    return;
                }
            });
            queue.add(pingStringRequest);
        }
}
