package com.antoniotari.daggerexample;

import com.mokalab.injection.Injector;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;
import javax.inject.Provider;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Inject
    TemplateSingleton mSingleton;
    @Inject
    Provider<MyReader> mReaderProvider;

    @Bind (R.id.text1)
    TextView mTextView;
    @Bind (R.id.button1)
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Injector.inject(this);
        ButterKnife.bind(this);

        mButton.setText("tap me");

        MyReader reader=mReaderProvider.get();
        Toast.makeText(this,reader.readText(),Toast.LENGTH_LONG).show();
    }

    @OnClick (R.id.button1)
    public void buttonClick() {
        mTextView.setText(mSingleton.getPackageName());
    }
}
