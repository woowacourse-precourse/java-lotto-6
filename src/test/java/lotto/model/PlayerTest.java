package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.List;
import lotto.util.RandomUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PlayerTest {
    private final int BONUS_NUMBER = 25;
    private final int PAYMENT_AMOUNT = 3000;
    private final double PROFIT_RATE = 66_666_833.3;
    private final List<Integer> WINNING_NUMBERS = List.of(1, 2, 3, 4, 5, 6);
    private final List<Integer> FIRST_LOTTO = List.of(1, 2, 3, 4, 5, 6);
    private final List<Integer> SECOND_LOTTO = List.of(1, 3, 4, 10, 25, 45);
    private final List<Integer> THIRD_LOTTO = List.of(8, 10, 25, 35, 39, 44);

    @Test
    @DisplayName("수익률을 구한다")
    void calculateProfitRateTest() {
        RandomUtil randomUtil = Mockito.mock(RandomUtil.class);

        when(randomUtil.createRandomNumbersInRange(anyInt(), anyInt(), anyInt())).thenReturn(FIRST_LOTTO)
                .thenReturn(SECOND_LOTTO).thenReturn(THIRD_LOTTO);
        Player player = new Player(PAYMENT_AMOUNT, randomUtil);
        
        double profitRate = player.calculateProfitRate(new WinningNumbers(WINNING_NUMBERS, BONUS_NUMBER));
        assertThat(String.format("%.1f", profitRate)).isEqualTo(String.format("%.1f", PROFIT_RATE));
    }
}