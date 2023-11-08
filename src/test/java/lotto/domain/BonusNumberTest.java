package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.DuplicatedNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {
    @DisplayName("당첨 숫자가 1보다 낮을 경우 예외가 발생한다.")
    @Test
    void validateUnder() {
        //given
        int underBonusNumber = 0;
        //when
        //then
        assertThatThrownBy(() -> {
            BonusNumber bonusNumber = new BonusNumber(underBonusNumber);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45사이의 숫자이어야 합니다.");
    }

    @DisplayName("당첨 숫자가 45보다 높을 경우 예외가 발생한다.")
    @Test
    void validateUpper() {
        //given
        int upperBonusNumber = 46;
        //when
        //then
        assertThatThrownBy(() -> {
            BonusNumber bonusNumber = new BonusNumber(upperBonusNumber);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45사이의 숫자이어야 합니다.");
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void createBonusNumberByDuplicateNumber() {
        //given
        BonusNumber bonusNumber = new BonusNumber(3);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        //when
        //then
        assertThatThrownBy(() -> {
            bonusNumber.validateBonusNumberDuplicatedByWinningNumbers(bonusNumber, winningNumbers);
        }).isInstanceOf(DuplicatedNumberException.class);
    }
}