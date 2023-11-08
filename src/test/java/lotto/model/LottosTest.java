package lotto.model;

import static lotto.constant.LottoGameMessage.NUMBER_OF_LOTTO_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.IntStream;
import lotto.util.RandomUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LottosTest {
    private final RandomUtil randomUtil = new RandomUtil();
    private final int SUCCESSFUL_PAYMENT_AMOUNT = 3000;
    private final List<Integer> LOTTO_NUMBER = List.of(3, 15, 23, 30, 36, 45);

    @DisplayName("구매한 로또 개수 구하기 테스트")
    @Test
    void paymentAmountTest() {
        Lottos lottos = new Lottos(SUCCESSFUL_PAYMENT_AMOUNT, randomUtil);
        int numberOfLotto = computeNumberOfLotto(SUCCESSFUL_PAYMENT_AMOUNT);
        assertThat(lottos.toString()).contains(String.format(NUMBER_OF_LOTTO_MESSAGE.getMessage(), numberOfLotto));
    }

    private int computeNumberOfLotto(int paymentAmount) {
        return paymentAmount / 1000;
    }

    @DisplayName("구매한 로또 개수만큼 로또 생성 테스트")
    @Test
    void createLottoTest() {
        RandomUtil randomUtil = Mockito.mock(RandomUtil.class);
        when(randomUtil.createSortedRandomNumbersInRange(anyInt(), anyInt(), anyInt())).thenReturn(LOTTO_NUMBER);

        Lottos lottos = new Lottos(SUCCESSFUL_PAYMENT_AMOUNT, randomUtil);
        assertThat(lottos).hasToString(lottosInfo());
    }

    private String lottosInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(NUMBER_OF_LOTTO_MESSAGE.getMessage(), computeNumberOfLotto(SUCCESSFUL_PAYMENT_AMOUNT)))
                .append('\n');
        IntStream.range(0, 3).forEach(i -> sb.append(LOTTO_NUMBER.toString()).append('\n'));

        return sb.toString();
    }
}