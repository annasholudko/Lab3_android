package com.example.lab3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.CheckBox;
import android.view.View;
import android.content.SharedPreferences;
import android.widget.TextView;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.String;
public class MainActivity extends AppCompatActivity {
    //private Reader reader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //reader=new Reader();
    }
    private final static String FILE_NAME = "file.txt";

    public void saveText(View view){

        FileOutputStream f = null;
        try {
			CheckBox ch1 = (CheckBox) findViewById(R.id.checkBox10);
        CheckBox ch2 = (CheckBox) findViewById(R.id.checkBox11);
        CheckBox ch3 = (CheckBox) findViewById(R.id.checkBox12);
        CheckBox ch4 = (CheckBox) findViewById(R.id.checkBox13);
        String selectedItems = "";
        if(ch1.isChecked())
            selectedItems +=ch1.getText() + "\n";
        if(ch2.isChecked())
            selectedItems +=ch2.getText()+"\n";
        if(ch3.isChecked())
            selectedItems +=ch3.getText()+"\n";
        if(ch4.isChecked())
            selectedItems +=ch4.getText();
		
            f = openFileOutput(FILE_NAME, MODE_PRIVATE);
            f.write(selectedItems.getBytes());
            Toast.makeText(this, "Файл збережений", Toast.LENGTH_SHORT).show();
        }
        catch(IOException ex) {

            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        finally{
            try{
                if(f!=null)
                    f.close();
            }
            catch(IOException ex){

                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    //public void writeText(View view){
       // TextView textView = (TextView) view.findViewById(R.id.textView4);
       // String text=reader.Read(view);
      //  textView.setText(text);
    //}

    public void ReadFile(View view) {

        FileInputStream f = null;
        TextView textView = (TextView) findViewById(R.id.textView4);
        try {
            f = openFileInput(FILE_NAME);
            byte[] bytes = new byte[f.available()];
            f.read(bytes);
            String text = new String(bytes);
            if(text.equals("")) Toast.makeText(this, "Файл порожній", Toast.LENGTH_SHORT).show();
            textView.setText(text);
        } catch (IOException ex) {

            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        } finally {

            try {
                if (f != null)
                    f.close();
            } catch (IOException ex) {

                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

}
