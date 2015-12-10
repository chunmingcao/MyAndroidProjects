package com.caocm.android.quiz;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class MainActivity extends Activity {

    private Question q;
    private int selectedAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        q = Question.getNextQuestion();

        TextView questionText = (TextView)findViewById(R.id.qustiontext);
        questionText.setText(q.getText());

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, q.getOptions());
        ListView listView = (ListView)findViewById(R.id.options);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                view.setBackgroundColor(Color.GREEN);
                selectedAnswer = position;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void nextQuestion(View view){
        q = Question.getNextQuestion();

        TextView questionText = (TextView)findViewById(R.id.qustiontext);
        questionText.setText(q.getText());

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, q.getOptions());
        ListView listView = (ListView)findViewById(R.id.options);
        listView.setAdapter(adapter);
    }
    public void preQuestion(View view){
        q = Question.getPreQuestion();

        TextView questionText = (TextView)findViewById(R.id.qustiontext);
        questionText.setText(q.getText());

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, q.getOptions());
        ListView listView = (ListView)findViewById(R.id.options);
        listView.setAdapter(adapter);
    }
    public void submitAnswer(View view){
        if(selectedAnswer == q.getAnswer()){
            Toast.makeText(this, "Good!!!!", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this, "XXXXX", Toast.LENGTH_LONG).show();
        }

    }
}
