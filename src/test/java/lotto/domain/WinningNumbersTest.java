package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.dto.WinningNumbersDto;
import lotto.util.Seperator;
import lotto.util.validator.WinningNumbersDtoValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningNumbersTest {
    @DisplayName("입력이 공백인 경우 예외를 반환한다.")
    @ParameterizedTest
    @EmptySource
    void check_empty(String empty) {
        assertThatThrownBy(() -> WinningNumbersDto.from(empty))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백은 입력할 수 없습니다.");
    }

    @DisplayName("구분자 형식이 올바르지 않을 경우 예외를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1/2/3/4/5/6", ",1,2,3,4,5,6", "1,2,3,4,5,6,", "1,,2,3,4,5,6"})
    void check_seperator(String winningNumbers) {
        assertThatThrownBy(() -> WinningNumbersDto.from(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호 입력 형식에 맞지 않습니다.");
    }
}
