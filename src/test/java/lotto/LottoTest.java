package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    // 아래에 추가 테스트 작성 가능
    @Test
    public void testCheckFirstPrize() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6", "7");

        Prize result = lotto.check(winningNumbers);

        assertEquals(Prize.First, result);
    }

    @Test
    public void testCheckSecondPrize() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,7", "6");

        Prize result = lotto.check(winningNumbers);

        assertEquals(Prize.Second, result);
    }

    @Test
    public void testCheckThirdPrize() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,7", "8");

        Prize result = lotto.check(winningNumbers);

        assertEquals(Prize.Third, result);
    }

    // Add more test cases for other prize levels...

    @Test
    public void testCheckNoPrize() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers("7,8,9,10,11,12", "13");

        Prize result = lotto.check(winningNumbers);

        assertEquals(Prize.None, result);
    }
}