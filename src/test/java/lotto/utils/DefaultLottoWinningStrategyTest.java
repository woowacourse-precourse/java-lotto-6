package lotto.utils;

import lotto.domain.Rank;
import lotto.domain.Result;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class DefaultLottoWinningStrategyTest {
    LottoWinningStrategy winningStrategy;

    @BeforeEach
    void beforeEach() {
        this.winningStrategy = new DefaultLottoWinningStrategy();
    }

    @DisplayName("1등 당첨 검증 테스트")
    @Test
    void winFirstRankTest() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusBall = 7;

        Result result = winningStrategy.determineResult(lottoNumbers, winningNumbers, bonusBall);

        assertThat(result.getRank())
                .isEqualTo(Rank.FIRST);
    }

    @DisplayName("2등 당첨 검증 테스트")
    @Test
    void winSecondRankTest() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 10);
        int bonusBall = 6;

        Result result = winningStrategy.determineResult(lottoNumbers, winningNumbers, bonusBall);

        assertThat(result.getRank())
                .isEqualTo(Rank.SECOND);
    }

}