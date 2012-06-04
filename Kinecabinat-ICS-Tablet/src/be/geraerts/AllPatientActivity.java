package be.geraerts;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

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
}
