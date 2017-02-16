package puru.com.barcodescanner;

import android.os.Bundle;
import com.google.zxing.integration.android.Intentintegrator;
import com.google.zxing.integration.android.Intentresult;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BarcodeActivity extends Activity implements OnClickListener{

    private Button scanBtn,Nextbtn;
    private TextView formatTxt, contentTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode);
        scanBtn = (Button) findViewById(R.id.scan_button);
        formatTxt = (TextView) findViewById(R.id.scan_format);
        contentTxt = (TextView) findViewById(R.id.scan_content);
        Nextbtn=(Button) findViewById(R.id.Next_Button);
        scanBtn.setOnClickListener(this);
    }



    public void onClick(View v){

        if(v.getId()==R.id.scan_button){
            Intentintegrator scanIntegrator = new Intentintegrator(this);

            scanIntegrator.initiateScan();
        }
    }
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {

        Intentresult scanningResult = Intentintegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanningResult != null)
        {
            String scanContent = scanningResult.getContents();
            String scanFormat = scanningResult.getFormatName();
            formatTxt.setText("FORMAT: " + scanFormat);
            contentTxt.setText("CONTENT: " + scanContent);


        }
        else{
            Toast toast = Toast.makeText(getApplicationContext(),
                    "No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void movenext(View view)
    {

        Intent startNEWactivity=new Intent(this,addDataActivity.class);
        startActivity(startNEWactivity);
    }

}
