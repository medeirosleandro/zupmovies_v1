package br.leandro.com.adicionareremoverdalista;

import android.icu.text.StringSearch;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private EditText itemMovie;
    private Button btn;
    private ListView itemList;

    private ArrayList<String> fav_movies;
    private ArrayAdapter<String>adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemMovie = findViewById(R.id.item_edit_text);
        btn = findViewById(R.id.add_button);
        itemList = findViewById(R.id.item_list);

        fav_movies = FileHelper.readData(this);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,fav_movies);
        itemList.setAdapter(adapter);

        btn.setOnClickListener(this);
        itemList.setOnItemClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_button:
                String movieInsert = itemMovie.getText().toString();
                adapter.add(movieInsert);
                itemMovie.setText("");

                FileHelper.writeData(fav_movies, this);

                Toast.makeText(this, "Filme Adicionado", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        fav_movies.remove(position);
        adapter.notifyDataSetChanged();
        Toast.makeText(this, "Filme Removido!", Toast.LENGTH_SHORT).show();
    }
}
