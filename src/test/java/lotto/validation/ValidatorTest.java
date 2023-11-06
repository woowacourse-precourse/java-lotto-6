package lotto.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    Validator validator = new Validator();

    @DisplayName("String 타입 변수를 Integer 로 변환하고, 실패하면 예외를 발생시킨다.")
    @ValueSource(strings = {"Q", "DY", "type"})
    @ParameterizedTest
    void convertTypeAndExceptionTest(String value) {
        Assertions.assertThatThrownBy(() -> validator.checkType(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 금액이 천원으로 나누어 떨어지지 않으면 예외를 발생시킨다.")
    @ValueSource(ints = {5001, 4444, 500})
    @ParameterizedTest
    void numberRemainExceptionTest(int value) {
        Assertions.assertThatThrownBy(() -> validator.checkRemain(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1~45 사이가 아니라면 예외를 발생시킨다.")
    @ValueSource(ints = {0, 46, 500})
    @ParameterizedTest
    void numberRangeExceptionTest(int value) {
        Assertions.assertThatThrownBy(() -> validator.checkRange(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또 배열이 총 6개가 아니라면 예외를 발생시킨다.")
    @Test
    void numberRangeExceptionTest() {
        Assertions.assertThatThrownBy(() -> validator.validNumbers(Arrays.asList("1", "2", "3", "4", "5")))
                .isInstanceOf(IllegalArgumentException.class);
    }

}