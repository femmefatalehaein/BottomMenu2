package kr.ac.duksung.bottommenu2;

import java.util.ArrayList;

public class FavoriteItem {

    int resourceId;
    String name;
    String menu;
    String size;

    public FavoriteItem(int resourceId, String name, String menu, String size) {
        this.resourceId = resourceId;
        this.name = name;
        this.menu = menu;
        this.size = size;
    }

    // 입력받은 숫자의 리스트생성
    public static ArrayList<FavoriteItem> createContactsList(int numContacts) {
        ArrayList<FavoriteItem> contacts = new ArrayList<FavoriteItem>();

        for (int i = 1; i <= numContacts; i++) {
            contacts.add(new FavoriteItem(R.drawable.test_img,"쿵후마라탕", "마라탕", "90*100"));
        }

        return contacts;
    }

    public int getResourceId() {
        return resourceId;
    }

    public String getName() {
        return name;
    }

    public String getMenu() {
        return menu;
    }

    public String getSize() {
        return size;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
