package lotto.validation;

import lotto.property.ErrorProperty;
import lotto.validation.validator.WinningValidator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class WinningValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"0","-1","46"})
    void 당첨_번호_입력_값_범위_벗어난_경우_테스트(String winning){
        assertThatThrownBy(()->{
                WinningValidator.winningCountIsOverOrUnder(winning);
            }
                ).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorProperty.WINNING_IS_NOT_CORRECTLY_RANGE.toString());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,7","1,2,3,4,5"})
    void 당첨_번호_입력_값_개수_초과_또는_미만_검증_로직_테스트(String winningNumbers){
        assertThatThrownBy(()->{
                WinningValidator.winningCountIsOverOrUnder(winningNumbers);
            }
                ).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorProperty.WINNING_COUNT_IS_OVER_OR_UNDER.toString());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,","1,2,,3,4,5,6"})
    void 당첨_번호_입력_값_양식_검증_로직_테스트(String winningNumbers){
        assertThatThrownBy(()->{
                WinningValidator.winningFormatIsCorrect(winningNumbers);
            }
                ).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorProperty.WINNING_FORMAT_IS_NOT_CORRECT.toString());
    }
}
