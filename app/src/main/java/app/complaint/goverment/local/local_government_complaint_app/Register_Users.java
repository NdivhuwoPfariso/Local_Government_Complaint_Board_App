package app.complaint.goverment.local.local_government_complaint_app;

/**
 * Created by Pfariso on 2018/04/11.
 */

public class Register_Users {
    String user_Key;
    String name;
    String Surname;
    String userName;
    String IdNo;
    String Address;
    String email;


    public Register_Users(String user_Key, String name, String surname, String userName, String idNo, String address, String email) {
        this.user_Key = user_Key;
        this.name = name;
        Surname = surname;
        this.userName = userName;
        IdNo = idNo;
        Address = address;
        this.email = email;
    }

    public String getUser_Key(){
        return user_Key;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return Surname;
    }

    public String getUserName() {
        return userName;
    }

    public String getIdNo() {
        return IdNo;
    }

    public String getAddress() {
        return Address;
    }

    public String getEmail() {
        return email;
    }
}
