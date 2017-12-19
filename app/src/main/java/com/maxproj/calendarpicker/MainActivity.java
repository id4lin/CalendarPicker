package com.maxproj.calendarpicker;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.maxproj.calendarpicker.Fragments.FragmentCalendarPicker;
import com.maxproj.calendarpicker.Models.YearMonthDay;
import com.maxproj.calendarpicker.Config.MyConfig;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button_open = (Button) findViewById(R.id.button_open);
        button_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Builder builder = new Builder(MainActivity.this, new Builder.CalendarPickerOnConfirm() {
                    @Override
                    public void onComplete(YearMonthDay yearMonthDay) {
                        MyConfig.uiToast("You pick "+yearMonthDay.year+"-"+yearMonthDay.month+"-"+yearMonthDay.day);
                    }
                })
                        .restoreDefault();
                builder.show();
            }
        });

        Button button_preset = (Button) findViewById(R.id.button_preset);
        button_preset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Builder builder = new Builder(MainActivity.this, new Builder.CalendarPickerOnConfirm() {
                    @Override
                    public void onComplete(YearMonthDay yearMonthDay) {
                        MyConfig.uiToast("You pick "+yearMonthDay.year+"-"+yearMonthDay.month+"-"+yearMonthDay.day);
                    }
                })
                        .setPromptText("请选择日期")
                        .setPromptSize(18)
                        .setPromptColor(Color.RED)
                        .setPromptBgColor(Color.YELLOW)

                        .setSelectedText("已选")
                        .setSelectedSize(12)
                        .setSelectedColor(0xFF330DCE)
                        .setSelectedBgColor(0xFFD0CE33)

                        .setTodayText("今天")
                        .setTodaySize(16)
                        .setTodayColor(Color.RED)
                        .setTodayBgColor(Color.GREEN)

                        .setMonthTitle(new Builder.FormatMonthTitle() {
                            @Override
                            public String setMonthTitle(int year, int month) {
                                return ""+year+"年"+month+"月";
                            }
                        })
                        .setMonthTitleSize(16)
                        .setMonthTitleColor(Color.BLUE)
                        .setMonthTitleBgColor(Color.CYAN)

                        .setWeekIndex(new String[]{"一", "二", "三", "四", "五", "六", "日"})
                        .setWeekIndexSize(16)
                        .setWeekIndexColor(Color.LTGRAY)
                        .setWeekIndexBgColor(0xFF236587)
                        
                        .setCancelText("取消")
                        .setCancelSize(12)
                        .setCancelColor(Color.LTGRAY)
                        .setCancelBgColor(0xFFA079BE)

                        .setConfirmText("确定")
                        .setConfirmSize(16)
                        .setConfirmColor(Color.RED)
                        .setConfirmBgColor(Color.GREEN)

                        .setPreset(new YearMonthDay(2017, 11, 4))
                        .setDaySize(16)
                        .setDayColor(Color.BLUE)
                        .setDayOtherMonthColor(0xFF87CEFA)
                        .setMonthBaseBgColor(0xFFE0FFFF)

//                        .restoreDefault()
                        ;

                builder.show();

            }
        });

    }
}
