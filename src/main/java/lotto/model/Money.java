package lotto.model;

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
            throw new IllegalArgumentException("[ERROR] 지폐난 동전외에 다른 것을 투입하지 마세요.");
        }
    }

    private void vaildateLowRange(int price) {
        if (0 <= price && price < priceUnit) {
            throw new IllegalArgumentException("[ERROR] 최소 금액은 1000원입니다.");
        }
    }

    private void vaildateRemain(int price) {
        if (price % priceUnit != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해 주시길 바랍니다.");
        }
    }

    private void vailddateNumber(String price){
        if(!Pattern.matches("^[1-9|0-9]+$",price)){
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
    }

    public int calculateLottoSize() {
        return price / priceUnit;
    }

    public int getPrice(){
        return price;
    }
}
