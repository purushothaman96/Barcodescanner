package puru.com.barcodescanner;

import android.app.ActionBar;
import android.os.Bundle;
import com.google.zxing.integration.android.Intentintegrator;
import com.google.zxing.integration.android.Intentresult;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class addDataActivity extends ActionBarActivity{
    databasehelper mydb;
    EditText editId,editName,editSem,editMarks;
    Button btnAddData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_add_data);
        mydb= new databasehelper(this);
        editId=(EditText)findViewById(R.id.editText_ID);
        editName=(EditText)findViewById(R.id.editText2_NAME);
        editSem=(EditText)findViewById(R.id.editText3_SEM);
        editMarks=(EditText)findViewById(R.id.editText4_marks);
        btnAddData=(Button)findViewById(R.id.button_add);
        AddData();
    }
    public void AddData()
    {
        btnAddData.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view) {
                        boolean isInserted= mydb.insertData(editId.getText().toString(),
                                editName.getText().toString(),
                                editSem.getText().toString(),
                                editMarks.getText().toString());
                        if(isInserted=true)
                            Toast.makeText(addDataActivity.this,"data inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(addDataActivity.this,"data not inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

}
