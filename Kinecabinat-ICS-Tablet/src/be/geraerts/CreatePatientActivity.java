package be.geraerts;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import be.geraerts.content.PatientContentProvider;

/**
 * @author François Geraerts
 *         <p/>
 *         Date: 3/06/12
 *         Time: 18:28
 */
public class CreatePatientActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_patient_activity);

        this.setTitle(R.string.create_patient_dg_title);


        Button createButton = (Button) findViewById(R.id.create_patient_create_button);

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //Create a new row of values to insert
                final ContentValues newPatientValues = new ContentValues();


                final String patientName = ((EditText) findViewById(R.id.et_name)).getText().toString();
                final String patientFirstName = ((EditText) findViewById(R.id.et_first_name)).getText().toString();

                //Assign value for each row
                newPatientValues.put(PatientContentProvider.PATIENT_NAME, patientName);
                newPatientValues.put(PatientContentProvider.PATIENT_FIRST_NAME, patientFirstName);

                final ContentResolver cr = getContentResolver();
                //cr.acquireContentProviderClient(PatientContentProvider.CONTENT_URI);

                final Uri myRowUri = cr.insert(PatientContentProvider.CONTENT_URI, newPatientValues);

                Log.w("CreatePatientActivity", "Uri recovered: " + myRowUri.toString());

                //Appel du code pour créer le patient avec le content provider
                Toast.makeText(getApplicationContext(), "The new patient is added: " + myRowUri.toString(), Toast.LENGTH_LONG).show();


            }
        });


        Button close_button = (Button) findViewById(R.id.create_patient_close_button);
        close_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }


}
