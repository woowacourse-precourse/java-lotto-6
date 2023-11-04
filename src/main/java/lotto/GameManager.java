package lotto;


import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameManager {

    public int getPaymentForLottoByRead() {
        int lottoAmount = 0;
        while (true) {
            if (lottoAmount >= 1000) break;
            try {
                lottoAmount = getPaymentForLottoByRead(readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return lottoAmount;
    }

    protected int getPaymentForLottoByRead(String readLine) {

        try {
            int price = Integer.parseInt(readLine);
            assertPaymentForLotto(price);
            int numberOfLotto = price / 1000;
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
