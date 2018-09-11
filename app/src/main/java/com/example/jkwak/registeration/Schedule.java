package com.example.jkwak.registeration;

import android.content.Context;

public class Schedule {

    private String monday[] = new String[20]; // 최대 20교시
    private String tuesday[] = new String[20];
    private String wednesday[] = new String[20];
    private String thursday[] = new String[20];
    private String friday[] = new String[20];

    public Schedule() {
        for(int i = 0; i<20; i++)
        {
            monday[i] = ""; // 빈 시간표
            tuesday[i] = "";
            wednesday[i] = "";
            thursday[i] = "";
            friday[i] = "";
        }
    }

    public void addSchedule(String scheduleText) { // 이 데이터를 파싱해서 앞에 배열에 넣는다
        int temp;
        // 월:[3][4][5] 화:[4][5]
        if((temp = scheduleText.indexOf("월")) > -1) // 월이라는 단어가 포함된다면
        {
            temp +=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i = temp; i < scheduleText.length() && scheduleText.charAt(i) != ':'; i++)
            {
                if(scheduleText.charAt(i) == '[')
                {
                    startPoint = i;
                }
                if(scheduleText.charAt(i) == ']')
                {
                    endPoint = i;
                    monday[Integer.parseInt(scheduleText.substring(startPoint + 1, endPoint))] = "수업";
                }
            }
        }
        if((temp = scheduleText.indexOf("화")) >-1)
        {
            temp +=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i = temp; i<scheduleText.length() && scheduleText.charAt(i) != ':'; i++)
            {
                if(scheduleText.charAt(i) == '[')
                {
                    startPoint = i;
                }
                if(scheduleText.charAt(i) == ']')
                {
                    endPoint = i;
                    tuesday[Integer.parseInt(scheduleText.substring(startPoint + 1, endPoint))] = "수업";
                }
            }
        }
        if((temp = scheduleText.indexOf("수")) >-1)
        {
            temp +=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i = temp; i<scheduleText.length() && scheduleText.charAt(i) != ':'; i++)
            {
                if(scheduleText.charAt(i) == '[')
                {
                    startPoint = i;
                }
                if(scheduleText.charAt(i) == ']')
                {
                    endPoint = i;
                    wednesday[Integer.parseInt(scheduleText.substring(startPoint + 1, endPoint))] = "수업";
                }
            }
        }
        if((temp = scheduleText.indexOf("목")) >-1)
        {
            temp +=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i = temp; i<scheduleText.length() && scheduleText.charAt(i) != ':'; i++)
            {
                if(scheduleText.charAt(i) == '[')
                {
                    startPoint = i;
                }
                if(scheduleText.charAt(i) == ']')
                {
                    endPoint = i;
                    thursday[Integer.parseInt(scheduleText.substring(startPoint + 1, endPoint))] = "수업";
                }
            }
        }
        if((temp = scheduleText.indexOf("금")) >-1)
        {
            temp +=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i = temp; i<scheduleText.length() && scheduleText.charAt(i) != ':'; i++)
            {
                if(scheduleText.charAt(i) == '[')
                {
                    startPoint = i;
                }
                if(scheduleText.charAt(i) == ']')
                {
                    endPoint = i;
                    friday[Integer.parseInt(scheduleText.substring(startPoint + 1, endPoint))] = "수업";
                }
            }
        }
    }

    public boolean validate(String scheduleText) { // 중복체크
        if(scheduleText.equals("")) // 시간표 빈칸인 경우
        {
            return true;
        }
        int temp;
        if((temp = scheduleText.indexOf("월")) >-1)
        {
            temp +=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i = temp; i<scheduleText.length() && scheduleText.charAt(i) != ':'; i++)
            {
                if(scheduleText.charAt(i) == '[')
                {
                    startPoint = i;
                }
                if(scheduleText.charAt(i) == ']')
                {
                    endPoint = i;
                    if(!monday[Integer.parseInt(scheduleText.substring(startPoint + 1, endPoint))].equals(""))
                    {
                        return false;
                    }
                }
            }
        }
        if((temp = scheduleText.indexOf("화")) >-1)
        {
            temp +=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i = temp; i<scheduleText.length() && scheduleText.charAt(i) != ':'; i++)
            {
                if(scheduleText.charAt(i) == '[')
                {
                    startPoint = i;
                }
                if(scheduleText.charAt(i) == ']')
                {
                    endPoint = i;
                    if(!tuesday[Integer.parseInt(scheduleText.substring(startPoint + 1, endPoint))].equals("")) // 공백이 아니라면
                    {
                        return false; // 해당 시간표는 중복이 되면 안됨
                    }
                }
            }
        }
        if((temp = scheduleText.indexOf("수")) >-1)
        {
            temp +=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i = temp; i<scheduleText.length() && scheduleText.charAt(i) != ':'; i++)
            {
                if(scheduleText.charAt(i) == '[')
                {
                    startPoint = i;
                }
                if(scheduleText.charAt(i) == ']')
                {
                    endPoint = i;
                    if(!wednesday[Integer.parseInt(scheduleText.substring(startPoint + 1, endPoint))].equals(""))
                    {
                        return false;
                    }
                }
            }
        }
        if((temp = scheduleText.indexOf("목")) >-1)
        {
            temp +=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i = temp; i<scheduleText.length() && scheduleText.charAt(i) != ':'; i++)
            {
                if(scheduleText.charAt(i) == '[')
                {
                    startPoint = i;
                }
                if(scheduleText.charAt(i) == ']')
                {
                    endPoint = i;
                    if(!thursday[Integer.parseInt(scheduleText.substring(startPoint + 1, endPoint))].equals(""))
                    {
                        return false;
                    }
                }
            }
        }
        if((temp = scheduleText.indexOf("금")) >-1)
        {
            temp +=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i = temp; i<scheduleText.length() && scheduleText.charAt(i) != ':'; i++)
            {
                if(scheduleText.charAt(i) == '[')
                {
                    startPoint = i;
                }
                if(scheduleText.charAt(i) == ']')
                {
                    endPoint = i;
                    if(!friday[Integer.parseInt(scheduleText.substring(startPoint + 1, endPoint))].equals(""))
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public void addSchedule(String scheduleText, String courseTitle, String courseProfessor) { // 해당 강의 제목, 강의 교수 이름을 받음
        String professor; // 교수 변수 선언
        if(courseProfessor.equals("")) // 교수가 빈칸이면 빈칸
        {
            professor = "";
        }
        else
        {
            professor = "";
        }
        int temp;
        if((temp = scheduleText.indexOf("월")) >-1)
        {
            temp +=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i = temp; i<scheduleText.length() && scheduleText.charAt(i) != ':'; i++)
            {
                if(scheduleText.charAt(i) == '[')
                {
                    startPoint = i;
                }
                if(scheduleText.charAt(i) == ']')
                {
                    endPoint = i;
                    monday[Integer.parseInt(scheduleText.substring(startPoint + 1, endPoint))] = courseTitle + professor; // 해당 배열에 강의 제목과 교수님이 들어감
                }
            }
        }
        if((temp = scheduleText.indexOf("화")) >-1)
        {
            temp +=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i = temp; i<scheduleText.length() && scheduleText.charAt(i) != ':'; i++)
            {
                if(scheduleText.charAt(i) == '[')
                {
                    startPoint = i;
                }
                if(scheduleText.charAt(i) == ']')
                {
                    endPoint = i;
                    tuesday[Integer.parseInt(scheduleText.substring(startPoint + 1, endPoint))] = courseTitle + professor;
                }
            }
        }
        if((temp = scheduleText.indexOf("수")) >-1)
        {
            temp +=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i = temp; i<scheduleText.length() && scheduleText.charAt(i) != ':'; i++)
            {
                if(scheduleText.charAt(i) == '[')
                {
                    startPoint = i;
                }
                if(scheduleText.charAt(i) == ']')
                {
                    endPoint = i;
                    wednesday[Integer.parseInt(scheduleText.substring(startPoint + 1, endPoint))] = courseTitle + professor;
                }
            }
        }
        if((temp = scheduleText.indexOf("목")) >-1)
        {
            temp +=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i = temp; i<scheduleText.length() && scheduleText.charAt(i) != ':'; i++)
            {
                if(scheduleText.charAt(i) == '[')
                {
                    startPoint = i;
                }
                if(scheduleText.charAt(i) == ']')
                {
                    endPoint = i;
                    thursday[Integer.parseInt(scheduleText.substring(startPoint + 1, endPoint))] = courseTitle + professor;
                }
            }
        }
        if((temp = scheduleText.indexOf("금")) >-1)
        {
            temp +=2;
            int startPoint = temp;
            int endPoint = temp;
            for(int i = temp; i<scheduleText.length() && scheduleText.charAt(i) != ':'; i++)
            {
                if(scheduleText.charAt(i) == '[')
                {
                    startPoint = i;
                }
                if(scheduleText.charAt(i) == ']')
                {
                    endPoint = i;
                    friday[Integer.parseInt(scheduleText.substring(startPoint + 1, endPoint))] = courseTitle + professor;
                }
            }
        }
    }

    // 해당 강의 목록들을 시간표에 보여줄 수 있도록 하는 setting 함수
    public void setting(AutoResizeTextView[] monday, AutoResizeTextView[] tuesday, AutoResizeTextView[] wednesday, AutoResizeTextView[] thursday, AutoResizeTextView[] friday, Context context) {
        int maxLength = 0;
        String maxString = "";
        for(int i=0; i<20; i++)
        {
            if(this.monday[i].length() > maxLength) // 현재의 텍스트가 maxlength보다 길다면
            {
                maxLength = this.monday[i].length(); // 갱신
                maxString = this.monday[i]; // 현재 가장 긴 문자열을 넣어 줌
            }
            if(this.tuesday[i].length() > maxLength)
            {
                maxLength = this.tuesday[i].length();
                maxString = this.tuesday[i];
            }
            if(this.wednesday[i].length() > maxLength)
            {
                maxLength = this.wednesday[i].length();
                maxString = this.wednesday[i];
            }
            if(this.thursday[i].length() > maxLength)
            {
                maxLength = this.thursday[i].length();
                maxString = this.thursday[i];
            }
            if(this.friday[i].length() > maxLength)
            {
                maxLength = this.friday[i].length();
                maxString = this.friday[i];
            }
        }
        for(int i = 0; i<20; i++)
        {
            if(!this.monday[i].equals("")) // 비어 있지 않다면 해당 텍스트뷰에 해당 강의를 출력
            {
                monday[i].setText(this.monday[i]);
                monday[i].setTextColor(context.getResources().getColor(R.color.colorPrimaryDark));
            }
            else
            {
                monday[i].setText(maxString);
            }
            if(!this.tuesday[i].equals(""))
            {
                tuesday[i].setText(this.tuesday[i]);
                tuesday[i].setTextColor(context.getResources().getColor(R.color.colorPrimaryDark));
            }
            else
            {
                tuesday[i].setText(maxString);
            }
            if(!this.wednesday[i].equals(""))
            {
                wednesday[i].setText(this.wednesday[i]);
                wednesday[i].setTextColor(context.getResources().getColor(R.color.colorPrimaryDark));
            }
            else
            {
                wednesday[i].setText(maxString);
            }
            if(!this.thursday[i].equals(""))
            {
                thursday[i].setText(this.thursday[i]);
                thursday[i].setTextColor(context.getResources().getColor(R.color.colorPrimaryDark));
            }
            else
            {
                thursday[i].setText(maxString);
            }
            if(!this.friday[i].equals(""))
            {
                friday[i].setText(this.friday[i]);
                friday[i].setTextColor(context.getResources().getColor(R.color.colorPrimaryDark));
            }
            else
            {
                friday[i].setText(maxString);
            }
            monday[i].resizeText();
            tuesday[i].resizeText();
            wednesday[i].resizeText();
            thursday[i].resizeText();
            friday[i].resizeText();
        }
    }

}