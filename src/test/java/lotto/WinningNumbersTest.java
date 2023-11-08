package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {
    @DisplayName("보너스 번호와 당첨번호가 중복이 될 경우 에러 발생")
    @Test
    void duplicateByWinningNumbers() {
        assertThatThrownBy(() -> createWinningNumbers(List.of(1, 2, 3, 4, 5, 6), 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 로또들을 비교하여 등수를 계산한다. ")
    @Test
    void announceLottoRank() {
        WinningNumbers winningNumbers = createWinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
        List<Lotto> lottoes = createLottos(List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 7),
                List.of(1, 2, 3, 4, 5, 8),
                List.of(1, 2, 3, 4, 8, 9),
                List.of(1, 2, 3, 8, 9, 10)));

        List<Rank> result = winningNumbers.getRanks(lottoes);
        List<Rank> expected = List.of(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH, Rank.FIFTH);

        assertThat(result).isEqualTo(expected);
    }

    private WinningNumbers createWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        return new WinningNumbers(new Lotto(winningNumbers), bonusNumber);
    }

    private List<Lotto> createLottos(List<List<Integer>> numbers) {
        return numbers.stream()
                .map(Lotto::new)
                .toList();
    }
}