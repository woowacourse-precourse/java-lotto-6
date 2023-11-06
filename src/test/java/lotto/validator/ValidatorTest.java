package lotto.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;


class ValidatorTest {

    @Nested
    @DisplayName("Validator.purchaseAmount 테스트")
    class purchaseAmountTests {
        @DisplayName("구입 금액이 유효할 경우 에러가 발생하지 않는다.")
        @ParameterizedTest
        @ValueSource(strings = {"1000","2000","50000","100000"})
        void 유효한_구입금액_입력값_테스트(String input) {
            assertThatCode(() -> Validator.purchaseAmount(input))
                    .doesNotThrowAnyException();
        }

        @DisplayName("입력값에 따라 설정한 예외 메시지와 예외를 발생시킨다.")
        @ParameterizedTest
        @CsvSource(value = {
                " :정수만 입력이 가능합니다.",
                "bab2 :정수만 입력이 가능합니다.",
                "0:최소 구매 금액은 1000원 입니다.",
                "800:최소 구매 금액은 1000원 입니다.",
                "-800:최소 구매 금액은 1000원 입니다.",
                "2100:1000원 단위로만 입력이 가능합니다.",},delimiter = ':')
        void 유효하지_않은_구입금액_입력값_테스트(String input,String expectedErrorMessage) {
            assertThatThrownBy(() -> Validator.purchaseAmount(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(expectedErrorMessage);
        }
    }

    @Nested
    @DisplayName("Validator.winningNumbers 테스트")
    class winningNumbersTests {
        @DisplayName("당첨 번호가 유효할 경우 예외가 발생하지 않는다.")
        @ParameterizedTest
        @ValueSource(strings = {"1,2,3,4,5,6","12,13,1,7,5,33","5,7,9,21,33,45","1,45,22,2,7,8"})
        void 유효한_당첨번호_입력값_테스트(String inputWinningNumbers) {
            String[] winningNumbers = inputWinningNumbers.split(",");
            assertThatCode(() -> Validator.winningNumbers(winningNumbers))
                    .doesNotThrowAnyException();
        }

        @DisplayName("입력값에 따라 설정한 예외 메시지와 예외를 발생시킨다.")
        @ParameterizedTest
        @CsvSource(value = {
                "1,2,3,4,5,6,7 : ,로 구분하여 총 6개의 숫자를 입력해주세요.",
                "1,2,3,a,5,6 : 정수만 입력이 가능합니다.",
                "1,2,3, ,5,6 : 정수만 입력이 가능합니다.",
                "1,2,3,4,5,50 : 1~45 범위의 정수만 입력 가능합니다.",
                "0,2,3,4,5,11 : 1~45 범위의 정수만 입력 가능합니다.",
                "-7,2,3,4,5,11 : 1~45 범위의 정수만 입력 가능합니다.",
                "1,2,3,4,1,5 : 중복된 값이 존재합니다.",
        },delimiter = ':')
        void 유효하지_않은_당첨번호_입력값_테스트(String inputWinningNumbers,String expectedErrorMessage) {
            String[] winningNumbers = inputWinningNumbers.split(",");
            assertThatThrownBy(() -> Validator.winningNumbers(winningNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(expectedErrorMessage);
        }
    }
}