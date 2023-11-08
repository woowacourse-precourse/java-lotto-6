package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {
    @Test
    void split_구분자_확인() {
        String input = "1,2,3,4,5,6";
        String[] result = input.split(",");
        assertThat(result[0]).isEqualTo("1");
    }

    @Test
    void split_구분자_뒤_공백이_있을_때_분할_확인() {
        String input = "1, 2, 3,4,5,6";
        String[] result = input.split(",");
        assertThat(result[1]).isEqualTo(" 2");
    }

    @Test
    void split_구분자_사이_숫자를_입력하지_않은_경우() {
        String input = "1,,2,3,4,5,6";
        String[] result = input.split(",");
        assertThat(Arrays.stream(result).toList()).isEqualTo(Arrays.asList("1", "", "2", "3", "4", "5", "6"));
    }

    @Test
    void 숫자_6개가_아닌_경우() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_1미만_포함된_경우() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_45초과_포함된_경우() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 46, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복된_숫자가_존재하는_경우() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 2, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}