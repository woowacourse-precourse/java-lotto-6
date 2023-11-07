package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberValidatorTest {
    @DisplayName("입력된 하나의 로또 번호가 빈칸인 경우 예외를 발생시킨다.")
    @Test
    void validateLottoNumberByBlank(){
        assertThatThrownBy(() -> NumberValidator.validate(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("입력된 하나의 로또 번호가 정수가 아닌 경우 예외를 발생시킨다.")
    @Test
    void validateLottoNumberByNotInteger(){
        assertThatThrownBy(() -> NumberValidator.validate("notNumber"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("입력된 하나의 로또 번호가 0이하일 경우 예외를 발생시킨다.")
    @Test
    void validateLottoNumberByUnderSize(){
        assertThatThrownBy(() -> NumberValidator.validate("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("입력된 하나의 로또 번호가 46이상일 경우 예외를 발생시킨다.")
    @Test
    void validateLottoNumberByOverSize(){
        assertThatThrownBy(() -> NumberValidator.validate("46"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
