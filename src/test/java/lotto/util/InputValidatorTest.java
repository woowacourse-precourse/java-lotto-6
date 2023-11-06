package lotto.util;

import net.bytebuddy.utility.dispatcher.JavaDispatcher.Defaults;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @DisplayName("숫자 하나만 입력으로 들어올 시 자연수가 아니면 예외가 발생한다.")
    @Test
    void isNaturalNumber() {
        //given
        String number = "a";
        //when
        boolean result = InputValidator.isNaturalNumber(number);
        //then
        assertThat(result).isFalse();
    }

    @DisplayName("숫자 배열이 들어올 시 하나라도 자연수가 아니면 예외가 발생한다.")
    @Test
    void isNaturalNumbers() {
        //given
        String[] numbers = {"1", "2", "a", "3", "4", "5"};
        //when
        boolean result = InputValidator.isNaturalNumber(numbers);
        //then
        assertThat(result).isFalse();
    }

    @DisplayName("공백이 포함되어 있으면 예외가 발생한다.")
    @Test
    void hasBlank() {
        //given
        String input = " ";
        //when
        boolean result = InputValidator.hasBlank(input);
        //then
        assertThat(result).isTrue();
    }
}