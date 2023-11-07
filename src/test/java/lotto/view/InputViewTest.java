package lotto.view;

import lotto.domain.Cash;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("입력 처리")
class InputViewTest extends IOTest{
    private InputView inputView = new InputView();


    @DisplayName("현금 생성 성공 테스트")
    @ParameterizedTest()
    @ValueSource(strings = {"1000", "2000", "3000", "4000", "5000"})
    void createCashByInputSuccessTest(String input) {
        assertDoesNotThrow(() -> {
            systemIn(input);
            inputView.requestCash();
        });
    }


    @DisplayName("현금 입력시 숫자 이외의 값을 입력한 경우 예외 발생")
    @ParameterizedTest()
    @ValueSource(strings = {"100f", "hello", "$%%", "40re", "ㅋㅋㅋ"})
    void createCashByNotNumberInputExceptionTest(String input) {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    systemIn(input);
                    inputView.requestCash();
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
                    inputView.requestCash();
                }
        );
    }

    @DisplayName("입력한 당첨 번호에 숫자가 아닌 값이 있는 경우")
    @ParameterizedTest()
    @ValueSource(strings = {"1,2,3,4,5,z", "1,2,3,4,5,% ", "1,2,3,4,5,ㅎ ", "1,2,3,4,5,!",  "1,2,3,4,5,."})
    void createWinnerNumbersWithNotNumberExceptionTest(String input) {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    systemIn(input);
                    inputView.requestWinnerNumbers();
                }
        );
    }

    @DisplayName("당첨 번호 입력 형식을 준수하지 않은 경우")
    @ParameterizedTest()
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6", "1/2/3/4/5/6 ", "1-2-3-4-5-6", "1,2,3,4,5,6,", ",1,2,3,4,5,6"})
    void createWinnerNumbersWithWrongNumbersSizeExceptionTest(String input) {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    systemIn(input);
                    inputView.requestWinnerNumbers();
                }
        );
    }







}