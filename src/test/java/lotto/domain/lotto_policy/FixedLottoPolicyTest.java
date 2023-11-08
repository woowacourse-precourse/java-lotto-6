package lotto.domain.lotto_policy;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.lotto_prize.FixedLottoPrizeStandard;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FixedLottoPolicyTest {
    private FixedLottoWinningPolicy fixedLottoWinningPolicy;

    @DisplayName("당첨 결과를 올바르게 계산하는 지 검증한다.")
    @Test
    void calculateWinningResult() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 7;
        fixedLottoWinningPolicy = new FixedLottoWinningPolicy(bonusNumber);

        // when
        List<FixedLottoPrizeStandard> winningResult = fixedLottoWinningPolicy
                .getWinningResult(lottoNumbers, winningNumbers);

        // then
        assertThat(winningResult.contains(FixedLottoPrizeStandard.TOTAL_MATCH)).isTrue();
    }
}
