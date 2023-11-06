package lotto.validator;

import lotto.message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static lotto.constants.WinningInfo.*;
import static lotto.message.ErrorMessage.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ValidatorTest {

    private Validator validator = new Validator();

    @DisplayName("지불 금액 입력 시")
    @Nested
    class validateInputForPayment {

        @DisplayName("숫자 형식 & 양수 & 단위로 나누어 떨어지는 금액 입력 시 성공")
        @ValueSource(strings = {"1000", "2000", "3000", "10000"})
        @ParameterizedTest
        void success(String userInput) {
            assertDoesNotThrow(() -> validator.parseAndValidatePayment(userInput));
        }

        @DisplayName("숫자로 변환될 수 없는 형식으로 입력 시 실패")
        @ValueSource(strings = {"a", "1a", "123s", "금액"})
        @ParameterizedTest
        void failByNumberFormat(String userInput) {

            assertThatThrownBy(() -> validator.parseAndValidatePayment(userInput))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(NOT_NUMBER_ERROR_MESSAGE.toString());
        }

        @DisplayName("양수가 아닌 숫자를 입력 시 실패")
        @ValueSource(strings = {"-1", "-100", "0", "-12345600"})
        @ParameterizedTest
        void failByNonPositive(String userInput) {

            assertThatThrownBy(() -> validator.parseAndValidatePayment(userInput))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(NOT_POSITIVE_ERROR_MESSAGE.toString());
        }

        @DisplayName("지정된 단위로 나누어 떨어지지 않는 숫자 입력 시 실패")
        @ValueSource(strings = {"1234", "12340", "1001"})
        @ParameterizedTest
        void failByWrongUnit(String userInput) {

            assertThatThrownBy(() -> validator.parseAndValidatePayment(userInput))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(WRONG_UNIT_ERROR_MESSAGE.toString());
        }

    }

    @DisplayName("당첨 번호 입력 시")
    @Nested
    class validateInputForTargetNumbers {


        @DisplayName("숫자 형식 & 지정된 범위와 개수 & 중복되지 않는 수로 입력 시 성공")
        @ValueSource(strings = {"1,2,3,4,5,6", "2,3,4,5,6,45", "4,3,6,13,24,34"})
        @ParameterizedTest
        void success(String userInput) {
            assertDoesNotThrow(() -> validator.parseAndValidateTargetNumbers(userInput));
        }

        @DisplayName("입력된 숫자가 6개를 초과하거나 미만인 경우 실패")
        @ValueSource(strings = {"1,2,3,4,5,6,7", "1,2,3,4,5", "1,2,3"})
        @ParameterizedTest
        void failBySize(String userInput) {

            assertThatThrownBy(() -> validator.parseAndValidateTargetNumbers(userInput))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(WRONG_NUMBERS_SIZE_ERROR_MESSAGE.toString());
        }

        @DisplayName("숫자로 변환될 수 없는 형식으로 입력 시 실패")
        @ValueSource(strings = {"1,2,3,4,5,d", "2,3,4,5,6,금액", "잘못된입력"})
        @ParameterizedTest
        void failByNumberFormat(String userInput) {

            assertThatThrownBy(() -> validator.parseAndValidateTargetNumbers(userInput))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(NOT_NUMBER_ERROR_MESSAGE.toString());
        }

        @DisplayName("지정된 범위를 벗어나는 수를 포함하여 입력 시 실패")
        @ValueSource(strings = {"1,2,3,4,5,46", "0,3,4,5,6,45", "-1,2,3,4,5,6"})
        @ParameterizedTest
        void failByRange(String userInput) {

            assertThatThrownBy(() -> validator.parseAndValidateTargetNumbers(userInput))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(WRONG_RANGE_ERROR_MESSAGE.toString());
        }

        @DisplayName("중복되는 수를 포함하여 입력 시 실패")
        @ValueSource(strings = {"1,2,3,4,5,5", "1,2,3,4,5,4", "1,2,3,4,4,4"})
        @ParameterizedTest
        void failByDuplicate(String userInput) {

            assertThatThrownBy(() -> validator.parseAndValidateTargetNumbers(userInput))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(DUPLICATE_ERROR_MESSAGE.toString());
        }
    }

    @DisplayName("보너스 번호 입력 시")
    @Nested
    class validateInputForBonusNumber {


        @DisplayName("숫자 형식 & 지정된 범위로 입력 시 성공")
        @ValueSource(strings = {"1", "45", "25"})
        @ParameterizedTest
        void success(String userInput) {
            assertDoesNotThrow(() -> validator.parseAndValidateBonusNumber(userInput));
        }

        @DisplayName("숫자로 변환될 수 없는 형식으로 입력 시 실패")
        @ValueSource(strings = {"1d", "wrong", "잘못된입력"})
        @ParameterizedTest
        void failByNumberFormat(String userInput) {

            assertThatThrownBy(() -> validator.parseAndValidateBonusNumber(userInput))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(NOT_NUMBER_ERROR_MESSAGE.toString());
        }

        @DisplayName("지정된 범위를 벗어나는 수를 포함하여 입력 시 실패")
        @ValueSource(strings = {"46", "0", "-1"})
        @ParameterizedTest
        void failByRange(String userInput) {

            assertThatThrownBy(() -> validator.parseAndValidateBonusNumber(userInput))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(WRONG_RANGE_ERROR_MESSAGE.toString());
        }

        private static Stream<Arguments> failInputBonusNumberScenarios() {
            return Stream.of(
                    Arguments.of(List.of(1, 2, 3, 4, 5, 6), 1),
                    Arguments.of(List.of(1, 2, 3, 4, 5, 6), 2),
                    Arguments.of(List.of(1, 2, 3, 4, 5, 6), 3),
                    Arguments.of(List.of(1, 2, 3, 4, 5, 6), 4),
                    Arguments.of(List.of(1, 2, 3, 4, 5, 6), 5)
            );
        }

        @DisplayName("당첨 번호에 이미 존재하는 수를 입력 시 실패")
        @MethodSource("failInputBonusNumberScenarios")
        @ParameterizedTest
        void failByDuplicate(List<Integer> targetNumbers, int bonusNumber) {

            assertThatThrownBy(() -> validator.checkDuplicateBonusNumber(targetNumbers, bonusNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(DUPLICATE_BONUS_NUMBER_ERROR_MESSAGE.toString());
        }
    }


}