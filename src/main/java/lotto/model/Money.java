package lotto.model;

import lotto.constant.ExceptionMessage;

import java.util.regex.Pattern;

public class Money {

    private static int price;
    private final int priceUnit = 1_000;

    public Money (){
        price = 0;
    }

    public Money(String price){
        vailddateNumber(price);
        int num = Integer.parseInt(price);
        vaildateNegativeRange(num);
        vaildateLowRange(num);
        vaildateRemain(num);
        this.price = num;
    }

    private void vaildateNegativeRange(int price) {
        if (price <= 0) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_NEGATIVE_RANGE_MONEY.getMessage());
        }
    }

    private void vaildateLowRange(int price) {
        if (0 <= price && price < priceUnit) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_LOW_RANGE_MONEY.getMessage());
        }
    }

    private void vaildateRemain(int price) {
        if (price % priceUnit != 0) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_REMAIN_MONEY.getMessage());
        }
    }

    private void vailddateNumber(String price){
        if(!Pattern.matches("^[1-9|0-9]+$",price)){
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_RANGE_MONEY.getMessage());
        }
    }

    public int calculateLottoSize() {
        return price / priceUnit;
    }

    public int getPrice(){
        return price;
    }
}
