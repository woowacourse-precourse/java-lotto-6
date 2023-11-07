package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {
    Player player;

    @BeforeEach
    void beforeEach() {
        player = new Player();
    }

    @Test
    @DisplayName("추첨 숫자와 비교하여 같은 숫자를 알맞게 반환해야 한다.")
    public void calculateWinningNumberTest() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        List<Integer> winningNumber = List.of(1,2,3,4,8,9);
        WinningNumbers winningNumbers = new WinningNumbers(winningNumber,5);
        //when
        int winningCount = winningNumbers.calculateWinningNumber(lotto);
        //then
        assertThat(winningCount).isEqualTo(4);
    }

    @Test
    @DisplayName("보너스 숫자와 비교하여 같은 숫자를 알맞게 반환해야 한다.")
    public void calculateBonusNumberTest() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        List<Integer> winningNumber = List.of(1,2,3,4,8,9);
        WinningNumbers winningNumbers = new WinningNumbers(winningNumber,5);
        //when
        int bonusCount = winningNumbers.calculateBonusNumber(lotto);
        //then
        assertThat(bonusCount).isEqualTo(1);
    }
}