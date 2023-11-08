package lotto.View.InputValidator;


import static lotto.Message.InputValidatorPrompt.ASK_NO_EMPTY_INPUT;
import static lotto.Message.InputValidatorPrompt.ASK_NO_WHITE_SPACE;
import static lotto.Message.InputValidatorPrompt.ASK_WINNING_NUM_IN_NUMBER;
import static lotto.Message.InputValidatorPrompt.ASK_WINNING_NUM_IN_RIGHT_AMOUNT;

import static lotto.Message.InputValidatorPrompt.ASK_WINNING_NUM_IN_VALID_RANGE;
import static lotto.Message.InputValidatorPrompt.ASK_WINNING_NUM_WITH_NO_DUPLICATION;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.View.InputValidator.WinningNumValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningNumInputValidatorTest {

    WinningNumValidator validator = new WinningNumValidator();

    @ParameterizedTest
    @ValueSource(strings = {""})
    @DisplayName("빈값 입력 예외 처리")
    void 빈값_입력_예외_처리(String userInput) {
        assertThatThrownBy(
                () -> {
                    validator.validate(userInput);
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ASK_NO_EMPTY_INPUT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {", , , , , , ", "1, ,2,3,4,5,6", "1 ,2,3,4,5,6", "1,2,3,4,5,6 "})
    @DisplayName("공백 입력 예외 처리")
    void 공백_입력_예외_처리(String userInput) {
        assertThatThrownBy(
                () -> {
                    validator.validate(userInput);
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ASK_NO_WHITE_SPACE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,,,", "1,2,3,4,5,6,7,8", "5,7", "32,45,7"})
    @DisplayName("당첨 번호 입력 갯수가 6개가 아닌 경우 예외 처리")
    void 당첨_번호_갯수_미준수_예외_처리(String userInput) {
        assertThatThrownBy(
                () -> {
                    validator.validate(userInput);
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ASK_WINNING_NUM_IN_RIGHT_AMOUNT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {",1,2,3,4,5","1,2,3,4,5,*", "일,이,삼,사,오,육", "\n,1,2,3,4,5"})
    @DisplayName("당첨 번호 입력 갯수가 6개가 아닌 경우 예외 처리")
    void 숫자_외_입력_예외_처리(String userInput) {
        assertThatThrownBy(
                () -> {
                    validator.validate(userInput);
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ASK_WINNING_NUM_IN_NUMBER.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,1,3,4,5,6", "1,1,1,1,1,1"})
    @DisplayName("당첨 번호 입력 갯수가 6개가 아닌 경우 예외 처리")
    void 중복_입력_예외_처리(String userInput) {
        assertThatThrownBy(
                () -> {
                    validator.validate(userInput);
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ASK_WINNING_NUM_WITH_NO_DUPLICATION.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1,1,3,4,5,6", "1,2,3,4,5,46"})
    @DisplayName("당첨 번호 입력 갯수가 6개가 아닌 경우 예외 처리")
    void 유효_범위_외_숫자_예외_처리(String userInput) {
        assertThatThrownBy(
                () -> {
                    validator.validate(userInput);
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ASK_WINNING_NUM_IN_VALID_RANGE.getMessage());
    }
}
