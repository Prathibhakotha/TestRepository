package com.example.prathibha.testproject.customViews;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class LatoTextView extends AppCompatTextView
{
	public LatoTextView(Context context)
	{
		super(context);
	}
	
	public LatoTextView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
	}
	
	public LatoTextView(Context context, AttributeSet attrs, int defStyleAttr)
	{
		super(context, attrs, defStyleAttr);
	}
	
	@Override
	public void setTypeface(Typeface tf, int style)
	{
		if(style == Typeface.BOLD)
		{
			super.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "lato-bold.ttf"));
		}
		else
		{
			super.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "lato-regular.ttf"));
		}
	}
	
}
