package lotto.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {

    private String ERROR = "[ERROR]";
    private static final String NULL_ERROR_MESSAGE = "금액을 입력해 주세요.";
    private static final String NOT_NUMBER_ERROR_MESSAGE = "숫자만 입력해 주세요.";
    private static final String BLANK_ERROR_MESSAGE = "공백 없이 입력해 주세요.";
    private static final String DIVISION_ERROR_MESSAGE = "1,000 단위로 입력해 주세요.";
    private static final String DUPLICATE_ERROR_MESSAGE = "중복된 숫자를 적으면 안 됩니다.";
    private static final String NOT_BLANK_ERROR_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String SIZE_OVER_MESSAGE = "6개의 번호를 입력해 주세요.";
    private static final String RANGE_OVER_MESSAGE = "1~45사이의 번호를 입력해 주세요.";
    private static final String UNDER_1000_MESSAGE = "1,000 이상으로 입력해 주세요.";
    private MoneyValidator inputMoneyValidator;
    private WinningNumValidator winningNumValidator;

    @Test
    @DisplayName("구입 금액 값이 없을 시 예외 처리")
    void isNull() {
        String input = "";
        assertThatThrownBy(() -> inputMoneyValidator = new MoneyValidator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR + NULL_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("구입 금액 값에 공백이 있을 시 예외 처리")
    void isHaveBlank() {
        String input = "ad sf";
        assertThatThrownBy(() -> inputMoneyValidator = new MoneyValidator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR + BLANK_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("구입 금액 값이 숫자가 아닐 시 예외 처리")
    void isNumber() {
        String input = "adsf";
        assertThatThrownBy(() -> inputMoneyValidator = new MoneyValidator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR + NOT_NUMBER_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("구입 금액 값 1000 미만 예외 처리")
    void isUnder1000() {
        String input = "999";
        assertThatThrownBy(() -> inputMoneyValidator = new MoneyValidator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR + UNDER_1000_MESSAGE);
    }

    @Test
    @DisplayName("구입 금액 값이 1000으로 안 나뉘어 지면 예외 처리")
    void isDivision1000() {
        String input = "1001";
        assertThatThrownBy(() -> inputMoneyValidator = new MoneyValidator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR + DIVISION_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("당첨 번호 미입력 시 예외 처리")
    void isNull_Winning() {
        String input = "";
        assertThatThrownBy(() -> winningNumValidator = new WinningNumValidator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR + NOT_BLANK_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("당첨 번호에 문자 입력 시 예외 처리")
    void isNumber_Winning() {
        String input = "1,2,3,a,5";
        assertThatThrownBy(() -> winningNumValidator = new WinningNumValidator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR + NOT_NUMBER_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("당첨 번호 갯수가 6개를 초과하면 예외 처리")
    void isSizeOver_Winning() {
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6, 7);
        assertThatThrownBy(() -> winningNumValidator = new WinningNumValidator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR + SIZE_OVER_MESSAGE);
    }

    @Test
    @DisplayName("당첨 번호 갯수가 6개에 미달하면 예외 처리")
    void isSizeUnder_Winning() {
        List<Integer> input = List.of(1, 2, 3, 4, 5);
        assertThatThrownBy(() -> winningNumValidator = new WinningNumValidator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR + SIZE_OVER_MESSAGE);
    }

    @Test
    @DisplayName("당첨 번호에 중복이 있을 시 예외 처리")
    void isDuplicate_Winning() {
        List<Integer> input = List.of(1, 1, 3, 4, 5, 6);
        assertThatThrownBy(() -> winningNumValidator = new WinningNumValidator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR + DUPLICATE_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("당첨 번호가 1이상 45이하가 아닐 시 예외 처리")
    void isRangeOver_Winning() {
        List<Integer> input = List.of(1, 49, 3, 4, 5, 6);
        assertThatThrownBy(() -> winningNumValidator = new WinningNumValidator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR + RANGE_OVER_MESSAGE);
    }

}
