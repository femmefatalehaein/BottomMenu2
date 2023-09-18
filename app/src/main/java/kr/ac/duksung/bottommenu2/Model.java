package kr.ac.duksung.bottommenu2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Model {
        @SerializedName("menus_id")
        @Expose
        private int menusId;

        @SerializedName("stores_id")
        @Expose
        private int storesId;

        public int getMenusId() {
                return menusId;
        }

        public void setMenusId(int menusId) {
                this.menusId = menusId;
        }

        public int getStoresId() {
                return storesId;
        }

        public void setStoresId(int storesId) {
                this.storesId = storesId;
        }

        public String getMenusName() {
                return menusName;
        }

        public void setMenusName(String menusName) {
                this.menusName = menusName;
        }

        public int getPrices() {
                return prices;
        }

        public void setPrices(int prices) {
                this.prices = prices;
        }

        @SerializedName("menus_name")
        @Expose
        private String menusName;

        @SerializedName("prices")
        @Expose
        private int prices;





}
