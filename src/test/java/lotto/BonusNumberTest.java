package lotto;

import lotto.domain.BonusNumber;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class BonusNumberTest { @DisplayName("유효한 보너스 번호를 입력했을 때 해당 번호를 반환한다.")
@Test
void validBonusNumberTest() {
    List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    int bonusNumber = BonusNumber.bonusNumber("7", winningNumbers);
    assertThat(bonusNumber).isEqualTo(7);
}

    @DisplayName("1부터 45까지 범위를 벗어난 보너스 번호 입력 시 예외를 던진다.")
    @Test
    void invalidRangeBonusNumberTest() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThatExceptionOfType(LottoException.class)
                .isThrownBy(() -> BonusNumber.bonusNumber("50", winningNumbers))
                .withMessage(ErrorMessage.INVALID_RANGE.getMessage());
    }

    @DisplayName("당첨 번호와 중복된 보너스 번호 입력 시 예외를 던진다.")
    @Test
    void duplicateBonusNumberTest() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThatExceptionOfType(LottoException.class)
                .isThrownBy(() -> BonusNumber.bonusNumber("6", winningNumbers))
                .withMessage(ErrorMessage.DUPLICATE_BONUS_NUMBER.getMessage());
    }

}
