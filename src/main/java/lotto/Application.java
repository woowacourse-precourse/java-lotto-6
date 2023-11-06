package lotto;

import static lotto.Utils.setPriceType;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String a = "123456789";
        int price = setPriceType(a);
        System.out.println(price);
    }
}
