package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.WinningLottoNumbers;
import lotto.service.util.LottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningLottoNumbersWithDuplicatedNumbers() {
        assertThatThrownBy(() -> WinningLottoNumbers.from(Lotto.from(List.of(1, 2, 3, 4, 5, 5))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 개수가 6개보다 많으면 예외가 발생한다.")
    @Test
    void createWinningLottoNumbersWithMoreThanSixNumbers() {
        assertThatThrownBy(() -> WinningLottoNumbers.from(Lotto.from(List.of(1, 2, 3, 4, 5, 6, 7, 8))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 개수가 6개보다 적으면 예외가 발생한다.")
    @Test
    void createWinningLottoNumbersWithLessThanSixNumbers() {
        assertThatThrownBy(() -> WinningLottoNumbers.from(Lotto.from(List.of(1, 2, 3))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 값이 1~45의 범위에 있지 않은 경우 예외가 발생한다.")
    @Test
    void createWinningLottoNumberWithNumbersNotInAppropriateRange() {
        assertThatThrownBy(() -> WinningLottoNumbers.from(Lotto.from(List.of(1, 2, 40, 50, 22, 80))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 기존 당첨번호와 겹치면 예외가 발생한다.")
    @Test
    void createBonusNumberDuplicatedWithWinningLottoNumbers() {
        // given
        WinningLottoNumbers winningLottoNumbers = WinningLottoNumbers.from(LottoGenerator.generateLotto());

        // when
        int bonusNumber = winningLottoNumbers.getWinningLottoNumbers().get(0).getNumber();

        // then
        assertThatThrownBy(() -> BonusNumber.of(bonusNumber, winningLottoNumbers.getWinningLottoNumbers()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 값이 1~45의 범위에 있지 않은 경우 예외가 발생한다.")
    @Test
    void createBonusNumberWithNumberNotInAppropriateRange() {
        assertThatThrownBy(() -> BonusNumber.from(50))
                .isInstanceOf(IllegalArgumentException.class);
    }
}