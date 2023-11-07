package lotto.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumValidatorTest {

    private static final String ERROR = "[ERROR]";
    private static final String NOT_NUMBER_ERROR_MESSAGE = "숫자만 입력해 주세요.";
    private static final String RANGE_OVER_MESSAGE = "1~45사이의 번호를 입력해 주세요.";
    private static final String NULL_ERROR_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String DUPLICATE_ERROR_MESSAGE = "당첨 숫자들과 다른 숫자를 입력해 주세요.";
    private final List<Integer> input = List.of(1, 2, 3, 4, 5, 6);
    private BonusNumValidator bonusNumValidator;

    @Test
    @DisplayName("보너스 숫자 미입력 시 예외 처리")
    void isNull(){
        String bonusNum = "";
        assertThatThrownBy(() -> bonusNumValidator = new BonusNumValidator(bonusNum, input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR+NULL_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("보너스 숫자 숫자 외 입력 시 예외 처리")
    void isNumber(){
        String bonusNum = "asd";
        assertThatThrownBy(() -> bonusNumValidator = new BonusNumValidator(bonusNum, input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR+NOT_NUMBER_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("보너스 숫자의 범위가 1이상 45이하가 아닐 시 예외 처리")
    void isRangeOver(){
        String bonusNum = "49";
        assertThatThrownBy(() -> bonusNumValidator = new BonusNumValidator(bonusNum, input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR+RANGE_OVER_MESSAGE);
    }

    @Test
    @DisplayName("보너스 숫자가 당첨 번호와 중복일 시 예외 처리")
    void isDuplicate(){
        String bonusNum = "6";
        assertThatThrownBy(() -> bonusNumValidator = new BonusNumValidator(bonusNum, input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR+DUPLICATE_ERROR_MESSAGE);
    }
}
