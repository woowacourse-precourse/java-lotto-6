package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

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

    @DisplayName("보너스번호 범위 유효성 검사가 성공합니다.")
    @ValueSource(strings = {"1", "45"})
    @ParameterizedTest
    void validateBonusNumberSuccessTest(String winningNumbers) {

        LottoReaderValidator.validateBonusNumber(winningNumbers);
    }

    @DisplayName("보너스번호 범위 유효성 검사가 실패합니다.")
    @ValueSource(strings = {"0", "46"})
    @ParameterizedTest
    void validateBonusNumberFailTest(String winningNumbers) {

        assertThatThrownBy(() -> LottoReaderValidator.validateBonusNumber(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스번호 중복 검사가 성공합니다.")
    @MethodSource("provideWinningNumbersAndBonusNumber")
    @ParameterizedTest
    void validateDuplicationWithWinningNumbersAndBonusNumberSuccessTest(
            List<Integer> winningNumbers, int bonusNumber
    ) {

        LottoReaderValidator.validateDuplicationWithWinningNumbersAndBonusNumber(
                winningNumbers, bonusNumber
        );
    }

    @DisplayName("보너스번호 중복 검사가 실패합니다.")
    @Test
    void validateDuplicationWithWinningNumbersAndBonusNumberFailTest() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;

        assertThatThrownBy(
                () -> LottoReaderValidator.validateDuplicationWithWinningNumbersAndBonusNumber(
                        winningNumbers, bonusNumber
                )
        ).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideWinningNumbersAndBonusNumber() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 7),
                Arguments.of(List.of(1, 2, 3, 4, 5, 45), 44)
        );
    }
}
