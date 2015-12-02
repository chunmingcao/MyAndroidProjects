package com.caocm.android.lesson4;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class MainActivity extends Activity {

    private float left = 0.0f;
    private Canvas c;
    private Paint myPaint;
    private Bitmap b;
    private ImageView animatorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Create outer layout
        LinearLayout outerLayout = new LinearLayout(this);
        outerLayout.setOrientation(LinearLayout.VERTICAL);
        WindowManager.LayoutParams outerLayoutParams =
                new WindowManager.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        outerLayout.setLayoutParams(outerLayoutParams);


        //Create an ImageView to display the circle graphic on the screen
        animatorView = new ImageView(this);
        drawRect();

        //Add the ImageView to the outer layout
        outerLayout.addView(animatorView);

        // Create the inner layout
        LinearLayout innerLayout = new LinearLayout(this);
        innerLayout.setOrientation(LinearLayout.HORIZONTAL);
        innerLayout.setGravity(Gravity.CENTER_HORIZONTAL);
        WindowManager.LayoutParams innerLayoutParams =
                new WindowManager.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        innerLayout.setLayoutParams(innerLayoutParams);

        // Create the buttons and register them with OnClickListeners
        Button lButton = new Button(this);
        lButton.setText("<");
        lButton.setOnClickListener(moveleftListener);
        Button rButton = new Button(this);
        rButton.setText(">");
        rButton.setOnClickListener(moverightListener);

        // Add the buttons to the inner layout
        innerLayout.addView(lButton);
        innerLayout.addView(rButton);

        // Add the inner layout to the outer layout
        outerLayout.addView(innerLayout);

        setContentView(outerLayout);
    }

    private View.OnClickListener moveleftListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            move(-10.0f);
        }
    };

    private View.OnClickListener moverightListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            move(10.0f);
        }
    };
    private void move(float adjustment)
    {
        left += adjustment;
        if (left < 0.0f) left = 0.0f;
        if (left > 400.0f) left = 200.0f;
        drawRect();
    }
    private void drawRect(){
        Bitmap b = Bitmap.createBitmap(400, 400, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(b);
        myPaint = new Paint();
        myPaint.setColor(Color.RED);
        c.drawRect(left, 200, 200, 400, myPaint);
        animatorView.setImageBitmap(b);
        animatorView.invalidate();
    }
}
