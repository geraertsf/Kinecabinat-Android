package be.geraerts.customview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;
import be.geraerts.R;

/**
 * @author François Geraerts
 *         <p/>
 *         Date: 31/05/12
 *         Time: 22:32
 */
public class KinecabinatListItemView extends TextView {

    private Paint marginPaint;
    //private Paint linePaint;
    private int paperColor;
    private float margin;


    public KinecabinatListItemView(Context context) {
        super(context);
        init();
    }

    public KinecabinatListItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public KinecabinatListItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        // Get a reference to our resource table.
        Resources myResources = getResources();

        // Create the paint brushes we will use in the onDraw method.
        marginPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        marginPaint.setColor(myResources.getColor(R.color.list_element_margin));
//        linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
//        linePaint.setColor(myResources.getColor(R.color.list_element_lines));

        // Get the paper background color and the margin width.
        paperColor = myResources.getColor(R.color.list_element_paper);
        margin = myResources.getDimension(R.dimen.list_element_margin);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // Color as paper
        canvas.drawColor(paperColor);

        // Draw ruled lines
//        canvas.drawLine(0, 0, 0, getMeasuredHeight(), linePaint);
//        canvas.drawLine(0, getMeasuredHeight(),
//                getMeasuredWidth(), getMeasuredHeight(),
//                linePaint);

        // Draw margin
        canvas.drawLine(margin, 0, margin, getMeasuredHeight(), marginPaint);

        // Move the text across from the margin
        canvas.save();
        canvas.translate(margin, 0);

        // Use the TextView to render the text
        super.onDraw(canvas);
        canvas.restore();
    }
}
