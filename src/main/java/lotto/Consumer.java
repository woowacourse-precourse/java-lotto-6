package lotto;


import java.util.ArrayList;
import java.util.List;

public class Consumer {
    private int payment = 0;

    private final int LOTTO_PRICE = 1000;

    public List<Lotto> lotto = new ArrayList<>();

    public int getPayment() {
        return payment;
    }

    public int payForLotto(String readLine) {
        try {
            int price = Integer.parseInt(readLine);
            assertPaymentForLotto(price);
            int numberOfLotto = price / LOTTO_PRICE;
            payment = price;
            return numberOfLotto;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 숫자로 입력해주세요.");
        }
    }

    private void assertPaymentForLotto(int price) {
        if (price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 천원 단위로 입력해주세요.");
        }
    }
}
