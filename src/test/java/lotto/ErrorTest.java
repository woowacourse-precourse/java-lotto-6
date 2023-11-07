package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.Error.ErrorType;
import org.junit.jupiter.api.Test;

class ErrorTest {
    @Test
    void invalidAmountErrorTest(){
        assertThatThrownBy(() -> Error.errorMessage(ErrorType.INVALID_AMOUNT))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void invalidInputTypeErrorTest(){
        assertThatThrownBy(() -> Error.errorMessage(ErrorType.INVALID_INPUT_TYPE))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void invalidLottoInputErrorTest(){
        assertThatThrownBy(() -> Error.errorMessage(ErrorType.INVALID_LOTTO_INPUT))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void duplicationErrorTest(){
        assertThatThrownBy(() -> Error.errorMessage(ErrorType.DUPLICATION))
                .isInstanceOf(IllegalArgumentException.class);
    }
}