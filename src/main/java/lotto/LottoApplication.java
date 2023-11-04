package lotto;

import View.Input;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoApplication {
    private static int LOTTO_PRICE = 1000;

    void execute() {
        int receivedAmount = getReceivedAmount();
    }

    int getReceivedAmount() {
        int receivedAmount;

        try {
            receivedAmount = Integer.parseInt(Input.readReceivedAmount());
            validateReceivedAmount(receivedAmount);
        } catch (NumberFormatException nfe) { // 정수값 입력하지 않았을 경우
            throw new IllegalArgumentException();
        }

        return receivedAmount;
    }

    private void validateReceivedAmount(int receivedAmount) {
        if (!(receivedAmount % LOTTO_PRICE == 0)) {
            throw new IllegalArgumentException();
        }
    }

    private Lotto drawLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(Lotto.START_NUMBER, Lotto.END_NUMBER, 6));
    }

    private int decideNumberOfLotto(int receivedAmount) {
        return receivedAmount / LOTTO_PRICE;
    }
}
