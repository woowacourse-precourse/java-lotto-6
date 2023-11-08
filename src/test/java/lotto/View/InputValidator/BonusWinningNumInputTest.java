package lotto.View.InputValidator;

import static lotto.Message.InputValidatorPrompt.ASK_BONUS_WINNING_NUM_NOT_DUPLICATE_WITH_WINNING_NUM;
import static lotto.Message.InputValidatorPrompt.ASK_NO_EMPTY_INPUT;
import static lotto.Message.InputValidatorPrompt.ASK_NO_WHITE_SPACE;
import static lotto.Message.InputValidatorPrompt.ASK_WINNING_NUM_IN_NUMBER;
import static lotto.Message.InputValidatorPrompt.ASK_WINNING_NUM_IN_VALID_RANGE;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import lotto.View.InputValidator.BonusWinningNumValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusWinningNumInputTest {

    BonusWinningNumValidator validator = new BonusWinningNumValidator();
    List<Integer> winningNumEx = Arrays.asList(1, 2, 3, 4, 5, 6);

    @ParameterizedTest
    @ValueSource(strings = {"*8", "eight", "\n8"})
    @DisplayName("특수문자, 이스케이프코드, 문자 입력 예외처리 테스트")
    public void 숫자_외_입력_예외처리(String userInput){
        assertThatThrownBy(
                () -> {
                    validator.validate(userInput, winningNumEx);
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ASK_WINNING_NUM_IN_NUMBER.getMessage());
    }

    @Test
    @DisplayName("빈값 입력 예외처리 테스트")
    public void 빈값_입력_예외처리(){
        assertThatThrownBy(
                () -> {
                    validator.validate("", winningNumEx);
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ASK_NO_EMPTY_INPUT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {" 8", " ", "8 "})
    @DisplayName("공백 입력 예외처리 테스트")
    public void 공백_입력_예외처리(String userInput){
        assertThatThrownBy(
                () -> {
                    validator.validate(userInput, winningNumEx);
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ASK_NO_WHITE_SPACE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "46"})
    @DisplayName("유효 로또 당첨번호 범위 외 숫자 입력 예외 처리")
    public void 유효_로또_당첨번호_범위_외_입력_예외_처리(String userInput){
        assertThatThrownBy(
                () -> {
                    validator.validate(userInput, winningNumEx);
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ASK_WINNING_NUM_IN_VALID_RANGE.getMessage());
    }

    @Test
    @DisplayName("당첨 번호와 중복 번호 입력시 예외 처리")
    public void 당첨_번호와_중복_입력_예외_처리(){
        assertThatThrownBy(
                () -> {
                    validator.validate("1", winningNumEx);
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ASK_BONUS_WINNING_NUM_NOT_DUPLICATE_WITH_WINNING_NUM.getMessage());
    }
}
