package lotto.view;

import lotto.domain.Cash;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("입력 처리")
class InputViewTest extends IOTest{
    final InputView inputView = new InputView();


    @DisplayName("현금 생성 성공 테스트")
    @ParameterizedTest()
    @ValueSource(strings = {"1000", "2000", "3000", "4000", "5000"})
    void createCashByInputSuccessTest(String input) {
        assertDoesNotThrow(() -> {
            systemIn(input);
            inputView.InputCash();
        });
    }


    @DisplayName("현금 입력시 숫자 이외의 값을 입력한 경우 예외 발생")
    @ParameterizedTest()
    @ValueSource(strings = {"100f", "hello", "$%%", "40re", "ㅋㅋㅋ"})
    void createCashByNotNumberInputExceptionTest(String input) {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    systemIn(input);
                    inputView.InputCash();
                }
        );
    }

    @DisplayName("현금 입력시 공백을 입력한 경우 예외 발생")
    @ParameterizedTest()
    @ValueSource(strings = {" "})
    void createCashByBlankInputExceptionTest(String input) {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    systemIn(input);
                    inputView.InputCash();
                }
        );
    }

    @DisplayName("당첨 번호 생성 성공 테스트")
    @ParameterizedTest()
    @ValueSource(strings = {"1,2,3,4,5,6", "11,2,17,41,5,16", "1,2,33,4,42,6"})
    void createWinnerLottoByInputSuccessTest(String inputWinnerNumbers) {
        assertDoesNotThrow(() -> {
            systemIn(inputWinnerNumbers);
            inputView.inputWinnerNumbers();

        });
    }

    static Stream<Arguments> createWinnerLottoByInputSuccessDummy() {
        return Stream.of(
                Arguments.arguments(
                        "1,2,3,4,5,6",
                        "7"),
                Arguments.arguments(
                        "11,2,17,41,5,16",
                        "18"),
                Arguments.arguments(
                        "1,2,33,4,42,6",
                        "27")
        );
    }



}