package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class LottoTest {
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

    @DisplayName("로또 번호와 당첨 번호가 일치한 개수에 해당하는 값이 return 되어야 한다 ")
    @Test
    void checkMatchNumber() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumberSet winningNumberSet = new WinningNumberSet(
                new String[]{"1", "2", "3", "4", "5", "6"}, 7);
        int expectedCountMatch = 6;
        boolean expectedCheckBonus = false;
        int notExpectedCountMath = 1;
        boolean notExpectedCheckBonus = true;

        Score score = lotto.compareWinningNumbers(winningNumberSet);

        assertEquals(expectedCountMatch, score.getCountMatch());
        assertEquals(expectedCheckBonus, score.isCheckBonus());
        assertNotEquals(notExpectedCountMath, score.getCountMatch());
        assertNotEquals(notExpectedCheckBonus, score.isCheckBonus());
    }


}