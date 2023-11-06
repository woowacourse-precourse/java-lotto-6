package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.wrapper.LottoNumber;
import lotto.service.PrizeChecker;
import lotto.utils.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosManagerTest {

    @DisplayName("당첨 결과를 바탕으로 접수처를 만들어낸다.")
    @Test
    void getPrizeCounts() {
        // given
        Map<Prize, Integer> expectedPrizeCounts = new HashMap<>();
        expectedPrizeCounts.put(Prize.FIRST, 1);
        expectedPrizeCounts.put(Prize.SECOND, 1);
        expectedPrizeCounts.put(Prize.THIRD, 1);
        expectedPrizeCounts.put(Prize.FOURTH, 1);
        expectedPrizeCounts.put(Prize.FIFTH, 2);
        PrizeReception expectedPrizeReception = new PrizeReception(expectedPrizeCounts);
        LottosManager lottosManager = new LottosManager(List.of(
                new Lotto(List.of(1,2,3,4,5,6)),
                new Lotto(List.of(1,2,3,4,5,7)),
                new Lotto(List.of(1,2,3,4,5,8)),
                new Lotto(List.of(1,2,3,4,7,8)),
                new Lotto(List.of(4,5,6,7,8,9)),
                new Lotto(List.of(1,2,3,7,8,9)),
                new Lotto(List.of(1,2,7,8,9,10)),
                new Lotto(List.of(1,7,8,9,10,11)),
                new Lotto(List.of(7,8,9,10,11,12))
        ));
        Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,6));
        LottoNumber bonusNumber = new LottoNumber(7);
        PrizeChecker prizeChecker = new PrizeChecker(winningLotto, bonusNumber);
        // when
        PrizeReception prizeReception = lottosManager.getPrizeReception(prizeChecker);
        // then
        assertThat(prizeReception.toString()).isEqualTo("1,1,1,1,2");
    }
}