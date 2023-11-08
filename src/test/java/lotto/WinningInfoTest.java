package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WinningInfoTest {

    @Test
    void unmodifiableWinningNumbers() {
        WinningInfo winningInfo = new WinningInfo(List.of(1, 2, 3, 4, 5, 6), 7);
        List<Integer> winningNumbers = winningInfo.getWinningNumbers();

        Assertions.assertThatThrownBy(() -> winningNumbers.add(7))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void winningResult() {
        WinningInfo winningInfo = new WinningInfo(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(List.of(4, 5, 6, 7, 8, 9));

        Winnings winnings = winningInfo.check(lotto);

        Assertions.assertThat(winnings).isEqualTo(Winnings.FIFTH_PLACE);
    }
}
