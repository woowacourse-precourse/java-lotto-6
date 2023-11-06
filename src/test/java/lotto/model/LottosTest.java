package lotto.model;

import static lotto.constant.LottoGameMessage.NUMBER_OF_LOTTO_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;

import lotto.util.RandomUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {
    private final RandomUtil randomUtil = new RandomUtil();
    private final int SUCCESSFUL_PAYMENT_AMOUNT = 3000;

    @DisplayName("구매한 로또 개수 구하기 테스트")
    @Test
    void paymentAmountTest() {
        Lottos lottos = new Lottos(new PaymentAmount(SUCCESSFUL_PAYMENT_AMOUNT), randomUtil);
        int numberOfLotto = computeNumberOfLotto(SUCCESSFUL_PAYMENT_AMOUNT);
        assertThat(lottos.toString()).contains(String.format(NUMBER_OF_LOTTO_MESSAGE.getMessage(), numberOfLotto));
    }

    private int computeNumberOfLotto(int paymentAmount) {
        return paymentAmount / 1000;
    }
}