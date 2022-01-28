package bookstore.utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.text.DecimalFormat;

public class Formatter {
    static public Integer price2Int(String price){
        price = price.replace(",", "");
        price = price.replace(" ", "");
        
        if (price.endsWith("đ")){
            price = price.substring(0, price.length() - 1);
        }
        
        if (price.isBlank())
            return 0;
        
        return Integer.valueOf(price);
    }
    
    static public String int2Price(Integer price){
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(price) + "đ";
    }
}
