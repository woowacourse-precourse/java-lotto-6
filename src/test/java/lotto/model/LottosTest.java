package lotto.model;

import static lotto.constant.LottoGameMessage.NUMBER_OF_LOTTO_MESSAGE;
import static lotto.constant.LottoTestConstant.LOTTO_NUMBERS_2;
import static lotto.constant.PaymentAmountTestConstant.PAYMENT_AMOUNT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.stream.IntStream;
import lotto.util.RandomUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LottosTest {
    private final RandomUtil randomUtil = new RandomUtil();

    @DisplayName("구매한 로또 개수 구하기 테스트")
    @Test
    void paymentAmountTest() {
        Lottos lottos = new Lottos(Integer.parseInt(PAYMENT_AMOUNT.getValue()), randomUtil);
        int numberOfLotto = computeNumberOfLotto(Integer.parseInt(PAYMENT_AMOUNT.getValue()));
        assertThat(lottos.toString()).contains(String.format(NUMBER_OF_LOTTO_MESSAGE.getMessage(), numberOfLotto));
    }

    private int computeNumberOfLotto(int paymentAmount) {
        return paymentAmount / 1000;
    }

    @DisplayName("구매한 로또 개수만큼 로또 생성 테스트")
    @Test
    void createLottoTest() {
        RandomUtil randomUtil = Mockito.mock(RandomUtil.class);
        when(randomUtil.createSortedRandomNumbersInRange(anyInt(), anyInt(), anyInt())).thenReturn(LOTTO_NUMBERS_2);

        Lottos lottos = new Lottos(Integer.parseInt(PAYMENT_AMOUNT.getValue()), randomUtil);
        assertThat(lottos).hasToString(lottosInfo());
    }

    private String lottosInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(NUMBER_OF_LOTTO_MESSAGE.getMessage(),
                        computeNumberOfLotto(Integer.parseInt(PAYMENT_AMOUNT.getValue()))))
                .append('\n');
        IntStream.range(0, computeNumberOfLotto(Integer.parseInt(PAYMENT_AMOUNT.getValue())))
                .forEach(i -> sb.append(LOTTO_NUMBERS_2.toString()).append('\n'));

        return sb.toString();
    }
}