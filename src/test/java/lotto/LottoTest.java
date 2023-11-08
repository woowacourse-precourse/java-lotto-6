package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoBonusNumber;
import lotto.domain.LottoWinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName("로또 번호의 범위가 1~45가 아니면 예외가 발생한다.")
    @Test
    void createLottoByWrongRange() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호와 당첨 번호를 비교했을 때 일치하는 번호의 개수를 구한다.")
    @Test
    void countMatchingNumbers() {
        LottoWinningNumbers winningNumbers = new LottoWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto1 = new Lotto(List.of(4, 5, 6, 3, 2, 1));
        Lotto lotto2 = new Lotto(List.of(7, 8, 9, 1, 2, 3));

        int count1 = lotto1.countMatchingNumbers(winningNumbers);
        int count2 = lotto2.countMatchingNumbers(winningNumbers);

        assertThat(count1).isEqualTo(6);
        assertThat(count2).isEqualTo(3);
    }

    @DisplayName("로또 번호와 보너스 번호를 비교했을 때 일치하는 번호가 있는지 확인한다.")
    @Test
    void containsBonusNumber() {
        LottoBonusNumber bonusNumber = new LottoBonusNumber(1, List.of(2, 3, 4, 5, 6, 7));
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(2, 3, 4, 5, 6, 7));

        boolean result1 = lotto1.containsBonusNumber(bonusNumber);
        boolean result2 = lotto2.containsBonusNumber(bonusNumber);

        assertThat(result1).isTrue();
        assertThat(result2).isFalse();
    }
}