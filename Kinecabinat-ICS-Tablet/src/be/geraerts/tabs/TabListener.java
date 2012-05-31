package be.geraerts.tabs;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;

/**
 * @author François Geraerts
 *         <p/>
 *         Date: 29/05/12
 *         Time: 18:23
 */
public class TabListener<T extends Fragment> implements ActionBar.TabListener {


    private Fragment fragment;
    private Activity activity;
    private Class<T> fragmentClass;
    private int fragmentContainer;


    public TabListener(Activity activity, Class<T> fragmentClass, int fragmentContainer) {
        this.activity = activity;
        this.fragmentClass = fragmentClass;
        this.fragmentContainer = fragmentContainer;
    }


    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

        if (fragment == null) {
            String fragmentName = fragmentClass.getName();
            fragment = Fragment.instantiate(activity, fragmentName);
            fragmentTransaction.add(fragmentContainer, fragment, fragmentName);
        }


        fragmentTransaction.attach(fragment);

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

        if (fragment != null) {
            fragmentTransaction.detach(fragment);
        }
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        if (fragment != null) {
            fragmentTransaction.attach(fragment);
        }
    }
}
