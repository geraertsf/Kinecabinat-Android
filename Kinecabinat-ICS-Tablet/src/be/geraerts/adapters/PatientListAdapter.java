package be.geraerts.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import be.geraerts.R;
import be.geraerts.model.Patient;

import java.util.List;

/**
 * @author François Geraerts
 *         <p/>
 *         Date: 31/05/12
 *         Time: 21:31
 */
public class PatientListAdapter extends ArrayAdapter<Patient> {


    int resource;

    public PatientListAdapter(Context context, int resource, List<Patient> patients) {
        super(context, resource, patients);
        this.resource = resource;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LinearLayout patientListView;

        Patient patient = getItem(position);


        if (convertView == null) {
            patientListView = new LinearLayout(getContext());
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater li;
            li = (LayoutInflater) getContext().getSystemService(inflater);
            li.inflate(resource, patientListView, true);
        } else {
            patientListView = (LinearLayout) convertView;
        }

        //Map the patient fields to the view (widget)


        TextView nameView = (TextView) patientListView.findViewById(R.id.rowNames);
        TextView telephoneView = (TextView) patientListView.findViewById(R.id.rowTel);


        //Concaténe le nom et prénom pour le row name

        StringBuilder builderName = new StringBuilder();

        builderName.append(patient.getFirstName());
        builderName.append(" ");
        builderName.append(patient.getName());

        StringBuilder builderTel = new StringBuilder();

        if (patient.getTel() != null) {
            builderTel.append(patient.getTel());
            builderTel.append(" - ");
        }

        if (patient.getGsm1() != null) {
            builderTel.append(patient.getGsm1());
        }


        nameView.setText(builderName);
        telephoneView.setText(builderTel);


        return patientListView;
    }
}
