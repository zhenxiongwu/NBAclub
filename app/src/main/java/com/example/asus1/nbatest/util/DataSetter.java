package com.example.asus1.nbatest.util;


import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yubin on 2017/5/7.
 */

public class DataSetter {

    private static String type;

    public static void setType(String type) {
        DataSetter.type = type;
    }

    //设置柱状图数据
    public static void setBarData(Chart chart,
                                  List<String> xValuesList,
                                  List<Float> yValuesList) {
        List<BarEntry> yVals1 = new ArrayList<>();

        for (int i = 0; i < xValuesList.size(); i++) {
            float val = yValuesList.get(i);
            yVals1.add(new BarEntry(i, val));
        }

        BarDataSet set1;
        if (chart.getData() != null &&
                chart.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet) chart.getData().getDataSetByIndex(0);
            set1.setValues(yVals1);
            set1.setLabel(type);
            set1.setColor(0xffffffff);
            set1.setValueTextColor(0xffffffff);
            set1.setVisible(true);
            chart.getData().notifyDataChanged();
            chart.notifyDataSetChanged();
        } else {
            set1 = new BarDataSet(yVals1, type);
            set1.setColor(0xffffffff);
            set1.setValueTextColor(0xffffffff);
            ArrayList<IBarDataSet> dataSets = new ArrayList<>();
            dataSets.add(set1);
            BarData data = new BarData(dataSets);
            data.setValueTextSize(15f);
            chart.setData(data);
        }
    }

    //设置折线图数据
    public static void setLineData(Chart chart,
                                   List<String> seasons,
                                   List<Float> playerDatas) {
        List<Entry> yVals1 = new ArrayList<>();

        for (int i = 0; i < seasons.size(); i++) {
            float val = playerDatas.get(i);
            yVals1.add(new Entry(i, val));
        }

        LineDataSet set1;
        if (chart.getData() != null &&
                chart.getData().getDataSetCount() > 0) {
            set1 = (LineDataSet) chart.getData().getDataSetByIndex(0);
            set1.setValues(yVals1);
            set1.setLabel(type);
            set1.setColor(0xffffffff);
            set1.setValueTextColor(0xffffffff);
            chart.getData().notifyDataChanged();
            chart.notifyDataSetChanged();
        } else {
            set1 = new LineDataSet(yVals1, type);
            set1.setColor(0xffffffff);
            set1.setValueTextColor(0xffffffff);
            set1.setLineWidth(3f);
            ArrayList<ILineDataSet> dataSets = new ArrayList<>();
            dataSets.add(set1);
            LineData data = new LineData(dataSets);
            data.setValueTextSize(15f);
            chart.setData(data);
        }
    }
}
