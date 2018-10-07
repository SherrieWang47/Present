package com.example.wangsiqi.present;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.ImageView;


public class ZipcodeActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE_Fullname = "com.example.wangsiqi.present.MESSAGE";
    public static final String EXTRA_MESSAGE_Party = "com.example.wangsiqi.present.MESSAGE2";
    public static final String EXTRA_MESSAGE_Birthday = "com.example.wangsiqi.present.MESSAGE3";
    public static final String EXTRA_MESSAGE_Adress = "com.example.wangsiqi.present.MESSAGE4";


    private RequestQueue mQueue;
    private RequestQueue mImagQueue;
    private RequestQueue mCommitteeQue;

    private TextView mFullname1;
    private TextView mFullname2;
    private TextView mFullname3;
    private TextView mFullname4;
    private TextView mFullname5;
    private List<TextView> p_fullname = new ArrayList<>();
    private TextView mFullname;

    private TextView mcommittee;
//    private TextView[] p_fullname = new TextView[2];

    private TextView mParty1;
    private TextView mParty2;
    private TextView mParty3;
    private TextView mParty4;
    private TextView mParty5;
    private List<TextView> p_party = new ArrayList<>();
    private TextView mParty;

    private TextView mEmail1;
    private TextView mEmail2;
    private TextView mEmail3;
    private TextView mEmail4;
    private TextView mEmail5;
    private List<TextView> p_email = new ArrayList<>();
    private ImageView ivEmail1;
    private ImageView ivEmail2;
    private ImageView ivEmail3;
    private ImageView ivEmail4;
    private ImageView ivEmail5;
    private List<ImageView> p_ivemail = new ArrayList<>();

    private TextView mHomepage1;
    private TextView mHomepage2;
    private TextView mHomepage3;
    private TextView mHomepage4;
    private TextView mHomepage5;
    private List<TextView> p_homepage = new ArrayList<>();
    private ImageView ivHomepage1;
    private ImageView ivHomepage2;
    private ImageView ivHomepage3;
    private ImageView ivHomepage4;
    private ImageView ivHomepage5;
    private List<ImageView> p_ivhomepage = new ArrayList<>();

    private ImageView mimg1;
    private ImageView mimg2;
    private ImageView mimg3;
    private ImageView mimg4;
    private ImageView mimg5;
    private List<ImageView> p_img = new ArrayList<>();

    private Button mbtn1;
    private Button mbtn2;
    private Button mbtn3;
    private Button mbtn4;
    private Button mbtn5;
    private List<Button> p_btn = new ArrayList<>();

    private TextView mbirthday;
    private TextView maddress;

    private String[] zip_codes = {"10012","12201","30301","21401","21201","35201","14201","60601",
        "45201","44101","43085","71953","80002","99701","19019","46201","92101","54321",
        "63101","98101","33601"};
    int index=(int)(Math.random()*zip_codes.length);

//    //在消息队列中实现对控件的更改
//    private Handler handle = new Handler() {
//        public void handleMessage(Message msg) {
//            switch (msg.what) {
//                case 0:
//                    System.out.println("111");
//                    Bitmap bmp=(Bitmap)msg.obj;
//                    mSenatorimg1.setImageBitmap(bmp);
//                    break;
//            }
//        };
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zipcode);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity0927.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.inputZip);
        textView.setText(message);
        String inputZipcode =textView.getText().toString();

        if (inputZipcode.length() == 0) {
            inputZipcode = zip_codes[index];
            textView.setText(inputZipcode);
        }

        mimg1 = (ImageView) findViewById(R.id.ivSenator1);
        mimg2 = (ImageView) findViewById(R.id.ivSenator2);
        mimg3 = (ImageView) findViewById(R.id.ivSenator3);
        mimg4 = (ImageView) findViewById(R.id.ivSenator4);
        mimg5 = (ImageView) findViewById(R.id.ivSenator5);
        p_img.add(mimg4);
        p_img.add(mimg5);


        mFullname1 = findViewById(R.id.tvFullname1);
        mFullname2 = findViewById(R.id.tvFullname2);
        mFullname3 = findViewById(R.id.tvFullname3);
        mFullname4 = findViewById(R.id.tvFullname4);
        mFullname5 = findViewById(R.id.tvFullname5);
        p_fullname.add(mFullname4);
        p_fullname.add(mFullname5);
        mFullname = findViewById(R.id.tvFullname);

        mParty1 = findViewById(R.id.tvParty1);
        mParty2 = findViewById(R.id.tvParty2);
        mParty3 = findViewById(R.id.tvParty3);
        mParty4 = findViewById(R.id.tvParty4);
        mParty5 = findViewById(R.id.tvParty5);
        p_party.add(mParty4);
        p_party.add(mParty5);
        mParty = findViewById(R.id.tvParty);

        mEmail1 = findViewById(R.id.tvEmail1);
        mEmail2 = findViewById(R.id.tvEmail2);
        mEmail3 = findViewById(R.id.tvEmail3);
        mEmail4 = findViewById(R.id.tvEmail4);
        mEmail5 = findViewById(R.id.tvEmail5);
        p_email.add(mEmail4);
        p_email.add(mEmail5);
        ivEmail1 = findViewById(R.id.ivEmail1);
        ivEmail2 = findViewById(R.id.ivEmail2);
        ivEmail3 = findViewById(R.id.ivEmail3);
        ivEmail4 = findViewById(R.id.ivEmail4);
        ivEmail5 = findViewById(R.id.ivEmail5);
        p_ivemail.add(ivEmail4);
        p_ivemail.add(ivEmail5);

        mHomepage1 = findViewById(R.id.tvHomepage1);
        mHomepage2 = findViewById(R.id.tvHomepage2);
        mHomepage3 = findViewById(R.id.tvHomepage3);
        mHomepage4 = findViewById(R.id.tvHomepage4);
        mHomepage5 = findViewById(R.id.tvHomepage5);
        p_homepage.add(mHomepage4);
        p_homepage.add(mHomepage5);
        ivHomepage1 = findViewById(R.id.ivHomepage1);
        ivHomepage2 = findViewById(R.id.ivHomepage2);
        ivHomepage3 = findViewById(R.id.ivHomepage3);
        ivHomepage4 = findViewById(R.id.ivHomepage4);
        ivHomepage5 = findViewById(R.id.ivHomepage5);
        p_ivhomepage.add(ivHomepage4);
        p_ivhomepage.add(ivHomepage5);

        mbtn1 = findViewById(R.id.btMore1);
        mbtn2 = findViewById(R.id.btMore2);
        mbtn3 = findViewById(R.id.btMore3);
        mbtn4 = findViewById(R.id.btMore4);
        mbtn5 = findViewById(R.id.btMore5);
        p_btn.add(mbtn4);
        p_btn.add(mbtn5);

        mbirthday = findViewById(R.id.mbirthday);
        maddress = findViewById(R.id.maddress);

        mQueue = Volley.newRequestQueue(this);
        mImagQueue = Volley.newRequestQueue(this.getApplicationContext());
        mCommitteeQue = Volley.newRequestQueue(this);

        jsonParse(inputZipcode);


//        btn.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                //新建线程加载图片信息，发送到消息队列中
//                new Thread(new Runnable() {
//
//                    @Override
//                    public void run() {
//                        // TODO Auto-generated method stub
//                        Bitmap bmp = getURLimage(img_url);
//                        Message msg = new Message();
//                        msg.what = 0;
//                        msg.obj = bmp;
//                        System.out.println("000");
//                        handle.sendMessage(msg);
//                    }
//                }).start();
//            }
//        });
//    }


    }

    /** Called when the user taps the moreInformation button */
    public void moreInformation(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, DetailedActivity.class);

        String message = mFullname1.getText().toString();
        intent.putExtra(EXTRA_MESSAGE_Fullname, message);

        String party = mParty1.getText().toString();
        intent.putExtra(EXTRA_MESSAGE_Party, party);

        String birthday = mbirthday.getText().toString();
        String address = maddress.getText().toString();
        intent.putExtra(EXTRA_MESSAGE_Birthday, birthday);
        intent.putExtra(EXTRA_MESSAGE_Adress, address);

        startActivity(intent);
    }

    private void jsonParse(String zipcode) {

        String url = "https://api.geocod.io/v1.3/geocode?postal_code="+zipcode+"&fields=cd,stateleg&api_key=9b5e7da5679a2d259b222bbca55b4a2db75515b";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("results");
                            JSONArray congressional_districts = jsonArray.getJSONObject(0).getJSONObject("fields").getJSONArray("congressional_districts");
                            JSONArray current_legislators = congressional_districts.getJSONObject(0).getJSONArray("current_legislators");

                            //Senator 1
                            String s_last_name1 = current_legislators.getJSONObject(1).getJSONObject("bio").getString("last_name");
                            String s_first_name1 = current_legislators.getJSONObject(1).getJSONObject("bio").getString("first_name");
                            String s_full_name1 = s_first_name1 + " " + s_last_name1;
                            String s_party1 = current_legislators.getJSONObject(1).getJSONObject("bio").getString("party");
                            String s_email1 = current_legislators.getJSONObject(1).getJSONObject("contact").getString("contact_form");
                            String s_homepage1 = current_legislators.getJSONObject(1).getJSONObject("contact").getString("url");
                            String mid1 = current_legislators.getJSONObject(1).getJSONObject("references").getString("bioguide_id");
                            jsonImage(mid1, mimg1);
                            System.out.println(mid1);
                            //jsonCommittee(mid1);
                            mFullname1.setText(s_full_name1);
                            mParty1.setText(s_party1);
                            mEmail1.setText(s_email1);
                            mHomepage1.setText(s_homepage1);
                            mbtn1.setBackgroundResource(R.drawable.mbtn_more);
                            ivEmail1.setImageResource(R.drawable.email_icon);
                            ivHomepage1.setImageResource(R.drawable.homepage_icon);
                            String birthday = current_legislators.getJSONObject(1).getJSONObject("bio").getString("birthday");
                            String address = current_legislators.getJSONObject(1).getJSONObject("contact").getString("address");
                            mbirthday.setText(birthday);
                            maddress.setText(address);

                            //Senator 2
                            String s_last_name2 = current_legislators.getJSONObject(2).getJSONObject("bio").getString("last_name");
                            String s_first_name2 = current_legislators.getJSONObject(2).getJSONObject("bio").getString("first_name");
                            String s_full_name2 = s_first_name2 + " " + s_last_name2;
                            String s_party2 = current_legislators.getJSONObject(2).getJSONObject("bio").getString("party");
                            String s_email2 = current_legislators.getJSONObject(2).getJSONObject("contact").getString("contact_form");
                            String s_homepage2 = current_legislators.getJSONObject(2).getJSONObject("contact").getString("url");
                            String mid2 = current_legislators.getJSONObject(2).getJSONObject("references").getString("bioguide_id");
                            jsonImage(mid2, mimg2);
                            mFullname2.setText(s_full_name2);
                            mParty2.setText(s_party2);
                            mEmail2.setText(s_email2);
                            mHomepage2.setText(s_homepage2);
                            mbtn2.setBackgroundResource(R.drawable.mbtn_more);
                            ivEmail2.setImageResource(R.drawable.email_icon);
                            ivHomepage2.setImageResource(R.drawable.homepage_icon);

                            //Representative 1
                            String s_last_name3 = current_legislators.getJSONObject(0).getJSONObject("bio").getString("last_name");
                            String s_first_name3 = current_legislators.getJSONObject(0).getJSONObject("bio").getString("first_name");
                            String s_full_name3 = s_first_name3 + " " + s_last_name3;
                            String s_party3 = current_legislators.getJSONObject(0).getJSONObject("bio").getString("party");
                            String s_email3 = current_legislators.getJSONObject(0).getJSONObject("contact").getString("contact_form");
                            String s_homepage3 = current_legislators.getJSONObject(0).getJSONObject("contact").getString("url");
                            String mid3 = current_legislators.getJSONObject(0).getJSONObject("references").getString("bioguide_id");
                            jsonImage(mid3, mimg3);
                            mFullname3.setText(s_full_name3);
                            mParty3.setText(s_party3);
                            mEmail3.setText(s_email3);
                            mHomepage3.setText(s_homepage3);
                            mbtn3.setBackgroundResource(R.drawable.mbtn_more);
                            ivEmail3.setImageResource(R.drawable.email_icon);
                            ivHomepage3.setImageResource(R.drawable.homepage_icon);

                            if (congressional_districts.length() > 1) {

                                for (int i = 1; i < congressional_districts.length(); i++) {
                                    System.out.println("more");
                                    JSONArray all_representatives = congressional_districts.getJSONObject(i).getJSONArray("current_legislators");

                                    String last_name = all_representatives.getJSONObject(0).getJSONObject("bio").getString("last_name");
                                    String first_name = all_representatives.getJSONObject(0).getJSONObject("bio").getString("first_name");
                                    String full_name = first_name + " " + last_name;
                                    System.out.println(full_name);
                                    String party = all_representatives.getJSONObject(0).getJSONObject("bio").getString("party");
                                    String contact_form = all_representatives.getJSONObject(0).getJSONObject("contact").getString("contact_form");
                                    String homepage = all_representatives.getJSONObject(0).getJSONObject("contact").getString("url");
                                    String mid = all_representatives.getJSONObject(0).getJSONObject("references").getString("bioguide_id");
                                    jsonImage(mid,p_img.get(i-1));
                                    p_fullname.get(i-1).setText(full_name);
                                    System.out.println("fullname:"+full_name);
                                    p_party.get(i-1).setText(party);
                                    p_email.get(i-1).setText(contact_form);
                                    p_homepage.get(i-1).setText(homepage);
                                    p_btn.get(i-1).setBackgroundResource(R.drawable.mbtn_more);
                                    p_ivemail.get(i-1).setImageResource(R.drawable.email_icon);
                                    p_ivhomepage.get(i-1).setImageResource(R.drawable.homepage_icon);

//                                mTextViewResult.append(location + "\n");
//                                System.out.println("location:"+location + "\n");
                                }

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mQueue.add(request);
    }

    private void jsonImage(String mid, final ImageView img) {

        char mchar = mid.charAt(0);
        String image_url = "http://bioguide.congress.gov/bioguide/photo/"+mchar+"/"+mid+".jpg";

        ImageRequest imageRequest = new ImageRequest(image_url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap bitmap) {
                img.setImageBitmap(bitmap);
            }
        }, 0, 0, null, null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                img.setImageResource(R.drawable.warning);
            }
        });
        mImagQueue.add(imageRequest);
    }

    private void jsonCommittee(String mid) {
        String committee_url = "https://api.propublica.org/congress/v1/members/G000555.json?X-API-Key=YMNV0Jse8InPSzzwhtIQtrAyZ6Sew80QZDc2o65w";
        JsonObjectRequest committee_request = new JsonObjectRequest(Request.Method.GET, committee_url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray committee_jsonArray = response.getJSONArray("results");
                            JSONObject role_one = committee_jsonArray.getJSONObject(0).getJSONArray("roles").getJSONObject(0);
                            JSONArray committee = role_one.getJSONArray("committees");
                            for (int i = 1; i < committee.length(); i++) {
                                JSONObject committee_names = committee.getJSONObject(i);
                                String committee_name = committee_names.getString("name");
                                mcommittee.append(committee_name + "\n");
                                System.out.println(mcommittee);

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mCommitteeQue.add(committee_request);

    }


    //加载图片
    public Bitmap getURLimage(String img_url) {
        Bitmap bmp = null;
        try {
            URL myurl = new URL(img_url);
            // 获得连接
            HttpURLConnection conn = (HttpURLConnection) myurl.openConnection();
            conn.setConnectTimeout(6000);//设置超时
            conn.setDoInput(true);
            conn.setUseCaches(false);//不缓存
            conn.connect();
            InputStream is = conn.getInputStream();//获得图片的数据流
            bmp = BitmapFactory.decodeStream(is);
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bmp;
    }


}


