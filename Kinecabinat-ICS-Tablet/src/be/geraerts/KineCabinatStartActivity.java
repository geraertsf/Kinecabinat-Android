package be.geraerts;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import be.geraerts.fragments.AgendaFragment;
import be.geraerts.fragments.PatientsFragment;
import be.geraerts.tabs.TabListener;

public class KineCabinatStartActivity extends Activity {


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

    }
}
