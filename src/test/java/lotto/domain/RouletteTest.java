package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RouletteTest {
    @Test
    @DisplayName("당첨번호와 구입한 로또를 비교하여 당첨결과를 조회한다.")
    public void matchWinningNumbersTest() throws Exception {
        // given
        List<Integer> winningNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 33;
        WinningLotto winningLotto = WinningLotto.of(winningNumbers, bonusNumber);
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 9, 33, 4));
        Lotto buyLotto = new Lotto(numbers);


        // when
        RouletteResult rouletteCompensation = winningLotto.matchWinningNumbers(winningLotto, buyLotto);

        // then
        Assertions.assertThat(rouletteCompensation.getPrice())
                .isEqualTo(RouletteResult.FOUR_SAME_WINNING_NUMBER.getPrice());
    }
}
