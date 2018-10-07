package com.example.wangsiqi.present;


public class ItemBean {
    public int itemImageResId;//图像资源ID
    public String itemFullname;//标题
    public String itemParty;//内容
    public String itemEmail;
    public  String itemHomepage;

    public ItemBean(int itemImageResId, String itemFullname, String itemParty, String itemEmail, String itemHomepage) {
        this.itemImageResId = itemImageResId;
        this.itemFullname = itemFullname;
        this.itemParty = itemParty;
        this.itemEmail = itemEmail;
        this.itemHomepage = itemHomepage;
    }
}