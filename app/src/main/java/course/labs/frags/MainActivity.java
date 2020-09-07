package course.labs.frags;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListFrag.ItemSelected {
    TextView tvDesc;
    String [] descriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDesc =findViewById(R.id.tvDesc);

        descriptions = getResources().getStringArray(R.array.descriptions);

        if(findViewById(R.id.layout_portrait)!= null)
        {
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction().hide(manager.findFragmentById(R.id.detailfrag)).show(manager.findFragmentById(R.id.listfrag)).commit();
        }
        if(findViewById(R.id.layout_land)!= null)
        {
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction().show(manager.findFragmentById(R.id.detailfrag)).show(manager.findFragmentById(R.id.listfrag)).commit();
        }
    }

    @Override
    public void onItemSelected(int index) {
        tvDesc.setText(descriptions[index]);

        if (findViewById(R.id.layout_portrait) != null)
        {
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction().show(manager.findFragmentById(R.id.detailfrag)).hide(manager.findFragmentById(R.id.listfrag)).addToBackStack(null).commit();
        }
    }
}