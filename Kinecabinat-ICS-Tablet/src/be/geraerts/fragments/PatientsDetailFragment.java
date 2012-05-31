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
 *         Time: 16:24
 */
public class PatientsDetailFragment extends Fragment {

    private View view = null;


    public PatientsDetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.patients_detail_fragment, container, false);
        }
        return view;
    }
}
