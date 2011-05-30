package jp.ccube.calculator;

import java.util.ArrayList;
import jp.ccube.calculator.operator.AbstractOperator;
import jp.ccube.calculator.operator.EInvalidOperator;
import jp.ccube.calculator.operator.OperatorFactory;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Calculator extends Activity {
	
	private NumberGenerator generator;
	private ICalculator calculator;
	private ListAdapter adapter;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);

        this.calculator = new SimpleCalculator();
        
        ArrayList<CalcResult> data = new ArrayList<CalcResult>();
        this.adapter = new ArrayAdapter<CalcResult>(this, R.layout.item, data);
        
        this.generator = new NumberGenerator();
        this.showValue();

        ((Button)findViewById(R.id.Button0)).setOnClickListener(values);
        ((Button)findViewById(R.id.Button1)).setOnClickListener(values);
        ((Button)findViewById(R.id.Button2)).setOnClickListener(values);
        ((Button)findViewById(R.id.Button3)).setOnClickListener(values);
        ((Button)findViewById(R.id.Button4)).setOnClickListener(values);
        ((Button)findViewById(R.id.Button5)).setOnClickListener(values);
        ((Button)findViewById(R.id.Button6)).setOnClickListener(values);
        ((Button)findViewById(R.id.Button7)).setOnClickListener(values);
        ((Button)findViewById(R.id.Button8)).setOnClickListener(values);
        ((Button)findViewById(R.id.Button9)).setOnClickListener(values);
        ((Button)findViewById(R.id.ButtonCm)).setOnClickListener(values);

        ((Button)findViewById(R.id.ButtonPl)).setOnClickListener(operators);
        ((Button)findViewById(R.id.ButtonMn)).setOnClickListener(operators);
        ((Button)findViewById(R.id.ButtonTm)).setOnClickListener(operators);
        ((Button)findViewById(R.id.ButtonDv)).setOnClickListener(operators);

        ((Button)findViewById(R.id.ButtonEq)).setOnClickListener(equal);
        
        ((ListView)findViewById(R.id.ListResults)).setAdapter(adapter);
        
    }
    
    private void showValue() {
        TextView text = (TextView)findViewById(R.id.TextAnswer);
    	text.setText(this.generator.getValue());
    }
    
	private void addResult(CalcResult result) {
		@SuppressWarnings("unchecked")
		ArrayAdapter<CalcResult> data = (ArrayAdapter<CalcResult>)this.adapter;
		data.add(result);
		
        TextView text = (TextView)findViewById(R.id.TextAnswer);
    	text.setText(Long.toString(result.getAnswer()));
    }
    
    OnClickListener values = new OnClickListener() {
		public void onClick(View v) {
			char digit = ((Button)v).getText().charAt(0);
			generator.addValue(digit);
	        showValue();
		}
	};

    OnClickListener operators = new OnClickListener() {
		public void onClick(View v) {
			calculator.clearOperator();

			String opeString = ((Button)v).getText().toString();
			try {
				AbstractOperator operator = OperatorFactory.create(opeString);
				calculator.setValue(Long.parseLong(generator.getValue()));
				calculator.setOperator(operator);
				
				generator.clear();
			} catch (EInvalidOperator e) {
				e.printStackTrace();
			}
		}
	};

    OnClickListener equal = new OnClickListener() {
		public void onClick(View v) {
			calculator.setValue(Long.parseLong(generator.getValue()));
			generator.clear();

			CalcResult result = new CalcResult(calculator.getFormula(), calculator.getAnswer());
			addResult(result);
		}
	};
}