package edu.berkeley.cs160.jonathanmanalus.proj1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends Activity {
	//Given functions
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	//function is called when radiobutton + convert are selected
	public void getData(View v) 
		{
		EditText userInput = (EditText)findViewById(R.id.userInput);
		double input = Double.valueOf(userInput.getText().toString());
		
		//Connects Radio Buttons from activity_main.xml
		RadioGroup rGroup = (RadioGroup)findViewById(R.id.radioGroup);
		int currentUnit = rGroup.getCheckedRadioButtonId();
		
		//Sends the the conversion and new dataType back to the main.xml
		String newUnit = unitsDisplayed(currentUnit);
		TextView newValue = (TextView)findViewById(R.id.outputValue);
		TextView outUnit = (TextView)findViewById(R.id.outputUnit);
		newValue.setText(unitsConverts(input, currentUnit));
		outUnit.setText(newUnit);
	}
	
    
    //Converts user input into the new unit type
    //Conversion formulas supplied by http://www.metric-conversions.org/
    public String unitsConverts(double math, int input){
    	double convertedUnit = 0.0;
    	if (input == R.id.milesToKm)
    	{
    		convertedUnit = math/0.62137;
    	} 
    	else if (input == R.id.kmToMiles)
    	{
    		convertedUnit = math*0.62137;
    	}
    	else if (input == R.id.lbsToGrams)
    	{
    		convertedUnit = math/0.0022046;
    	} 
    	else if (input == R.id.gramsToLbs)
    	{
    		convertedUnit = math*0.0022046;
    	} 
    	else if (input == R.id.fToC)
    	{
    		convertedUnit = (math-32)/1.8;
    	} 
    	else if (input == R.id.cToF)
    	{
    		convertedUnit = (math*1.8) + 32;
    	}
    	return "" + convertedUnit;
    }
    
	//Checks which radioButton unit is selected 
    public String unitsDisplayed(int n){
    	String unitType = "";
    	switch (n) {
    		case R.id.milesToKm:
    			unitType = "km";
    				break;
    		case R.id.kmToMiles: 
    			unitType = "miles";
    				break;
    		case R.id.lbsToGrams: 
    			unitType = "grams";
    			break;
    		case R.id.gramsToLbs: 
    			unitType = "lbs.";
    				break;
    		case R.id.fToC: 
    			unitType = "Celsius";
    				break;
    		case R.id.cToF: 
    			unitType = "Fahrenheit";
    			break;
    	}
    		return unitType;
    }
    
}