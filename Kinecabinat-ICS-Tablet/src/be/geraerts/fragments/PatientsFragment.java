package be.geraerts.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import be.geraerts.R;
import be.geraerts.dao.impl.PatientDaoImpl;
import be.geraerts.dao.interfaces.PatientDao;

import java.util.ArrayList;

/**
 * @author François Geraerts
 *         <p/>
 *         Date: 29/05/12
 *         Time: 18:49
 */
public class PatientsFragment extends Fragment {

    private View view = null;


    public PatientsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.patients_fragment, container, false);

            final ArrayList<String> patientsList = new ArrayList<String>();


            Activity activityParent = (Activity) container.getContext();


            final PatientDao patientDao = new PatientDaoImpl(activityParent.getContentResolver());


            final ListView patientsListView = (ListView) view.findViewById(R.id.listPatientId);

            patientsList.add("Toto");
            patientsList.add("Tutu");
            patientsList.add("Titi");
            patientsList.add("Tata");

            final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, patientsList);


            patientsListView.setAdapter(arrayAdapter);

        }

        return view;
    }
}
