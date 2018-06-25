package com.appdev.prashantgoyal.krmustudent;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.hookedonplay.decoviewlib.DecoView;
import com.hookedonplay.decoviewlib.charts.SeriesItem;
import com.hookedonplay.decoviewlib.charts.SeriesLabel;
import com.txusballesteros.widgets.FitChart;

public class Dashboard extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Toolbar toolbar = findViewById(R.id.dashboard_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);

        drawerLayout = findViewById(R.id.dashboard_drawer_layout);

        DecoView GPAdecoView = findViewById(R.id.dv_login_CGPA);

        SeriesItem seriesItem = new SeriesItem.Builder(Color.parseColor("#A3A1FB"))
                .setRange(0, 10, 8)
                .setSeriesLabel(new SeriesLabel.Builder("Percent %.0f%%").build())
                .build();

        int backIndex = GPAdecoView.addSeries(seriesItem);

        FitChart fitChart = findViewById(R.id.fc_dashboard_attendance);
        fitChart.setMinValue(0f);
        fitChart.setMaxValue(100f);
        fitChart.setValue(85f);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
