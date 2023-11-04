package lotto;


public class GameManager {
    public int getPaymentForLottoByRead(String readLine) {
        int price = Integer.parseInt(readLine);
        assertPaymentForLotto(price);
        int numberOfLotto = price / 1000;
        return numberOfLotto;
    }

    private void assertPaymentForLotto(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 천원 단위로 입력해주세요.");
        }
    }
}
