package lotto.model;

import static lotto.common.ExceptionMessage.ERROR_BLANK_VALUE;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MainNumberTest {
    @DisplayName("정상적인 숫자 문자열 입력 값으로 MainNumber을 생성한다.")
    @Test
    void createMainNumberWithValidInput() {
        String validNumber = "5";
        MainNumber mainNumber = MainNumber.from(validNumber);

        assertThat(mainNumber).isNotNull();
        assertThat(mainNumber.getMainNumber()).isEqualTo(5);
    }

    @DisplayName("공백 문자열 입력 값으로 MainNumber 생성 시 예외 발생")
    @Test
    void throwExceptionWhenBlankInputProvided() {
        String blank = " ";

        assertThatThrownBy(() -> MainNumber.from(blank))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_BLANK_VALUE);
    }

    @DisplayName("범위 밖의 숫자 문자열 입력 값으로 MainNumber 생성 시 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "46"})
    void throwExceptionWhenOutOfRangeInputProvided(String invalidInput) {
        assertThatIllegalArgumentException().isThrownBy(() -> MainNumber.from(invalidInput));
    }

    @DisplayName("MainNumber와 입력 값의 일치 여부를 확인한다.")
    @Test
    void checkNumberEquality() {
        MainNumber mainNumber = MainNumber.from("7");

        assertThat(mainNumber.isNumberEqual(7)).isTrue();
        assertThat(mainNumber.isNumberEqual(1)).isFalse();
    }
}
