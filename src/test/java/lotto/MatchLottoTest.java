package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

public class MatchLottoTest {
    
        @Test
        @DisplayName("당첨번호와 로또번호가 얼마나 맞는지 테스트")
        void numberMatchingTest() {
                assertEquals(6, MatchLotto.isNumbersMatching(new Lotto(List.of(1, 2, 3, 4, 5, 6)), List.of(1, 2, 3, 4, 5, 6)));
                assertEquals(1, MatchLotto.isNumbersMatching(new Lotto(List.of(45, 44, 43, 42, 41, 40)), List.of(1, 21, 23, 38, 5, 45)));
                assertEquals(3, MatchLotto.isNumbersMatching(new Lotto(List.of(45, 31, 43, 12, 27, 42)), List.of(1, 31, 42, 41, 5, 45)));
        }

        @Test
        @DisplayName("당첨번호와 로또번호가 맞는지 테스트")
        void bonusNumberMatchingTest() {
                assertEquals(getClass(), getClass());
                assertTrue(MatchLotto.isBonusNumbersMatching(2, List.of(31,21,43,2,11,34)));
                assertFalse(MatchLotto.isBonusNumbersMatching(1, List.of(31,21,43,2,11,34)));
        }
}
