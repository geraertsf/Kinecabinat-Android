package be.geraerts.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author François Geraerts
 *         <p/>
 *         Date: 31/05/12
 *         Time: 10:15
 */
public class Patient {

    private long patientId;
    private String name;
    private String firstName;
    private String tel;
    private String gsm1;
    private String gsm2;
    private Date birthDate;
    private List<Address> addresses = new ArrayList<Address>();


    public Patient(String name, String firstName, String tel, String gsm1) {
        this.name = name;
        this.firstName = firstName;
        this.tel = tel;
        this.gsm1 = gsm1;
        this.gsm2 = null;
        this.birthDate = null;
    }

    public Patient(long patientId, String name, String firstName) {
        this.patientId = patientId;
        this.name = name;
        this.firstName = firstName;
        this.tel = null;
        this.gsm1 = null;
        this.gsm2 = null;
        this.birthDate = null;
    }


    public Patient(long patientId, String name, String firstName, String tel, String gsm1, String gsm2) {
        this.patientId = patientId;
        this.name = name;
        this.firstName = firstName;
        this.tel = tel;
        this.gsm1 = gsm1;
        this.gsm2 = gsm2;
        this.birthDate = null;
    }


    public Patient(long patientId, String name, String firstName, String tel, String gsm1, String gsm2, Date birthDate) {
        this.patientId = patientId;
        this.name = name;
        this.firstName = firstName;
        this.tel = tel;
        this.gsm1 = gsm1;
        this.gsm2 = gsm2;
        this.birthDate = birthDate;
    }


    public Patient(long patientId, String name, String firstName, String tel, String gsm1, String gsm2, Date birthDate, List<Address> addresses) {
        this.patientId = patientId;
        this.name = name;
        this.firstName = firstName;
        this.tel = tel;
        this.gsm1 = gsm1;
        this.gsm2 = gsm2;
        this.birthDate = birthDate;
        this.addresses = addresses;
    }


    public void addAddress(Address address) {
        this.addresses.add(address);

    }

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getGsm1() {
        return gsm1;
    }

    public void setGsm1(String gsm1) {
        this.gsm1 = gsm1;
    }

    public String getGsm2() {
        return gsm2;
    }

    public void setGsm2(String gsm2) {
        this.gsm2 = gsm2;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
