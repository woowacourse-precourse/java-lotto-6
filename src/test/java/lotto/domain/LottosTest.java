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
    @DisplayName("로또의 개수를 알려준다.")
    @Test
    void getLottoCount() {
        // given
        Lotto firstLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto secondLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lottos lottos = new Lottos(List.of(firstLotto, secondLotto));
        int expectedResult = 2;
        // when, then
        assertThat(lottos.getLottoCount()).isEqualTo(expectedResult);
    }

    @DisplayName("당첨 결과를 만든다.")
    @Test
    void getLottosResult() {
        // given
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
        Map<Prize, Integer> expectedResult = new HashMap<>();
        expectedResult.put(Prize.FIRST, 1);
        expectedResult.put(Prize.SECOND, 1);
        expectedResult.put(Prize.THIRD, 1);
        expectedResult.put(Prize.FOURTH, 1);
        expectedResult.put(Prize.FIFTH, 2);
        // when
        Map<Prize, Integer> lottosResult = lottos.getLottosResult(prizeChecker);
        // then
        assertThat(lottosResult).isEqualTo(expectedResult);
    }

    @DisplayName("여러 개의 로또가 가진 로또 번호들을 요구사항에 맞는 문자열로 반환한다.")
    @Test
    void lottosToStringForPrinting() {
        // given
        Lotto firstLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto secondLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lottos lottos = new Lottos(List.of(firstLotto, secondLotto));
        String expectedResult = "[1, 2, 3, 4, 5, 6]\n[1, 2, 3, 4, 5, 7]";
        // when, then
        assertThat(lottos.toString()).isEqualTo(expectedResult);
    }
}