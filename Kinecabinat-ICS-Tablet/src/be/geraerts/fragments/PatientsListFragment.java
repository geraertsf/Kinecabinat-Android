package be.geraerts.fragments;

import android.app.FragmentManager;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import be.geraerts.R;
import be.geraerts.adapters.PatientListAdapter;
import be.geraerts.model.Patient;

import java.util.ArrayList;

/**
 * @author François Geraerts
 *         <p/>
 *         Date: 29/05/12
 *         Time: 13:42
 */
public class PatientsListFragment extends ListFragment {


    private View view = null;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        if (view == null) {
            view = inflater.inflate(R.layout.patients_list_fragment, container, false);
        }


        //Load the patients List
        // Get references to the Fragments
//        FragmentManager fm = getFragmentManager();
//        PatientsListFragment patientsFragment =(PatientsListFragment)fm.findFragmentById(R.id.left_container);


        return view;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FragmentManager fm = getFragmentManager();

        PatientsListFragment patientsFragment = (PatientsListFragment) fm.findFragmentById(R.id.left_container);

        final ArrayList<Patient> patientsList = new ArrayList<Patient>();

        Patient patientGeraerts = new Patient("Geraerts", "Francois", "063325058", "0494200241");
        Patient patientAline = new Patient("Thiernesse", "Aline", "063325058", "0478067271");
        Patient patientMichel = new Patient("Geraerts", "Michel", "063325058", "0475062271");

        patientsList.add(patientGeraerts);
        patientsList.add(patientAline);
        patientsList.add(patientMichel);

        // Create the array adapter to bind the array to the ListView
        int resID = R.layout.patients_list_items;
        PatientListAdapter patientListAdapter = new PatientListAdapter(getActivity(), resID, patientsList);

        patientsFragment.setListAdapter(patientListAdapter);


    }
}
