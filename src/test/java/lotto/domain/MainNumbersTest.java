package lotto.domain;

import static lotto.validator.ErrorMessage.DUPLICATED_MAIN_NUMBER;
import static lotto.validator.ErrorMessage.INVALID_NUM_MAIN_NUMBER;
import static lotto.validator.ErrorMessage.INVALID_RANGE_WINNING_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MainNumbersTest {

    @DisplayName("당첨번호가 6개가 아니면 예외 발생")
    @Test
    void createMainNumbersSize() {
        Assertions.assertThatThrownBy(() -> new MainNumbers(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NUM_MAIN_NUMBER.message());

    }

    @DisplayName("당첨번호가 범위 밖의 숫자면 예외 발생")
    @Test
    void createMainNumbersRange() {
        Assertions.assertThatThrownBy(() -> new MainNumbers(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_RANGE_WINNING_NUMBER.message());

    }

    @DisplayName("당첨번호끼리 겹치면 예외 발생")
    @Test
    void createMainNumbersDuplicated() {
        Assertions.assertThatThrownBy(() -> new MainNumbers(List.of(1, 2, 3, 1, 2, 3)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATED_MAIN_NUMBER.message());

    }

    @DisplayName("당첨번호와 일치하는지 확인하는 메서드 테스트")
    @ParameterizedTest
    @CsvSource({"1,true", "7,false"})
    void isMainNumber(int number, boolean expected) {
        MainNumbers mainNumbers = new MainNumbers(List.of(1, 2, 3, 4, 5, 6));

        assertThat(mainNumbers.isMainNumber(number)).isEqualTo(expected);
    }
}
