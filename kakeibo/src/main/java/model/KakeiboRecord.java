package model;

public class KakeiboRecord {
    public int id;
    public String username;
    public int balance;
    public int payment;

    public KakeiboRecord() {
    }

    public int getId(){
        return this.id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getUsername(){
        return this.username;
    }
    
    public void setUsername(String username){
        this.username = username;
    }

    public int getBalance(){
        return this.balance;
    }

    public void setBalance(int balance){
        this.balance = balance;
    }

    public int getPayment(){
        return this.payment;
    }

    public void setPayment(int payment){
        this.payment = payment;
    }
}