package lotto;

import java.util.ArrayList;
import java.util.Collections;
import lotto.model.Lotto;
import lotto.model.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoTest {
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또의 값 중 하나라도 범위가 벗어나면 예외가 발생한다.")
    @Test
    void createLottoByOverStandard() {
        assertThatThrownBy(() -> new Lotto(List.of(46, 5, 4, 3, 2, 1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또값을 비교해서 알맞은 랭크로 변환한다")
    @Test
    void determineRankTest() {
        Lotto winningLottoMatch3 = new Lotto(List.of(1,2,3,7,8,9));
        Lotto winningLottoMatch4 = new Lotto(List.of(1,2,3,4,8,9));
        Lotto winningLottoMatch5 = new Lotto(List.of(1,2,3,4,5,9));
        Lotto winningLottoMatch5AndBonus = new Lotto(List.of(1,2,3,4,5,9));
        Lotto winningLottoMatch6 = new Lotto(List.of(1,2,3,4,5,6));
        int bonusNumberNotMatch = 10;
        int bonusNumberMatch = 6;

        Rank rankMatch3 = lotto.determineRank(winningLottoMatch3,bonusNumberNotMatch);
        Rank rankMatch4 = lotto.determineRank(winningLottoMatch4,bonusNumberNotMatch);
        Rank rankMatch5 = lotto.determineRank(winningLottoMatch5,bonusNumberNotMatch);
        Rank rankMatch5AndBonus = lotto.determineRank(winningLottoMatch5AndBonus,bonusNumberMatch);
        Rank rankMatch6 = lotto.determineRank(winningLottoMatch6,bonusNumberNotMatch);

        assertEquals(Rank.MATCH_3, rankMatch3);
        assertEquals(Rank.MATCH_4, rankMatch4);
        assertEquals(Rank.MATCH_5, rankMatch5);
        assertEquals(Rank.MATCH_5_BONUS, rankMatch5AndBonus);
        assertEquals(Rank.MATCH_6, rankMatch6);

    }

    @DisplayName("로또에 해당 숫자가 있는지 확인하고 여부를 알려준다")
    @Test
    void containsTest() {
        assertTrue(lotto.contains(1));
        assertTrue(lotto.contains(2));
        assertTrue(lotto.contains(3));
        assertTrue(lotto.contains(4));
        assertTrue(lotto.contains(5));
        assertTrue(lotto.contains(6));
        assertFalse(lotto.contains(7));
        assertFalse(lotto.contains(8));
        assertFalse(lotto.contains(9));
    }

    @DisplayName("문자열로 적절히 변환한다")
    @Test
    void toStringTest() {
        String expected = "[1, 2, 3, 4, 5, 6]";
        assertEquals(expected, lotto.toString());
    }
}