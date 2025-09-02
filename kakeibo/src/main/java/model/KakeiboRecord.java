package model;

public class KakeiboRecord {
    public String username;
    public int balance;
    public int payment;
    public KakeiboRecord(String username, int balance, int payment) {
        this.username = username;
        this.balance = balance;
        this.payment = payment;
    }
}