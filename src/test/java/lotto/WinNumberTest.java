package lotto;

import lotto.model.domain.vo.WinNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WinNumberTest {

    @DisplayName("당첨 번호가 숫자가 아니면 예외가 발생한다.")
    @Test
    void should_throwException_when_isNotNumeric() {
        Assertions.assertThatThrownBy(() -> WinNumber.of("1,2,3,4,5,a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자 형식이 아닙니다.");
    }

    @DisplayName("당첨 번호를 6개 입력하지 않으면 예외가 발생한다.")
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
    @ParameterizedTest
    void should_throwException_when_hasNot6Numbers(String input) {
        Assertions.assertThatThrownBy(() -> WinNumber.of(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("6개의 수를 입력해야 합니다.");
    }

    @DisplayName("당첨 번호가 1부터 45 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void should_throwException_when_isNotBetween1And45() {
        Assertions.assertThatThrownBy(() -> WinNumber.of("1,2,3,4,46,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1부터 45 사이의 수를 입력해야 합니다.");
    }

    @DisplayName("당첨 번호가 중복 한다면 예외를 발생한다.")
    @Test
    void should_throwException_when_isDuplicated() {
        Assertions.assertThatThrownBy(() -> WinNumber.of("1,2,3,1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 숫자를 입력할 수 없습니다.");
    }
}
