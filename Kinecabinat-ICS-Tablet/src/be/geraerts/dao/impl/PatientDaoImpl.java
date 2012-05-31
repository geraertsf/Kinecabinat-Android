package be.geraerts.dao.impl;

import android.content.ContentResolver;
import be.geraerts.dao.interfaces.PatientDao;
import be.geraerts.model.Patient;

import java.util.List;

/**
 * @author François Geraerts
 *         <p/>
 *         Date: 31/05/12
 *         Time: 11:22
 */
public class PatientDaoImpl implements PatientDao {


    private ContentResolver contentResolver;


    public PatientDaoImpl(ContentResolver contentResolver) {
        this.contentResolver = contentResolver;
    }

    @Override
    public Patient getPatient(long patientId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Patient> getPatients() {


        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
