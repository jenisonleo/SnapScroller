package app.leo.jenison.com.snapper;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.Random;

/**
 * Created by jenison-3631 on 22/03/18.
 */

public class RecycerlAdapter extends RecyclerView.Adapter<Holder> {
    private Random random=new Random();
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        ImageView frameLayout=new ImageView(parent.getContext());
        frameLayout.setImageDrawable(parent.getContext().getResources().getDrawable(R.drawable.slide));
        ViewGroup.LayoutParams params=new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 700);
        frameLayout.setLayoutParams(params);
        return new Holder(frameLayout);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.itemView.setBackgroundColor(Color.argb(random.nextInt(255),random.nextInt(255),random.nextInt(255),random.nextInt(255)));
    }

    @Override
    public int getItemCount() {
        return 500;
    }
}
