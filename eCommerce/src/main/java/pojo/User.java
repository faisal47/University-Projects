/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pojo;

/**
 *
 * @author Nur Uddin
 */
public class User {
    private String user_id;
    private String name;
    private int phone_no;
    private String email;
    private String password;
    private String District;
    private String UpaZilla;
    private String RoadNo;
    
    public User(){
    
    }
    
    public User(String name, int phone_no, String email, String password, String District, String UpaZilla, String RoadNo){
        this.name = name;
        this.phone_no = phone_no;
        this.email = email;
        this.password = password;
        this.District = District;
        this.UpaZilla = UpaZilla;
        this.RoadNo = RoadNo;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(int phone_no) {
        this.phone_no = phone_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String District) {
        this.District = District;
    }

    public String getUpaZilla() {
        return UpaZilla;
    }

    public void setUpaZilla(String UpaZilla) {
        this.UpaZilla = UpaZilla;
    }

    public String getRoadNo() {
        return RoadNo;
    }

    public void setRoadNo(String RoadNo) {
        this.RoadNo = RoadNo;
    }

    @Override
    public String toString() {
        return "User{" + "user_id=" + user_id + ", name=" + name + ", phone_no=" + phone_no + ", email=" + email + ", password=" + password + ", District=" + District + ", UpaZilla=" + UpaZilla + ", RoadNo=" + RoadNo + '}';
    }
    
    
}
