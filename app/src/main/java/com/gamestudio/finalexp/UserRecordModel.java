package com.gamestudio.finalexp;
public class UserRecordModel {
    private String id;
    private String name;
    private String email;
    private String gender;
    private String status;

    // Constructor
    public UserRecordModel(String id, String name, String email, String gender,
                              String status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.status = status;
    }

    // Getter and Setter
    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String factory_code)
    {
        this.email = email;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String invoice_value)
    {
        this.gender = gender;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

}
