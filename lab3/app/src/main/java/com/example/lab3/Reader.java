package com.example.lab3;
import android.widget.Toast;
import android.view.View;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.String;

public class Reader {
    private final static String FILE_NAME = "file.txt";
    public String Read(View view)
    {
        FileInputStream fin = null;
        String text;
        //TextView textView = (TextView) view.getContext().findViewById(R.id.textView4);
        try {
            fin = view.getContext().openFileInput(FILE_NAME);
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            text = new String(bytes);
            if(text.equals("")) Toast.makeText(view.getContext(), "Файл порожній", Toast.LENGTH_SHORT).show();
        } catch (IOException ex) {

            Toast.makeText(view.getContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
            return "";
        } finally {

            try {
                if (fin != null)
                    fin.close();
            } catch (IOException ex) {

                Toast.makeText(view.getContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        return text;
    }
}
