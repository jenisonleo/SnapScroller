package app.leo.jenison.com.snapper;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

/**
 * Created by jenison-3631 on 22/03/18.
 */

public class CustomLinearHelper extends LinearSnapHelper{

    @Nullable
    private RecyclerView recyclerView;

    public CustomLinearHelper() {
        super();
    }

    @Override
    public boolean onFling(int velocityX, int velocityY) {
        boolean b = super.onFling(velocityX, velocityY);
        Log.e("on fling "," "+velocityX+" "+velocityY+ " "+b);
        return b;
    }

    @Override
    public void attachToRecyclerView(@Nullable RecyclerView recyclerView) throws IllegalStateException {
        this.recyclerView = recyclerView;
        Log.e("attachToRecyclerView "," ");
        super.attachToRecyclerView(recyclerView);
    }

    @Override
    public int[] calculateScrollDistance(int velocityX, int velocityY) {
        int[] ints = super.calculateScrollDistance(velocityX, velocityY);
        Log.e("calculateScrollDistance "," "+velocityX+" "+velocityY+" "+ints[0]+" "+ints[1]);
        return ints;
    }

    @Nullable
    @Override
    protected RecyclerView.SmoothScroller createScroller(RecyclerView.LayoutManager layoutManager) {
        Log.e("createScroller "," ");
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider)) {
            return null;
        }
        return new LinearSmoothScroller(recyclerView.getContext()) {
            @Override
            protected void onTargetFound(View targetView, RecyclerView.State state, Action action) {
                int[] snapDistances = calculateDistanceToFinalSnap(recyclerView.getLayoutManager(),
                        targetView);
                final int dx = snapDistances[0];
                final int dy = snapDistances[1];
                final int time = calculateTimeForDeceleration(Math.max(Math.abs(dx), Math.abs(dy)));
                if (time > 0) {
                    action.update(dx, dy, time, mDecelerateInterpolator);
                }
            }

            @Override
            protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return 25f / displayMetrics.densityDpi;
            }
        };
//        return super.createScroller(layoutManager);
    }

    @Override
    public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View targetView) {
        int[] ints = super.calculateDistanceToFinalSnap(layoutManager, targetView);
        Log.e("calculateDistanceToFinalSnap "," "+ints[0]+" "+ints[1]);
        return ints;
    }

    @Override
    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int velocityX, int velocityY) {
        int targetSnapPosition = super.findTargetSnapPosition(layoutManager, velocityX, velocityY);
        Log.e("findTargetSnapPosition "," "+velocityX+" "+velocityY+" "+targetSnapPosition);
        return targetSnapPosition;
    }

    @Override
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        Log.e("findSnapView"," ");
        return super.findSnapView(layoutManager);
    }
}
