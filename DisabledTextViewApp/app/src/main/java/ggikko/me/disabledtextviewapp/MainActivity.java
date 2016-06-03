package ggikko.me.disabledtextviewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.BindView;
import butterknife.ButterKnife;
import ggikko.me.disabledtextviewapp.util.DisabledTextField;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txt_disabled) DisabledTextField txt_disabled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        txt_disabled.setCaption("name");
        txt_disabled.setText("ggikko");
    }

}
