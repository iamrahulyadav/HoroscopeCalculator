package yzu.money.horoscopecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button confirmBtn = (Button) findViewById(R.id.confirmBtn);

        confirmBtn.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                EditText month = (EditText) findViewById(R.id.month);
                EditText day = (EditText) findViewById(R.id.day);
                int m = 0, d = 0;
                if(!month.getText().toString().isEmpty() && !day.getText().toString().isEmpty()) { //if input is not null
                    m = Integer.parseInt(month.getText().toString());
                    d = Integer.parseInt(day.getText().toString());
                }

                //determine horoscope
                if(((m==1||m==3||m==5||m==7||m==8||m==10||m==12)&&d>=1&&d<=31)||((m==4||m==6||m==9||m==11)&&d>=1&&d<=30)||(m==2&&d>=1&&d<=29)){
                    String result;
                    switch (m){
                        case 1:
                            if(d<=20) result="摩羯座";
                            else result="水瓶座";
                            break;
                        case 2:
                            if(d<=19) result="水瓶座";
                            else result="雙魚座";
                            break;
                        case 3:
                            if(d<=20) result="雙魚座";
                            else result="牡羊座";
                            break;
                        case 4:
                            if(d<=20) result="牡羊座";
                            else result="金牛座";
                            break;
                        case 5:
                            if(d<=21) result="金牛座";
                            else result="雙子座";
                            break;
                        case 6:
                            if(d<=21) result="雙子座";
                            else result="巨蟹座";
                            break;
                        case 7:
                            if(d<=23) result="巨蟹座";
                            else result="獅子座";
                            break;
                        case 8:
                            if(d<=23) result="獅子座";
                            else result="處女座";
                            break;
                        case 9:
                            if(d<=23) result="處女座";
                            else result="天秤座";
                            break;
                        case 10:
                            if(d<=23) result="天秤座";
                            else result="天蠍座";
                            break;
                        case 11:
                            if(d<=23) result="天蠍座";
                            else result="射手座";
                            break;
                        case 12:
                            if(d<=22) result="射手座";
                            else result="摩羯座";
                            break;
                        default:
                            result="Error";
                            break;

                    }
                    printResult(m, d, result);


                }
                else{
                    dateIncorrectShow();
                }

            }
        });

    }
    public void dateIncorrectShow(){
        Toast toast = Toast.makeText(MainActivity.this,
                "請輸入正確日期", Toast.LENGTH_LONG);
        toast.show();
    }

    public void printResult(int m, int d, String result){
        //print horoscope
        TextView txtHoroscope = (TextView) findViewById(R.id.txtHoroscope);
        txtHoroscope.setText(result);

        //print date
        TextView dateShow = (TextView) findViewById(R.id.dateShow);
        dateShow.setText(String.valueOf(m)+"/"+String.valueOf(d));
    }


}
