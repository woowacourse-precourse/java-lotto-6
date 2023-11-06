package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void generateRandomLotto() {
        Lotto lotto = Lotto.generateRandomLotto();
    }

    @Test
    void generateRandomLottos() {
        int number = 10;
        List<Lotto> lottos = Lotto.generateRandomLottos(number);
        assertThat(lottos.size()).isEqualTo(number);
    }

    @Test
    void matchWinningNumbers() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(1, 2, 3, 6, 7, 8);
        int bonusNumber = 4;

        LottoMatchResult result = lotto.matchWinningNumbers(winningNumbers, bonusNumber);
        assertThat(result).isEqualTo(LottoMatchResult.MATCHED_4);

        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        winningNumbers = List.of(1, 2, 3, 5, 6, 7);

        result = lotto.matchWinningNumbers(winningNumbers, bonusNumber);
        assertThat(result).isEqualTo(LottoMatchResult.MATCHED_5_WITH_BONUS);
    }
}