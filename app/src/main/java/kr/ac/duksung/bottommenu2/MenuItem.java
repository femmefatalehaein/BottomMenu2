package kr.ac.duksung.bottommenu2;

import java.util.ArrayList;

public class MenuItem {

    int resourceId;
    String name;
    String price;
    String benefit;

    public MenuItem(int resourceId, String name, String price, String benefit) {
        this.resourceId = resourceId;
        this.name = name;
        this.price= price;
        this.benefit = benefit;
    }

    // 입력받은 숫자의 리스트생성
    public static ArrayList<MenuItem> createContactsList(int numContacts) {
        ArrayList<MenuItem> contacts = new ArrayList<MenuItem>();

        for (int i = 1; i <= numContacts; i++) {
            contacts.add(new MenuItem(R.drawable.test_img,"구테로이테", "3,000~ ", "포장방문시 1,000원 할인"));
        }

        return contacts;
    }

    public int getResourceId() {
        return resourceId;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getBenefit() {
        return benefit;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setBenefit(String benefit) {
        this.benefit = benefit;
    }
}
