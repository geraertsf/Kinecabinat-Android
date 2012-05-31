package be.geraerts.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import be.geraerts.R;

/**
 * @author François Geraerts
 *         <p/>
 *         Date: 29/05/12
 *         Time: 13:42
 */
public class PatientsListFragment extends Fragment {


    private View view = null;

    public PatientsListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (view == null) {
            view = inflater.inflate(R.layout.patients_list_fragment, container, false);
        }
        return view;
    }
}
