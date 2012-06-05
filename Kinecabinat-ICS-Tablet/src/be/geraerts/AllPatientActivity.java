package be.geraerts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * @author François Geraerts
 *         <p/>
 *         Date: 1/06/12
 *         Time: 18:45
 */
public class AllPatientActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setTitle("Listes de tout les patients");


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_all_patients, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);


        switch (item.getItemId()) {

            case R.id.menu_add_patient:
                //Navigation to the createPatienActivity
                Intent intent = new Intent(this, CreatePatientActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;

            case R.id.menu_del_patient:
                Toast.makeText(this, "Delete button is pressed", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return false;

        }


    }
}
