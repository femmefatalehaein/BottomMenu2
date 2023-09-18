package kr.ac.duksung.bottommenu2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Item {

    @SerializedName("menusid")
    @Expose
    public int menusid;

    @SerializedName("storesid")
    @Expose
    public int storesid;

    @SerializedName("menusname")
    @Expose
    public String menusname;

    @SerializedName("prices")
    @Expose
    public int prices;


    public int getMenusid() {
        return menusid;
    }

    public void setMenusid(int menusid) {
        this.menusid = menusid;
    }

    public int getStoresid() {
        return storesid;
    }

    public void setStoresid(int storesid) {
        this.storesid = storesid;
    }

    public String getMenusname() {
        return menusname;
    }

    public void setMenusname(String menusname) {
        this.menusname = menusname;
    }

    public int getPrices() {
        return prices;
    }

    public void setPrices(int prices) {
        this.prices = prices;
    }

    @Override
    public String toString() {
        return ("menusid=" + menusid +
                ", storesid=" + storesid +
                ", menusname='" + menusname + '\'' +
                ", prices=" + prices
               );

    }
}
