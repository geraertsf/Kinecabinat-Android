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
 *         Time: 18:32
 */
public class AgendaFragment extends Fragment {

    public AgendaFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.agenda_fragment, container, false);
        return view;
    }
}
