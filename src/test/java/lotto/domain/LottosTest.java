package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.wrapper.BonusNumber;
import lotto.service.PrizeChecker;
import lotto.utils.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @DisplayName("당첨 결과를 만든다.")
    @Test
    void getPrizeCounts() {
        // given
        Map<Prize, Integer> expectedLottosResult = new HashMap<>();
        expectedLottosResult.put(Prize.FIRST, 1);
        expectedLottosResult.put(Prize.SECOND, 1);
        expectedLottosResult.put(Prize.THIRD, 1);
        expectedLottosResult.put(Prize.FOURTH, 1);
        expectedLottosResult.put(Prize.FIFTH, 2);
        Lottos lottos = new Lottos(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                new Lotto(List.of(1, 2, 3, 4, 7, 8)),
                new Lotto(List.of(4, 5, 6, 7, 8, 9)),
                new Lotto(List.of(1, 2, 3, 7, 8, 9)),
                new Lotto(List.of(1, 2, 7, 8, 9, 10)),
                new Lotto(List.of(1, 7, 8, 9, 10, 11)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12))
        ));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7, winningLotto);
        PrizeChecker prizeChecker = new PrizeChecker(winningLotto, bonusNumber);
        // when
        Map<Prize, Integer> lottosResult = lottos.getLottosResult(prizeChecker);
        // then
        assertThat(lottosResult).isEqualTo(expectedLottosResult);
    }
}