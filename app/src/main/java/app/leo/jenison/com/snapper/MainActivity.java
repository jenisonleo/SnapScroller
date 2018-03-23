package app.leo.jenison.com.snapper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RecyclerView recyclerView=findViewById(R.id.recycerlview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecycerlAdapter());
        SnapHelper snapHelper=new CustomLinearHelper();
        snapHelper.attachToRecyclerView(recyclerView);
        findViewById(R.id.up).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.smoothScrollToPosition(((LinearLayoutManager)recyclerView.getLayoutManager()).findFirstVisibleItemPosition()+10);
            }
        });
        findViewById(R.id.down).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.smoothScrollToPosition(((LinearLayoutManager)recyclerView.getLayoutManager()).findFirstVisibleItemPosition()-10);
            }
        });
    }
}
