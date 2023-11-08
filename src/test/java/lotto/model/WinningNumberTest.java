package lotto.model;

import static lotto.common.ExceptionMessage.ERROR_MAIN_AND_BONUS_NUMBERS_DUPLICATE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumberTest {
    @DisplayName("메인 번호와 보너스 번호가 서로 다를 때 WinningNumbers 인스턴스를 생성한다.")
    @Test
    void createWinningNumbersFromUniqueNumbers() {
        MainNumbers mainNumbers = MainNumbers.from(List.of("1", "2", "3", "4", "5", "6"));
        BonusNumber bonusNumber = BonusNumber.from("7");

        WinningNumbers winningNumbers = WinningNumbers.of(mainNumbers, bonusNumber);

        assertThat(winningNumbers).isNotNull();
        assertThat(winningNumbers.getMainNumbers()).isEqualTo(mainNumbers);
        assertThat(winningNumbers.getBonusNumber()).isEqualTo(bonusNumber);
    }

    @DisplayName("메인 번호와 보너스 번호가 중복될 경우 예외를 발생 시킨다.")
    @Test
    void throwExceptionWhenBonusNumberIsDuplicatedWithMainNumbers() {
        MainNumbers mainNumbers = MainNumbers.from(List.of("1", "2", "3", "4", "5", "6"));
        BonusNumber bonusNumber = BonusNumber.from("6");

        assertThatThrownBy(() -> WinningNumbers.of(mainNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MAIN_AND_BONUS_NUMBERS_DUPLICATE);
    }
}
