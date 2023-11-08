package lotto.View.InputValidator;

import lotto.View.InputValidator.BudgetInputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.Constants.BudgetConstants.MAXIMUM_BUDGET;
import static lotto.Message.InputValidatorPrompt.ASK_BUDGET_NUMBER_IN_RIGHT_FORMAT;
import static lotto.Message.InputValidatorPrompt.ASK_BUDGET_WITH_THOUSANDS_INCREMENT;
import static lotto.Message.InputValidatorPrompt.ASK_MORE_THAN_MINIMUM;
import static lotto.Message.InputValidatorPrompt.ASK_NO_EMPTY_INPUT;
import static lotto.Message.InputValidatorPrompt.ASK_NO_WHITE_SPACE;
import static lotto.Message.InputValidatorPrompt.ASK_POSITIVE_NUMBER;
import static org.assertj.core.api.Assertions.*;

public class BudgetInputValidatorTest {

    BudgetInputValidator validator = new BudgetInputValidator();

    @ParameterizedTest
    @ValueSource(strings = {"*8000", "eight", "\n8000", "200000000000" })
    @DisplayName("특수문자, 이스케이프코드, 문자, 10억 초과 금액 입력 예외처리 테스트")
    public void 로또_숫자_구입_금액_예외처리(String userInput){
        assertThatThrownBy(
                () -> {
                    validator.validate(userInput);
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(ASK_BUDGET_NUMBER_IN_RIGHT_FORMAT.getMessage(), MAXIMUM_BUDGET.getPrice()));
    }

    @Test
    @DisplayName("빈값 입력 예외처리 테스트")
    public void 빈값_입력_예외처리(){
        assertThatThrownBy(
                () -> {
                    validator.validate("");
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ASK_NO_EMPTY_INPUT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {" 8000", " ", "8000 "})
    @DisplayName("공백 입력 예외처리 테스트")
    public void 공백_입력_예외처리(String userInput){
        assertThatThrownBy(
                () -> {
                    validator.validate(userInput);
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ASK_NO_WHITE_SPACE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1"})
    @DisplayName("0값, 음수 입력 예외처리 테스트")
    public void 영값_음수_입력_예외처리(String userInput){
        assertThatThrownBy(
                () -> {
                    validator.validate(userInput);
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ASK_POSITIVE_NUMBER.getMessage());
    }

    @Test
    @DisplayName("최소 입력보다 적게 입력했을 경우 예외처리 테스트")
    public void 최소_금액_미안_입력_예외처리(){
        assertThatThrownBy(
                () -> {
                    validator.validate("100");
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ASK_MORE_THAN_MINIMUM.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1230", "13449"})
    @DisplayName("1000의 자리 수가 아닌 입력 예외처리 테스트")
    public void 예산_단위_미준수_예외처리(String userInput){
        assertThatThrownBy(
                () -> {
                    validator.validate(userInput);
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ASK_BUDGET_WITH_THOUSANDS_INCREMENT.getMessage());
    }
}
