package lotto.domain.lottery;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static lotto.exception.ErrorMessage.CONTAIN_WHITESPACE;
import static lotto.exception.ErrorMessage.REQUEST_NOT_INTEGER;
import static lotto.fixture.IntegerFixture.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("[Domain Layer] Parser")
class ParserTest {

    @Nested
    @DisplayName("[parseStringToInt] String Input을 Int로 파싱해서 리턴합니다.")
    class parseStringToInt {

        /**
         * Parser - parseStringToInt
         * 1. 이용 금액 입력에 대한 예외처리에 활용
         * 2. 보너스 번호 입력에 대한 예외 처리에 활용
         * <p>
         * parseStringToInt 예외처리
         * 1. 요청에 whiteSpace가 포함되어 있을 경우 예외처리
         * 2. Int형이 아니라 파싱 오류가 발생 할 경우 예외처리
         */

        @Test
        @DisplayName("[Success] 정상적인 인자로 파싱에 성공")
        void Should_Success_When_Valid() {
            // given
            final String validInputA = VALID_A.getInput();
            final String validInputB = VALID_B.getInput();
            final String validInputC = VALID_C.getInput();
            // when && then
            assertAll(
                    () -> assertDoesNotThrow(() -> Parser.parseStringToInt(validInputA)),
                    () -> assertDoesNotThrow(() -> Parser.parseStringToInt(validInputB)),
                    () -> assertDoesNotThrow(() -> Parser.parseStringToInt(validInputC))
            );
        }

        @Test
        @DisplayName("[Success] 문자열 내부에 공백을 포함해 예외처리")
        void Should_ThrowException_When_ContainWhiteSpace() {
            // given
            final String invalidInputA = CONTAIN_SPACE_A.getInput();
            final String invalidInputB = CONTAIN_SPACE_B.getInput();
            final String invalidInputC = CONTAIN_SPACE_C.getInput();
            // when && then
            assertAll(
                    () -> assertThatThrownBy(() ->
                            Parser.parseStringToInt(invalidInputA))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining(CONTAIN_WHITESPACE.getMessage()),
                    () -> assertThatThrownBy(() ->
                            Parser.parseStringToInt(invalidInputB))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining(CONTAIN_WHITESPACE.getMessage()),
                    () -> assertThatThrownBy(() ->
                            Parser.parseStringToInt(invalidInputC))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining(CONTAIN_WHITESPACE.getMessage())
            );
        }

        @Test
        @DisplayName("[Success] 문자열이 정수가 아니라 예외처리")
        void Should_ThrowException_When_NotInteger() {
            // given
            final String invalidInput = NOT_INTEGER.getInput();
            // when && then
            assertThatThrownBy(() ->
                    Parser.parseStringToInt(invalidInput))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(REQUEST_NOT_INTEGER.getMessage());
        }
    }
}
