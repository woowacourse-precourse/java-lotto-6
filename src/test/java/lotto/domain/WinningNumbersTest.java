package lotto.domain;

import static lotto.util.validator.WinningNumbersDtoValidator.WINNING_NUMBERS_IS_INVALID_FORMAT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.dto.WinningNumbersDto;
import lotto.util.validator.Validator;
import lotto.util.validator.WinningNumbersDtoValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningNumbersTest {

    @DisplayName("WinningNumbersDto 클래스 지원")
    @Test
    void checkSupport() {
        Validator winningNumbersDtoValidator = new WinningNumbersDtoValidator();
        assertThat(winningNumbersDtoValidator.support(WinningNumbersDto.class)).isTrue();
    }
    @DisplayName("구분자 형식이 올바르지 않을 경우 예외를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1/2/3/4/5/6", "1,,2,3,4,5,6", ",1,2,3,4,5,6", "1,2,3,4,5,6,"})
    void check_seperator(String winningNumbers) {
        assertThatThrownBy(() -> WinningNumbersDto.from(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WINNING_NUMBERS_IS_INVALID_FORMAT);
    }
}
