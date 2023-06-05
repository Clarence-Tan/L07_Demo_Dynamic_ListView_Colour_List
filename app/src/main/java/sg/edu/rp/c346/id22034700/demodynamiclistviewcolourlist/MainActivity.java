package sg.edu.rp.c346.id22034700.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etElement;
    EditText etIndex;
    Button btnAdd;
    Button btnRemove;
    Button btnUpdate;
    ListView lvColour;
    ArrayList<String> alColours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        etIndex = findViewById(R.id.editTextIndex);
        btnAdd = findViewById(R.id.buttonAddItem);
        btnRemove = findViewById(R.id.buttonRemoveItem);
        btnUpdate = findViewById(R.id.buttonUpdateColour);
        lvColour = findViewById(R.id.listViewColour);

        alColours = new ArrayList<String>();
        alColours.add("Red");
        alColours.add("Orange");

        ArrayAdapter aaColours = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alColours);
        lvColour.setAdapter(aaColours);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userColour = etElement.getText().toString();
                //alColours.add(userColour);
                int pos = Integer.parseInt(etIndex.getText().toString());
                alColours.add(pos, userColour);
                aaColours.notifyDataSetChanged();
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = Integer.parseInt(etIndex.getText().toString());
                alColours.remove(pos);
                aaColours.notifyDataSetChanged();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userColour = etElement.getText().toString();
                int pos = Integer.parseInt(etIndex.getText().toString());
                alColours.set(pos, userColour);
                aaColours.notifyDataSetChanged();
            }
        });

        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int colour = lvColour.getPositionForView(view);
                Toast.makeText(MainActivity.this, alColours.get(colour), Toast.LENGTH_SHORT).show();
            }
        });
    }
}