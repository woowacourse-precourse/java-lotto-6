package lotto;


public class Consumer {
    private int payment = 0;

    public int getPayment() {
        return payment;
    }

    public int payForLotto(String readLine){
        try {
            int price = Integer.parseInt(readLine);
            assertPaymentForLotto(price);
            int numberOfLotto = price / 1000;
            payment = price;
            return numberOfLotto;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 숫자로 입력해주세요.");
        }
    }
    private void assertPaymentForLotto(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 천원 단위로 입력해주세요.");
        }
    }
}
