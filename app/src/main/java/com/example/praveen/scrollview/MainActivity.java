package com.example.praveen.scrollview;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference database;

    private EditText mname;
    private EditText mage;
    private EditText mdateofbirth;
    private EditText mheadrelation;
    private EditText madhaar;
    private EditText mreligion;
    private EditText mbirth;
    private EditText mphone;
    private EditText mmothong;
    private EditText mothlangkn;
    private EditText meducation;
    private EditText moccupation;
    private EditText mageatmar;
    private EditText mfamily;
    private EditText meverborn;
    private EditText msurviving;
    private EditText maddress;
    private EditText mpastaddress;
    private EditText mmigration;
    private EditText marea;
    private EditText mtenancy;

    private Button submit;

    RadioGroup mradio_sex;
    RadioButton SexButton;

    RadioGroup mradio_caste;
    RadioButton CasteButton;

    RadioGroup mradio_disable;
    RadioButton DisButton;

    RadioGroup mradio_marit;
    RadioButton MaritButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = FirebaseDatabase.getInstance().getReference().child("CITIZENS");

        mname = (EditText)findViewById(R.id.name);
        mage = (EditText)findViewById(R.id.age);
        mdateofbirth = (EditText)findViewById(R.id.dateofbirth);
        mheadrelation = (EditText)findViewById(R.id.headrelation);
        madhaar = (EditText)findViewById(R.id.adhaar);
        mreligion = (EditText)findViewById(R.id.religion);
        mbirth = (EditText)findViewById(R.id.birth);
        mphone = (EditText)findViewById(R.id.phone);
        mmothong = (EditText)findViewById(R.id.mothong);
        mothlangkn = (EditText)findViewById(R.id.othlangkn);
        meducation = (EditText)findViewById(R.id.education);
        moccupation = (EditText)findViewById(R.id.occupation);
        mageatmar = (EditText)findViewById(R.id.ageatmar);
        mfamily = (EditText)findViewById(R.id.family);
        meverborn = (EditText)findViewById(R.id.everborn);
        msurviving = (EditText)findViewById(R.id.surviving);
        maddress = (EditText)findViewById(R.id.address);
        mpastaddress = (EditText)findViewById(R.id.pastaddress);
        mmigration = (EditText)findViewById(R.id.migration);
        marea = (EditText)findViewById(R.id.area);
        mtenancy = (EditText)findViewById(R.id.tenancy);
        mradio_sex = findViewById(R.id.radio_sex);
        mradio_caste = findViewById(R.id.radio_caste);
        mradio_disable = findViewById(R.id.radio_disable);
        mradio_marit = findViewById(R.id.radio_marit);

        submit = (Button)findViewById(R.id.button);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mname.getText().toString().trim();
                String age = mage.getText().toString().trim();
                String dateofbirth = mdateofbirth.getText().toString().trim();
                String headrelation = mheadrelation.getText().toString().trim();
                String adhaar = madhaar.getText().toString().trim();
                String religion = mreligion.getText().toString().trim();
                String birth = mbirth.getText().toString().trim();
                String phone = mphone.getText().toString().trim();
                String mothong = mmothong.getText().toString().trim();
                String othlangkn = mothlangkn.getText().toString().trim();
                String education = meducation.getText().toString().trim();
                String occupation = moccupation.getText().toString().trim();
                String ageatmar = mageatmar.getText().toString().trim();
                String family = mfamily.getText().toString().trim();
                String everborn = meverborn.getText().toString().trim();
                String surviving = msurviving.getText().toString().trim();
                String address = maddress.getText().toString().trim();
                String pastaddress = mpastaddress.getText().toString().trim();
                String migration = mmigration.getText().toString().trim();
                String area = marea.getText().toString().trim();
                String tenancy = mtenancy.getText().toString().trim();
                String sex = SexButton.getText().toString().trim();
                String caste = CasteButton.getText().toString().trim();
                String disable = DisButton.getText().toString().trim();
                String marit= MaritButton.getText().toString().trim();

                HashMap<String, String>datamap = new HashMap<>();
                datamap.put("Name",name);
                datamap.put("Age",age);
                datamap.put("Date of birth",dateofbirth);
                datamap.put("Sex",sex);
                datamap.put("Relation to head of family",headrelation);
                datamap.put("Adhaar Number",adhaar);
                datamap.put("Religion",religion);
                datamap.put("Caste",caste);
                datamap.put("Birthplace",birth);
                datamap.put("Phone num",phone);
                datamap.put("Mother Tongue",mothong);
                datamap.put("Other lang Known",othlangkn);
                datamap.put("Education",education);
                datamap.put("Disability status",disable);
                datamap.put("Occupation",occupation);
                datamap.put("Marital status",marit);
                datamap.put("Age at marriage",ageatmar);
                datamap.put("Family members",family);
                datamap.put("Children everborn",everborn);
                datamap.put("Children surviving",surviving);
                datamap.put("Current address",address);
                datamap.put("Past address",pastaddress);
                datamap.put("Reason for migration",migration);
                datamap.put("Area of cultivation",area);
                datamap.put("Tenancy Status",tenancy);


                database.push().setValue(datamap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "stored successfully",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this, "error occured",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }

    public void sexButton(View view){
        int radiosex = mradio_sex.getCheckedRadioButtonId();
        SexButton = findViewById(radiosex);
    }

    public void casteButton(View view){
        int radiocaste = mradio_caste.getCheckedRadioButtonId();
        CasteButton = findViewById(radiocaste);
    }

    public void disButton(View view){
        int radiodis = mradio_disable.getCheckedRadioButtonId();
        DisButton = findViewById(radiodis);
    }

    public void maritButton(View view){
        int radiomarit = mradio_marit.getCheckedRadioButtonId();
        MaritButton = findViewById(radiomarit);
    }
}
