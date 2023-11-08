package lotto.domain;

import lotto.domain.lottery.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.domain.constants.LottoConstraint.*;
import static org.assertj.core.api.Assertions.assertThat;

class LotteryMessageBuilderTest {
    private LotteryMessageBuilder lotteryMessageBuilder;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        lotteryMessageBuilder = new LotteryMessageBuilder();
    }

    @DisplayName("구매한 로또의 개수와 각 로또 번호를 출력한다.")
    @Test
    void returnLottoList() {
        // Given
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12))
        );
        // When
        String expectedMessage = "[1, 2, 3, 4, 5, 6]\n[7, 8, 9, 10, 11, 12]\n";
        String actualMessage = lotteryMessageBuilder.returnLottoList(lottos);

        // Then
        assertThat(actualMessage).isEqualTo(expectedMessage);
    }

    @DisplayName("로또 당첨 통계를 출력한다.")
    @Test
    void returnWinningLottoList() {
        // Given
        Map<Integer, Integer> winningStats = new HashMap<>();
        winningStats.put(5, 1);
        winningStats.put(4, 0);
        winningStats.put(3, 0);
        winningStats.put(2, 0);
        winningStats.put(1, 0);

        Computer.rewards = new int[]{
                FIRST_REWARD.getValue(),
                SECOND_REWARD.getValue(),
                THIRD_REWARD.getValue(),
                FOURTH_REWARD.getValue(),
                FIFTH_REWARD.getValue()
        };
        Computer.rateOfProfit = "62.5";

        // When
        String result = lotteryMessageBuilder.returnWinningLottoList(winningStats);

        // Then
        assertThat(result).contains(
                "3개 일치 (5,000원) - 1개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 0개",
                "총 수익률은 62.5%입니다."
        );
    }
}