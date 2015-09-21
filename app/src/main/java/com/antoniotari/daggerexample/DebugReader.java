package com.antoniotari.daggerexample;

import com.mokalab.injection.ForApplication;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.inject.Inject;

/**
 * Created by antonio on 21/09/15.
 */
public class DebugReader extends MyReader {

    @Inject @ForApplication
    Context mContext;

    @Override
    public String readText() {
        StringBuffer stringBuffer=new StringBuffer();
        try {
            InputStream inputStream = mContext.getAssets().open("text1.txt");
            Reader reader=new InputStreamReader(inputStream);
            BufferedReader br=new BufferedReader(reader);
            String str;
            while((str=br.readLine())!=null){
                stringBuffer.append(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }
}
