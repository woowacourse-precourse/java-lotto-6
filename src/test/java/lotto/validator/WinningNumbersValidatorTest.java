package lotto.validator;

import lotto.model.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static lotto.message.ErrorMessage.EXIST_DUPLICATE;
import static lotto.validator.WinningNumbersValidator.validateBonusNumberInWinningNumbers;

class WinningNumbersValidatorTest {
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6})
    @DisplayName("입력 lotto 번호와 bonus 번호가 중복되면 예외가 발생한다.")
    public void DuplicateTest(int bonusWinningNumbers) throws Exception{

        Lotto lottoWinningNumbers = new Lotto(List.of(1,2,3,4,5,6));

        Assertions.assertThatThrownBy(()-> validateBonusNumberInWinningNumbers(lottoWinningNumbers,bonusWinningNumbers)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EXIST_DUPLICATE.getMessage());
    }
}