package lotto.service;

import lotto.exception.InputDataNotNumberException;
import lotto.exception.LottoNumberIsOverRangeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {

    private InputValidator inputValidator;

    @BeforeEach
    void setUp() {
        inputValidator = new InputValidator();
    }

    @DisplayName("입력값에 숫자가 아닌 다른 값이 들어왔을 때 예외를 발생시킨다.")
    @Test
    void validateIsNotNumber() {
        Assertions.assertAll(
                () -> Assertions.assertThrows(InputDataNotNumberException.class,
                        () -> inputValidator.validateInputDataIsNumber("하이")),
                () -> Assertions.assertDoesNotThrow(() -> inputValidator.validateInputDataIsNumber("12"))
        );
    }

    @DisplayName("입력한 로또 번호가 1~45외의 숫자일 경우 예외를 발생시킨다")
    @Test
    void validateInputDataIsLottoRange(){
        Assertions.assertAll(
                () -> Assertions.assertThrows(LottoNumberIsOverRangeException.class,
                        () -> inputValidator.validateInputDataIsLottoRange(46)),
                () -> Assertions.assertThrows(LottoNumberIsOverRangeException.class, () -> inputValidator.validateInputDataIsLottoRange(0)),
                () -> Assertions.assertDoesNotThrow(() -> inputValidator.validateInputDataIsNumber("12"))
        );
    }
}
