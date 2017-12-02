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
public class DeliveryItem {
    private int id;
    private String name;
    private int phoneNo;
    private String District;
    private String UpaZilla;
    private String RoadNo;
    private String HouseNo;

    public DeliveryItem() {
        
    }
    
    public DeliveryItem(int id, String name, int phoneNo, String District, String UpaZilla, String RoadNo, String HouseNo) {
        this.id = id;
        this.name = name;
        this.phoneNo = phoneNo;
        this.District = District;
        this.UpaZilla = UpaZilla;
        this.RoadNo = RoadNo;
        this.HouseNo = HouseNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
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

    public String getHouseNo() {
        return HouseNo;
    }

    public void setHouseNo(String HouseNo) {
        this.HouseNo = HouseNo;
    }

    @Override
    public String toString() {
        return "DeliveryItem{" + "id=" + id + ", name=" + name + ", phoneNo=" + phoneNo + ", District=" + District + ", UpaZilla=" + UpaZilla + ", RoadNo=" + RoadNo + ", HouseNo=" + HouseNo + '}';
    }
    
    
}
