/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import model.Bill;
import model.Product;
/**
 *
 * @author John Justine
 */
public class BillDao {
    public static String getId(){
        int id = 1;
        try{
            ResultSet rs = DbOperations.getData("select max(id) from bill");
            if(rs.next()){
               id = rs.getInt(1);
               id = id + 1;             
            }
        }
            catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
            }
            return String.valueOf(id);
        
    }
    public static void save(Bill bill){
        String query = "insert into bill value('"+bill.getId()+"','"+bill.getName()+"','"+bill.getMobileNumber()+"','"+bill.getEmail()+"','"+bill.getDate()+"','"+bill.getTotal()+"','"+bill.getCreatedBy()+"',)";
        DbOperations.setDataOrDelete(query, "Bill Details Added Successfully ");
        
    }
    public static ArrayList<Bill> getAllRecordsByInc(String date){
        ArrayList<Bill> arraylist = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("select*from bill where data like '%"+date+"%'order By id DESC");
            Bill bill = new Bill();
            bill.setId(rs.getInt("id"));
            bill.setName(rs.getString("name"));
            bill.setMobileNumber(rs.getString("mobileNumber"));
            bill.setEmail(rs.getString("email"));
            bill.setDate("date");
            bill.setTotal(rs.getString("total"));
            bill.setCreatedBy(rs.getString("createdBy"));
            arraylist.add(bill);
        }
        
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arraylist;
    }
}
