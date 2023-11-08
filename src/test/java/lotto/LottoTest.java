package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {

    private WinningNumbers winningNumbers;

    @BeforeEach
    public void setWinningNumbers() {
        winningNumbers = new WinningNumbers();
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

    // 아래에 추가 테스트 작성 가능
    @Test
    @DisplayName("숫자 6개가 일치하면 1등에 당첨된다.")
    public void testCheckFirstPrize() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        winningNumbers.setNumbers(List.of(1, 2, 3, 4, 5, 6));
        winningNumbers.setBonus(7);
        Prize result = lotto.check(winningNumbers);

        assertEquals(Prize.First, result);
    }

    @Test
    @DisplayName("숫자 5개가 일치하고 보너스 번호가 일치하면 2등에 당첨된다.")
    public void testCheckSecondPrize() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        winningNumbers.setNumbers(List.of(1, 2, 3, 4, 5, 7));
        winningNumbers.setBonus(6);
        Prize result = lotto.check(winningNumbers);

        assertEquals(Prize.Second, result);
    }

    @Test
    @DisplayName("숫자 5개가 일치하면 3등에 당첨된다.")
    public void testCheckThirdPrize() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        winningNumbers.setNumbers(List.of(1, 2, 3, 4, 5, 7));
        winningNumbers.setBonus(8);
        Prize result = lotto.check(winningNumbers);

        assertEquals(Prize.Third, result);
    }

    @Test
    @DisplayName("숫자 0,1,2개 일치하면 3등에 당첨된다.")
    public void testCheckNoPrize() {
        winningNumbers.setNumbers(List.of(1, 2, 12, 13, 14, 15));
        winningNumbers.setBonus(16);

        Lotto winTwoNum = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winOneNum = new Lotto(List.of(1, 3, 4, 5, 6, 7));
        Lotto none = new Lotto(List.of(21, 23, 24, 25, 26, 27));
        Prize resultWinTwoNum = winTwoNum.check(winningNumbers);
        Prize resultWinOneNum = winOneNum.check(winningNumbers);
        Prize resultNone = none.check(winningNumbers);

        assertEquals(Prize.None, resultWinTwoNum);
        assertEquals(Prize.None, resultWinOneNum);
        assertEquals(Prize.None, resultNone);
    }
}