package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {
    @DisplayName("1~45 의 서로 다른 6개의 당첨번호를 생성한다.")
    @Test
    void createWinningNumbers() {
        // given
        String input = "1,2,3,4,5,6";

        // when
        WinningNumbers winningNumbers = WinningNumbers.create(input);

        // then
        assertThat(winningNumbers.getNumbers().size()).isEqualTo(6);
    }

    @ParameterizedTest(name = "[{index}] 당첨번호가 ''{0}'' 이면 예외가 발생한다.")
    @ValueSource(strings = {"", " ", ",1", "1,", ",,,", "1,2,3,4,5,6,", "1.2.3.4.5.6", "1,2,3 ,4",
            "1,1,2,3,4,5", "-1,4,5,6,7,8", "1,46,3,4,5,6"})
    void cannotCreateWinningLottos(String input) {
        assertThatThrownBy(() -> WinningNumbers.create(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}