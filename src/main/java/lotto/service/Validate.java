package lotto.service;

public class Validate {

    public void IsThousandFormat(int money) {
        while (money > 0) {
            if (money%10 != 0) {
                System.out.println("[ERROR] 로또 구매 금액은 1000원 단위여야 합니다.");
                throw new IllegalArgumentException();
            }
            money /= 1000;
        }
    }

}