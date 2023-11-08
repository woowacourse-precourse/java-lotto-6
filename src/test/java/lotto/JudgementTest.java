package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class JudgementTest {
    Judgement judgement = new Judgement();
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("당첨숫자와 난수와 일치하는 수가 6개인지 테스트")
    @Test
    void 일치_숫자_6개_테스트() {
        List<Integer> winNumber = new ArrayList(Arrays.asList(1, 2, 3, 4, 5, 6));
        Set<Integer> commonSET = judgement.getCommonNumber(winNumber, lotto.getNumbers());
        Assertions.assertThat(commonSET.size()).isEqualTo(MatchCount.FIRST.getCount());
    }

    @DisplayName("당첨숫자와 난수와 일치하는 수가 5개인지 테스트")
    @Test
    void 일치_숫자_5개_테스트() {
        List<Integer> winNumber = new ArrayList(Arrays.asList(1, 2, 3, 4, 5, 16));
        Set<Integer> commonSET = judgement.getCommonNumber(winNumber, lotto.getNumbers());
        Assertions.assertThat(commonSET.size()).isEqualTo(MatchCount.THIRD.getCount());
    }

    @DisplayName("5개의 숫자일치와 보너스 번호가 일치해서 2등 상금 유무 테스트")
    @Test
    void 보너스_번호_일치_테스트() {
        List<Integer> winNumber = new ArrayList(Arrays.asList(1, 2, 3, 4, 5, 16));
        int bonusNumber = 6;
        Set<Integer> commonSET = judgement.getCommonNumber(winNumber, lotto.getNumbers());
        boolean hasBonus = lotto.getNumbers().contains(bonusNumber);
        int index = judgement.getResultIndex(commonSET.size(), hasBonus);
        Assertions.assertThat(MatchCount.SECOND.getIndex()).isEqualTo(index);
    }
}