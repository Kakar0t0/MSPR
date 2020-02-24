package fr.epsi.myapplication;

import android.os.Bundle;
import com.google.zxing.Result;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ListActivity extends MainActivity implements ZXingScannerView.ResultHandler{

    ZXingScannerView scannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        scannerView = new ZXingScannerView(this);
        setContentView(scannerView);
    }

    @Override
    public void handleResult(Result result){
        MainActivity.textView.setText(result.getText());
        onBackPressed();
    }

    @Override
    protected void onResume(){
        super.onResume();
        scannerView.setResultHandler(this);
        scannerView.startCamera();
    }

    @Override
    protected void onPause(){
        super.onPause();
        scannerView.stopCamera();
    }

}
