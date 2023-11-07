package lotto.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {
    @Test
    @DisplayName("당첨 번호 생성 성공 테스트")
    void 당첨_번호_객체_생성_성공() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> numbers = winningNumbers.getNumbers();
        Assertions.assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("당첨 번호 길이가 6초가이면 예외가 발생한다.")
    void 당첨_번호_길이_6초과_실패_테스트() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호 길이가 6미만이면 예외가 발생한다.")
    void 당첨_번호_길이_6미만_실패_테스트() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호가 중복되면 예외가 발생한다")
    void 당첨_번호_중복_실패_테스트() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 당첨_번호_범위_실패_테스트(int number) {
        assertThatThrownBy(() -> new WinningNumbers(List.of(number, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}