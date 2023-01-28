// Appointment.java
// W. Money
// 1/25/2023
// app representing an appointment

package edu.fscj.cop2805c.appointment;

import java.time.ZoneId;
import java.time.ZonedDateTime;

enum PREFCONTACT {NONE, TEXT, EMAIL}

class Contact {

    private StringBuilder name;
    private String email;
    private String phone;
    private PREFCONTACT contactPref;
    private ZoneId timeZone;

    public StringBuilder getName() {return name;}
    public String getEmail() {return email;}
    public String getPhone() {return phone;}
    public String getContactPref() {return contactPref.toString();}
    public ZoneId getTimeZone() {return timeZone;}

    public void setName(StringBuilder name) {this.name = name;}
    public void setEmail(String email) {this.email = email;}
    public void setPhone(String phone) {this.phone = phone;}
    public void setContactPref(PREFCONTACT contactPref) {
        this.contactPref =contactPref;
    }

    public Contact(String fName, String lName, String email, String phone,
                   PREFCONTACT contactPref, ZoneId timeZone) {
        this.name = new StringBuilder();
        this.name.append(lName).append(", ").append(fName);
        this.email = email;
        this.phone = phone;
        this.contactPref = contactPref;
        this.timeZone = timeZone;
    }

    @Override
    public String toString(){
        String s = email + ",(" + name + ")" + phone + "," +
                contactPref + "," + timeZone;
        return s;
    }
}

public class Appointment {

    private String title;
    private String desc;
    private Contact contact;
    private ZonedDateTime apptTime;
    private ZonedDateTime apptRemind;
    private int reminder;

    public void setTitle(String title){this.title = title;}

    public void setDesc(String desc){this.desc = desc;}

    public void setApptTime(ZonedDateTime apptTime){this.apptTime = apptTime;}

    public void setReminder(int reminder){this.reminder = reminder;}
    public Appointment(String title, String desc, Contact contact,
                       ZonedDateTime apptTime, int reminder) {
        this.title = title;
        this.desc = desc;
        this.contact = contact;
        this.apptTime = apptTime;
        this.apptRemind = apptTime.minusHours(reminder);
    }

    @Override
    public String toString(){
        String s = "Appt: \n";
        s += "\t Title: " + title + "\n";
        s += "\t Desc: " + desc + "\n";
        s += "\t Contact: " + contact + "\n";
        s += "\t Appt Date/Time: " + apptTime +"\n";
        s += "\t Reminder: " + apptRemind;
        return s;
    }


    public static void main(String[] args) {



        Contact contact1 = new Contact("Ash", "Williams", "Ash@sMart.com",
                "555-555-555", PREFCONTACT.NONE, ZoneId.systemDefault());

        Appointment appt1 = new Appointment("Fight Skeleton Army",
                "Get sucked back to 1300AD and fail to follow instructions ",
                contact1, ZonedDateTime.of(2023, 6, 7, 12,
                30, 0, 0,contact1.getTimeZone()), 3);

        System.out.println(appt1);
    }
}