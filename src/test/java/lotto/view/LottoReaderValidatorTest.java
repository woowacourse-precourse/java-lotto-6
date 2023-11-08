package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LottoReaderValidatorTest {

    @DisplayName("당첨 번호 유효성 검사가 성공합니다.")
    @ValueSource(strings = {"1,2,3,4,5,6", "1,2,3,4,5,45"})
    @ParameterizedTest
    void validateWinningNumbersSuccessTest(String winningNumbers) {

        LottoReaderValidator.validateWinningNumbers(winningNumbers);
    }

    @DisplayName("당첨 번호 유효성 검사가 예외를 발생시킵니다.")
    @ValueSource(strings = {"1,2,3,4,5,6,7", "1,2,3,4,5,6,30", "a,b,c,d,e,f,g", " , , , , ,  ,  "})
    @ParameterizedTest
    void validateWinningNumbersFailTest(String winningNumbers) {

        assertThatThrownBy(() -> LottoReaderValidator.validateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("지불 금액 유효성 검사가 성공합니다.")
    @ValueSource(strings = {"1000", "15000", "200000", "999999000"})
    @ParameterizedTest
    void validateMoneySuccessTest(String winningNumbers) {

        LottoReaderValidator.validateMoney(winningNumbers);
    }

    @DisplayName("지불 금액 유효성 검사가 실패합니다.")
    @ValueSource(strings = {"100", "-1000", "990", "999"})
    @ParameterizedTest
    void validateMoneyFailTest(String winningNumbers) {

        assertThatThrownBy(() -> LottoReaderValidator.validateMoney(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
