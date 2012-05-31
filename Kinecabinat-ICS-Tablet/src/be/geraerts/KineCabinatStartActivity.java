package be.geraerts;

import android.app.ActionBar;
import android.app.Activity;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import be.geraerts.content.PatientContentProvider;
import be.geraerts.fragments.AgendaFragment;
import be.geraerts.fragments.PatientsFragment;
import be.geraerts.tabs.TabListener;

public class KineCabinatStartActivity extends Activity implements LoaderManager.LoaderCallbacks<Cursor> {


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        this.setTitle(R.string.app_title);


        ActionBar actionBar = getActionBar();

//        actionBar.setTitle(R.string.app_title);
//        actionBar.setSubtitle(R.string.subtitle_init);
        actionBar.show();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);


        ActionBar.Tab tabAgenda = actionBar.newTab();

        tabAgenda.setText("Agenda").setContentDescription("Agenda du jour");
        tabAgenda.setTabListener(new TabListener<AgendaFragment>(this, AgendaFragment.class, R.id.mainId));

        actionBar.addTab(tabAgenda);


        ActionBar.Tab tabPatients = actionBar.newTab();
        tabPatients.setText("Patients").setContentDescription("Listes des patients");
        tabPatients.setTabListener(new TabListener<PatientsFragment>(this, PatientsFragment.class, R.id.mainId));

        actionBar.addTab(tabPatients);


        //Load the patients List
        // Get references to the Fragments
//        FragmentManager fm = getFragmentManager();
//        PatientsListFragment patientsFragment =(PatientsListFragment)fm.findFragmentById(R.id.left_container);

//        final ArrayList<Patient> patientsList = new ArrayList<Patient>();

//        Patient patientGeraerts = new Patient("Geraerts","Francois","063325058","0494200241");
//        Patient patientAline = new Patient("Thiernesse","Aline","063325058","0478067271");

        // Create the array adapter to bind the array to the ListView
//        int resID = R.layout.patientlist_item;
//        PatientListAdapter patientListAdapter = new PatientListAdapter(this, resID, patientsList);

//        patientsFragment.setListAdapter(patientListAdapter);
        //getLoaderManager().initLoader(0, null, this);


    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        CursorLoader loader = new CursorLoader(this, PatientContentProvider.CONTENT_URI, null, null, null, null);
        return loader;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor cursor) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void onLoaderReset(Loader<Cursor> cursorLoader) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
