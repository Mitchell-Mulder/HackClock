package projecttadhisto.qtma.com.hackclock;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TimePicker;

public class AddAlarmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_alarm);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Adds back arrow button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // When toolbar back button is pressed
            case android.R.id.home:
                finish();
                break;
        }

        return true;    // true means you always handled the menu selection
    } // end onOptionsItemsSelected method

    @Override
    // When phone back button is pressed, go to parent activity.
    public void onBackPressed() {
        finish();
    } // end onBackPressed method

    public void onSetAlarmClick(View v) {
        // get time value
        TimePicker picker = (TimePicker) findViewById(R.id.timePicker);
        int hour = picker.getHour();
        int min = picker.getMinute();
        String time;
        if (min < 10) {
            time = String.valueOf(hour) + ":0" + String.valueOf(min);
        } else {
            time = String.valueOf(hour) + ":" + String.valueOf(min);
        }

        //create intent to pass alarm value back and finish activity
        Intent setAlarm = new Intent(this, HomeActivity.class);
        setAlarm.putExtra("setAlarm", time);
        setAlarm.putExtra("hour", hour);
        setAlarm.putExtra("minute", min);
        setResult(RESULT_OK, setAlarm);
        finish();
    }

}
