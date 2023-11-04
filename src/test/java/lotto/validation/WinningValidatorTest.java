package lotto.validation;

import lotto.property.ErrorProperty;
import lotto.validation.validator.WinningValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class WinningValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"0","-1","46"})
    void 당첨_번호_입력_값_범위_벗어난_경우_테스트(String winning){
        assertThatThrownBy(()->{
                WinningValidator.winnerIsCorrectRange(winning);
            }
                ).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorProperty.WINNING_IS_NOT_CORRECTLY_RANGE.toString());
    }
}
