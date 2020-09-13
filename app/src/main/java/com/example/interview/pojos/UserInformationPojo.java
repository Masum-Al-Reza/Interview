package com.example.interview.pojos;

public class UserInformationPojo {
    private String uesrID;
    private String userFirstName;
    private String userLastname;
    private String useremail;
    private String usernumber;
    private String userPassword;

    public UserInformationPojo() {
    }

    public UserInformationPojo(String uesrID, String userFirstName, String userLastname, String useremail, String usernumber, String userPassword) {
        this.uesrID = uesrID;
        this.userFirstName = userFirstName;
        this.userLastname = userLastname;
        this.useremail = useremail;
        this.usernumber = usernumber;
        this.userPassword = userPassword;
    }

    public String getUesrID() {
        return uesrID;
    }

    public void setUesrID(String uesrID) {
        this.uesrID = uesrID;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastname() {
        return userLastname;
    }

    public void setUserLastname(String userLastname) {
        this.userLastname = userLastname;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUsernumber() {
        return usernumber;
    }

    public void setUsernumber(String usernumber) {
        this.usernumber = usernumber;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }


}
