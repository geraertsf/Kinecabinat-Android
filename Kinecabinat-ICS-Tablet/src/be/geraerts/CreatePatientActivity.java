package be.geraerts;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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


                //Appel du code pour créer le patient avec le content provider
                Toast.makeText(getApplicationContext(), "The new patient is added", Toast.LENGTH_SHORT).show();

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
