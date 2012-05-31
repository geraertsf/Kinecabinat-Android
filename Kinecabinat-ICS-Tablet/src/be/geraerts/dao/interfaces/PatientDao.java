package be.geraerts.dao.interfaces;

import be.geraerts.model.Patient;

import java.util.List;

/**
 * @author François Geraerts
 *         <p/>
 *         Date: 31/05/12
 *         Time: 11:20
 */
public interface PatientDao {


    public Patient getPatient(long patientId);

    public List<Patient> getPatients();


}
