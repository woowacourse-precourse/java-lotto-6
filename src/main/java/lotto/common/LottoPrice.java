package lotto.common;

import java.math.BigDecimal;

public enum LottoPrice {
    PRICE("1,000");
    private String price;
    
    private LottoPrice(String price){
        this.price = price;
    }

    public BigDecimal getBigDecimalPrice(){
        return new BigDecimal(price.replace(",",""));
    }

    public String getPrice(){
        return price;
    }
}
