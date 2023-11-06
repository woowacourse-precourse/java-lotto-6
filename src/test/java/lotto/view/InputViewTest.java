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
            inputView.inputCash();
        });
    }


    @DisplayName("현금 입력시 숫자 이외의 값을 입력한 경우 예외 발생")
    @ParameterizedTest()
    @ValueSource(strings = {"100f", "hello", "$%%", "40re", "ㅋㅋㅋ"})
    void createCashByNotNumberInputExceptionTest(String input) {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    systemIn(input);
                    inputView.inputCash();
                }
        );
    }

    @DisplayName("현금 입력시 공백을 입력한 경우 예외 발생")
    @ParameterizedTest()
    @ValueSource(strings = {" "})
    void createCashByBlankInputExceptionTest(String input) {
        assertThrows(IllegalStateException.class,
                () -> {
                    systemIn(input);
                    inputView.inputCash();
                }
        );
    }

    @DisplayName("당첨 번호 생성 성공 테스트")
    @ParameterizedTest()
    @ValueSource(strings = {"1,2,3,4,5,6", "11,2,17,41,5,16", "1,2,33,4,42,6"})
    void createWinnerNumbersByInputSuccessTest(String inputWinnerNumbers) {
        assertDoesNotThrow(() -> {
            systemIn(inputWinnerNumbers);
            inputView.inputWinnerNumbers();

        });
    }

    @DisplayName("당첨 번호 입력시 입력 형식을 준수하지 않은 경우 예외 발생")
    @ParameterizedTest()
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6", "1,,2,3,4,5,6", "11, 2,17,41,5,16", "1,2,ㅁ,4,42,6"})
    void createWinnerNumbersByWrongInputExceptionTest(String inputWrongWinnerNumbers) {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    systemIn(inputWrongWinnerNumbers);
                    inputView.inputWinnerNumbers();
                }
        );
    }

    @DisplayName("당첨 번호 입력시 공백을 입력한 경우 예외 발생")
    @ParameterizedTest()
    @ValueSource(strings = {" "})
    void createWinnerNumbersByBlankInputExceptionTest(String inputWrongWinnerNumbers) {
        assertThrows(IllegalStateException.class,
                () -> {
                    systemIn(inputWrongWinnerNumbers);
                    inputView.inputWinnerNumbers();
                }
        );
    }

    @DisplayName("당첨 번호 입력시 1~45 이외의 값 입력시 예외 발생")
    @ParameterizedTest()
    @ValueSource(strings = {"1,2,3,4,5,100", "0,2,17,41,5,16", "1,2,33,4,42,49"})
    void createWinnerNumbersByNumberOverRangeInputExceptionTest(String inputWrongWinnerNumbers) {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    systemIn(inputWrongWinnerNumbers);
                    inputView.inputWinnerNumbers();
                }
        );
    }

    @DisplayName("보너스 번호 생성 성공 테스트")
    @ParameterizedTest()
    @ValueSource(strings = {"11", "21", "23", "41", "15"})
    void createWinnerBonusNumberByInputSuccessTest(String inputBonusNumber) {
        assertDoesNotThrow(() -> {
            systemIn(inputBonusNumber);
            inputView.inputBonusNumber();
        });

    }

    @DisplayName("숫자 이외의 값 입력시 예외 발생")
    @ParameterizedTest()
    @ValueSource(strings = {"1z", "hi", "ㅋㅋ", "호호호", "15%"})
    void createWinnerBonusNumberByNotNumberInputSuccessTest(String inputWrongBonusNumber) {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    systemIn(inputWrongBonusNumber);
                    inputView.inputBonusNumber();
                }
        );

    }

    @DisplayName("1~45 이외의 값 입력시 예외 발생")
    @ParameterizedTest()
    @ValueSource(strings = {"0", "46", "99", "-1", "100"})
    void createWinnerBonusNumberByNumberOverRangeInputSuccessTest(String inputWrongBonusNumber) {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    systemIn(inputWrongBonusNumber);
                    inputView.inputBonusNumber();
                }
        );

    }

    @DisplayName("공백 입력시 예외 발생")
    @ParameterizedTest()
    @ValueSource(strings = {" "})
    void createWinnerBonusNumberByBlankInputSuccessTest(String inputWrongBonusNumber) {
        assertThrows(IllegalStateException.class,
                () -> {
                    systemIn(inputWrongBonusNumber);
                    inputView.inputBonusNumber();
                }
        );

    }




}