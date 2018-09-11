package com.example.jkwak.registeration;

import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView noticeListView;
    private NoticeListAdapter adapter;
    private List<Notice> noticeList;
    public static String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        userID = getIntent().getStringExtra("userID");

        noticeListView = (ListView) findViewById(R.id.noticeListView);
        noticeList = new ArrayList<Notice>();
        adapter = new NoticeListAdapter(getApplicationContext(), noticeList);
        noticeListView.setAdapter(adapter);

        final Button courseButton = (Button) findViewById(R.id.courseButton);
        final Button statisticsButton = (Button) findViewById(R.id.statisticsButton);
        final Button scheduleButton = (Button) findViewById(R.id.scheduleButton);
        final LinearLayout notice = (LinearLayout) findViewById(R.id.notice);

        courseButton.setOnClickListener(new View.OnClickListener(){ // 강의 목록 버튼 클릭 이벤트

            @Override
            public void onClick(View view) {
                notice.setVisibility(View.GONE); // 공지사항 ListView 사라짐
                courseButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark)); // 클릭한 부분만 어둡게 잠시 표시
                statisticsButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                scheduleButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction(); // 다른 fragment로 교체
                fragmentTransaction.replace(R.id.fragment, new CourseFragment());
                fragmentTransaction.commit(); // commit으로 마무리하여 동작을 시행
            }
        });

        statisticsButton.setOnClickListener(new View.OnClickListener(){ // 내 강의 버튼 클릭 이벤트
            @Override
            public void onClick(View view) {
                notice.setVisibility(View.GONE); // 공지사항 ListView 사라짐
                courseButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                statisticsButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark)); // 클릭한 부분만 어둡게 잠시 표시
                scheduleButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new StatisticsFragment());
                fragmentTransaction.commit();
            }
        });

        scheduleButton.setOnClickListener(new View.OnClickListener(){ // 시간표 버튼 클릭 이벤트
            @Override
            public void onClick(View view) {
                notice.setVisibility(View.GONE); // 공지사항 ListView 사라짐
                courseButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                statisticsButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                scheduleButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark)); // 클릭한 부분만 어둡게 잠시 표시
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new ScheduleFragment());
                fragmentTransaction.commit();
            }
        });

        new BackgroundTask().execute(); // 정상적으로 진행
    }

    class BackgroundTask extends AsyncTask<Void, Void, String> {
        String target;

        @Override
        protected void onPreExecute() {
            target = "http://ghdtjrdn0323.cafe24.com/NoticeList.php";
        } // Background 작업 시작 전에 UI 작업을 진행

        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL(target); // URL 연결
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection(); // URL 연결
                InputStream inputStream = httpURLConnection.getInputStream(); // 넘어오는 결과값들을 그대로 저장할 수 있음
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream)); // 해당 InputStream에 있는 내용들을 버퍼에 담아서 읽을 수 있도록
                String temp; // 문자형
                StringBuilder stringBuilder = new StringBuilder(); // 하나씩 읽음
                while ((temp = bufferedReader.readLine()) != null) { // 한줄씩 읽음 null 값이 아닐때까지
                    stringBuilder.append(temp + "\n"); // 한줄씩 추가
                }
                bufferedReader.close(); // 끝나면 닫기
                inputStream.close(); // 끝나면 닫기
                httpURLConnection.disconnect(); // 연결 끊기
                return stringBuilder.toString().trim(); // 값 반환
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public void onProgressUpdate(Void... values) {
            super.onProgressUpdate();
        }

        @Override
        public void onPostExecute(String result) { // 해당 결과를 처리할 수 있는 onPostExecute
            try {
                JSONObject jsonObject = new JSONObject(result); // 해당 result response 부분을 처리
                JSONArray jsonArray = jsonObject.getJSONArray("response");
                int count = 0;
                String noticeContent, noticeName, noticeDate;
                while (count < jsonArray.length()) { // 전체 크기보다 작을 때까지
                    JSONObject object = jsonArray.getJSONObject(count);
                    noticeContent = object.getString("noticeContent"); // 각 정보를 가져온다
                    noticeName = object.getString("noticeName");
                    noticeDate = object.getString("noticeDate");
                    Notice notice = new Notice(noticeContent, noticeName, noticeDate); // 하나의 객체 생성
                    noticeList.add(notice);
                    count++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private long lastTimeBackPressed;

    @Override
    public void onBackPressed() {
        if(System.currentTimeMillis() - lastTimeBackPressed < 1500)
        {
            finish();
            return;
        }
        Toast.makeText(this,"'뒤로' 버튼을 한 번 더 눌러 종료합니다.", Toast.LENGTH_SHORT);
        lastTimeBackPressed = System.currentTimeMillis();
    }
}