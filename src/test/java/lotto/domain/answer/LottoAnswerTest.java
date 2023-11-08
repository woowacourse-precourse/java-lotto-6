package lotto.domain.answer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.domain.answer.check.WinningPolicy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoAnswerTest {

    private LottoAnswer lottoAnswer;

    @BeforeEach
    void setUp() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Integer bonus = 7;
        lottoAnswer = new LottoAnswer(lotto, bonus);
    }

    @Test
    @DisplayName("정책에 따라, 사용자의 로또번호를 비교 후, 등수와 등수의 빈도수를 구합니다.")
    void 정책에따른_로또번호비교() {
        // GIVEN
        Lotto lottoFirst = new Lotto(List.of(1, 2, 3, 4, 5, 6)); // 1등
        Lotto lottoSecond = new Lotto(List.of(1, 2, 3, 4, 5, 7)); // 2등
        Lotto lottoSecondAgain = new Lotto(List.of(1, 2, 3, 4, 5, 7)); // 2등
        Lotto lottoThird = new Lotto(List.of(1, 2, 3, 4, 5, 8)); // 3등
        User user = new User(List.of(lottoFirst, lottoSecond, lottoSecondAgain, lottoThird), 4);

        // WHEN
        Map<Integer, Integer> rankToCount = lottoAnswer.getRankToCount(WinningPolicy.getRank, user);

        // THEN
        assertEquals(1, rankToCount.get(1));
        assertEquals(2, rankToCount.get(2));
        assertEquals(1, rankToCount.get(3));
    }
}