package com.github.xch168.stroketextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by XuCanHui on 2017/7/26.
 */

public class StrokeTextView extends TextView {

    private TextView mOutTextView;

    private int mStrokeColor = Color.BLUE;
    private float mStrokeWidth = 5F;

    public StrokeTextView(Context context) {
        super(context);
        mOutTextView = new TextView(context);
        init(context, null);
    }

    public StrokeTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mOutTextView = new TextView(context, attrs);
        init(context, attrs);
    }

    public StrokeTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mOutTextView = new TextView(context, attrs, defStyleAttr);
        init(context, attrs);
    }


    private void init(Context context, AttributeSet attrs) {
        initAttribute(context, attrs);

        TextPaint paint = mOutTextView.getPaint();
        paint.setStrokeWidth(mStrokeWidth);
        paint.setStyle(Paint.Style.STROKE);

        mOutTextView.setTextColor(mStrokeColor);
        mOutTextView.setGravity(getGravity());
    }

    private void initAttribute(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.StrokeTextView);
            mStrokeColor = typedArray.getColor(R.styleable.StrokeTextView_stroke_color, Color.BLUE);
            mStrokeWidth = typedArray.getDimension(R.styleable.StrokeTextView_stroke_width, 5F);
            typedArray.recycle();
        }
    }

    public void setStrokeColor(int colorId) {
        if (mOutTextView != null) {
            mOutTextView.setTextColor(getResources().getColor(colorId));
            postInvalidate();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        CharSequence content = mOutTextView.getText();
        if ((content == null) || (!content.equals(getText()))) {
            mOutTextView.setText(getText());
            postInvalidate();
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (mOutTextView != null) {
            mOutTextView.measure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        mOutTextView.layout(left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mOutTextView.draw(canvas);
        super.onDraw(canvas);
    }

    @Override
    public void setGravity(int gravity) {
        super.setGravity(gravity);
        if (mOutTextView != null) {
            mOutTextView.setGravity(gravity);
        }
    }

    @Override
    public void setLayoutParams(ViewGroup.LayoutParams params) {
        super.setLayoutParams(params);
        if (mOutTextView != null) {
            mOutTextView.setLayoutParams(params);
        }
    }

    @Override
    public void setMinimumWidth(int minWidth) {
        super.setMinimumWidth(minWidth);
        if (mOutTextView != null) {
            mOutTextView.setMinWidth(minWidth);
        }
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        super.setText(text, type);
        if (mOutTextView != null) {
            mOutTextView.setText(text);
        }
    }

    @Override
    public void setTextSize(float size) {
        super.setTextSize(size);
        if (mOutTextView != null) {
            mOutTextView.setTextSize(size);
        }
    }

    @Override
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        if (mOutTextView != null) {
            mOutTextView.setVisibility(visibility);
        }
    }
}
