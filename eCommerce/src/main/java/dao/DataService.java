/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.ResultSet;
import pojo.DeliveryItem;
import pojo.User;

/**
 *
 * @author Nur Uddin
 */
public class DataService {
    private final DatabaseConnection databaseConnection;
    private String query;
    private ResultSet result;
    
    public DataService(){
        databaseConnection = new DatabaseConnection();
    }
    
    public void createUser(User user){
        query = "insert into userinfo(name, phone_no, email, password, District, UpaZilla, RoadNo) values('"+user.getName()+"', '"+user.getPhone_no()+"', '"+user.getEmail()+"', '"+user.getPassword()+"', '"+user.getDistrict()+"', '"+user.getUpaZilla()+"', '"+user.getRoadNo()+"')";
        boolean res = databaseConnection.doDatabaseExecution(query);
        System.out.println(res);
    }
    
    public void deliveryItemInsert(DeliveryItem item){
        query = "insert into delivery_info(name, phone_no, district, upazilla, road_no, house_no, product_id) values('"+item.getName()+"', '"+item.getPhoneNo()+"', '"+item.getDistrict()+"', '"+item.getUpaZilla()+"', '"+item.getRoadNo()+"', '"+item.getHouseNo()+"', '"+item.getId()+"')";
        System.out.println(query);
        boolean res = databaseConnection.doDatabaseExecution(query);
        System.out.println("one item inserted");
    }
    
    public ResultSet getProductDetails(String categoryName){
        query = "select product_id, product_name, product_description, product_img, product_price, product_quantity from product_list natural join product_category where category_name='"+categoryName+"'";
        result = databaseConnection.getResultSet(query);
        return result;
    }
    
    public ResultSet getProductItemDetails(int id){
        query = "select product_id, product_name, product_description, product_img, product_img1, product_img2, product_price, product_quantity from product_list natural join product_category where product_id="+id;
        System.out.println(query);
        result = databaseConnection.getResultSet(query);
        
        return result;
    }
}
