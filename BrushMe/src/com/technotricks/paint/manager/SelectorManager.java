package com.technotricks.paint.manager;



import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;

// TODO: Auto-generated Javadoc
/**
 * The Class SelectorManager.
 */
public class SelectorManager {

	
	public static Drawable getButtonDrawableByScreenCathegory(Context con,
			int normalStateResID, int pressedStateResID) {

		Drawable state_normal = con.getResources()
				.getDrawable(normalStateResID).mutate();

		Drawable state_pressed = con.getResources()
				.getDrawable(pressedStateResID).mutate();

		
		StateListDrawable drawable = new StateListDrawable();

		drawable.addState(new int[] { android.R.attr.state_pressed },
				state_pressed);
		drawable.addState(new int[] { android.R.attr.state_enabled },
				state_normal);

		return drawable;
	}
	
	@SuppressLint("NewApi")
	public static void setBackground(View v,Drawable d){
		int sdk = android.os.Build.VERSION.SDK_INT;
		if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
		    v.setBackgroundDrawable(d);
				
		} else {
		    v.setBackground(d);
		}
	}
	
	
	
	public static ColorStateList getTextColor(int normalStateResID, int pressedStateResID){
		
		
		ColorStateList colorStateList = new ColorStateList(
	            new int[][]{
	                    new int[]{android.R.attr.state_pressed},
	                    new int[]{-android.R.attr.state_enabled},
	            },
	            new int[]{pressedStateResID,normalStateResID});
		
		
		
		return colorStateList;
		
	}
	
	
	
	public static Drawable getToggleButtonSelection(Context con,
			int on, int off) {

		Drawable onDrawable = con.getResources()
				.getDrawable(on).mutate();

		Drawable offDrawable = con.getResources()
				.getDrawable(off).mutate();

		StateListDrawable drawable = new StateListDrawable();

		drawable.addState(new int[] { android.R.attr.state_checked },
				onDrawable);
		drawable.addState(new int[] { android.R.attr.state_enabled },
				offDrawable);

		return drawable;
	}
	
	
	
	
}