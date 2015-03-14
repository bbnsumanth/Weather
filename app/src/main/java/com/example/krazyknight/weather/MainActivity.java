package com.example.krazyknight.weather;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {
    ListView listView1;
    String[] weather = {"Rainy","Sunny","Drizzle","Fog","Downpour","Windy","Cloudy","Partly Cloudy","Sunny",
            "Drizzle","Fog","Downpour","Downpour","Windy","Cloudy","Partly Cloudy","Windy","Downpour","Windy","Cloudy","Partly Cloudy"};
    int[] images = {R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6, R.drawable.img7,R.drawable.img8};
    MyAdapter adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView1 = (ListView) findViewById(R.id.listView1);
        adapter = new MyAdapter(this,weather,images);
        listView1.setAdapter(adapter);
        listView1.setOnItemClickListener(this);

    }
    public class MyAdapter extends ArrayAdapter<String> {
        int[] images;
        String[] weather;
        public MyAdapter(Context c,String[] weather,int[]images){
            super(c,R.layout.single_row,R.id.textView1,weather);
            this.images = images;
            this.weather = weather;
        }
        public View getView(int position,View convertView,ViewGroup parent){

            LayoutInflater inflater = getLayoutInflater();
            View v = inflater.inflate(R.layout.single_row,listView1,false);

            TextView t1 = (TextView) v.findViewById(R.id.textView1);
            TextView t2 = (TextView) v.findViewById(R.id.textView2);
            ImageView v1 = (ImageView) v.findViewById(R.id.imageView1);
            t1.setText(weather[position]);
            t2.setText(weather[position]);

            switch(weather[position].toLowerCase()){
                case "sunny":v1.setImageResource(images[0]);break;
                case "rainy":v1.setImageResource(images[4]);break;
                case "fog":v1.setImageResource(images[3]);break;
                case "drizzle":v1.setImageResource(images[7]);break;
                case "downpour":v1.setImageResource(images[6]);break;
                case "windy":v1.setImageResource(images[5]);break;
                case "cloudy":v1.setImageResource(images[1]);break;
                case "partly cloudy":v1.setImageResource(images[2]);break;
                default:v1.setImageResource(images[1]);break;
            }

            return v;
        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
        TextView t = (TextView) view.findViewById(R.id.textView2);
        String text =(String) t.getText();
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();//this makeText is a static method
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
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
