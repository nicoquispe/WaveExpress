package pe.edu.utp.waveexpress.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import pe.edu.utp.waveexpress.R;
import pe.edu.utp.waveexpress.WaveExpressApplication;
import pe.edu.utp.waveexpress.models.Category;

public class AddExpenseActivity extends AppCompatActivity {

    private EditText descriptionEditText;
    private EditText valueEditText;
    private Spinner categorySpinner;
    private DatePicker dateDatePicker;
    private ArrayAdapter<Category> categoriesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        descriptionEditText = (EditText) findViewById(R.id.descriptionEditText);
        valueEditText = (EditText) findViewById(R.id.valueEditText);
        categorySpinner = (Spinner) findViewById(R.id.categorySpinner);
        dateDatePicker = ( DatePicker  ) findViewById(R.id.dateDatePicker);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);


        List<Category> categories = Category.listAll(Category.class);
        categoriesAdapter = new ArrayAdapter<Category>( this ,android.R.layout.simple_spinner_item, categories);

        categoriesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter( categoriesAdapter  );

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Category category = Category.findById( Category.class, categorySpinner.getSelectedItemId() );
                int day = dateDatePicker.getDayOfMonth();
                int month = dateDatePicker.getMonth();
                int year =  dateDatePicker.getYear();
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, day);


                ((WaveExpressApplication) getApplication())
                        .getWaveService()
                        .addExpense(
                                descriptionEditText.getText().toString(),
                                Double.valueOf( valueEditText.getText().toString() ),
                                category,
                                "",
                                calendar.getTime()
                        );
                finish();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
