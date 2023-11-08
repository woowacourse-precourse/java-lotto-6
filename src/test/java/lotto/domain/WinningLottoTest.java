package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {

    @DisplayName("보너스 번호가 유효 범위를 벗어나면 예외가 발생한다.")
    @Test
    void validateBonusNumberRange() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new WinningLotto(winningNumbers, "46"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("보너스 번호가 당첨 번호 중 하나와 같으면 예외가 발생한다.")
    @Test
    void validateBonusNumberDuplication() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new WinningLotto(winningNumbers, "1"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("일치하는 번호의 개수를 반환한다.")
    @Test
    void countMatchedNumbers() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(winningNumbers, "7");
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        int count = winningLotto.countMatchedNumbers(userLotto);
        assertThat(count).isEqualTo(3);
    }


    @DisplayName("보너스 번호 일치 여부를 반환한다.")
    @Test
    void isMatchedBonusNumber() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(winningNumbers, "7");
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        assertThat(winningLotto.isMatchedBonusNumber(userLotto)).isTrue();
    }

    @DisplayName("보너스 번호가 숫자가 아니면 예외가 발생한다.")
    @Test
    void validateBonusNumberIsDigit() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new WinningLotto(winningNumbers, "abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
