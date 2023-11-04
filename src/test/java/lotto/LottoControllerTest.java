package lotto;

import Controller.LottoController;
import Model.BonusNumber;
import Model.Enum.Prize;
import Model.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoControllerTest {
    private LottoController lottoController;

    @BeforeEach
    void beforeEach() {
        lottoController = new LottoController(
                7,
                List.of(
                        new Lotto(Arrays.asList(1, 7, 8, 9, 10, 11)),
                        new Lotto(Arrays.asList(1, 2, 7, 8, 9, 10)),
                        new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)),
                        new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8)),
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)),
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))
                ),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new BonusNumber(7)
        );
    }

    @DisplayName("로또 번호와 당첨 번호의 동일한 숫자 개수 세기")
    @Test
    void testCalculateMatchingNumbers() {
        List<Integer> actualCounts = lottoController.calculateMatchingNumbers();
        List<Integer> expectedCounts = List.of(1, 1, 1, 1, 1);

        assertThat(actualCounts).isEqualTo(expectedCounts);
    }

    @DisplayName("수익률 계산")
    @Test
    void testCalculateRateOfReturn() {
        List<Integer> matchingCounts = lottoController.calculateMatchingNumbers();

        double actualValue = lottoController.calculateRateOfReturn(matchingCounts);
        double expectedValue = 0.0;
        expectedValue += Prize.FIFTH_PRIZE.get() + Prize.FOURTH_PRIZE.get()
                + Prize.THIRD_PRIZE.get() + Prize.SECOND_PRIZE.get() + Prize.FIRST_PRIZE.get();
        expectedValue = expectedValue / (7 * 1000) * 100;

        double actualRateOfReturn = Math.round(actualValue * 10.0) / 10.0;
        double expectedRateOfReturn = Math.round(expectedValue * 10.0) / 10.0;

        assertThat(actualRateOfReturn).isEqualTo(expectedRateOfReturn);
    }

    @DisplayName("상금 계산")
    @Test
    void calculatePrize() {
        List<Integer> matchingCounts = List.of(1, 2, 3, 1, 1);

        long actualPrize = lottoController.calculatePrize(matchingCounts);
        long expectedPrize = 2034605000;

        assertThat(actualPrize).isEqualTo(expectedPrize);
    }
}
