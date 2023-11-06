package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningNumberTest {
    @ParameterizedTest
    @MethodSource("inputWinningNumbers")
    void 당첨_번호가_올바르지_않은_경우(List<String> winningNumber) {
        assertThatThrownBy(() -> new WinningNumber(winningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Collection<List<String>> inputWinningNumbers() {
        return Arrays.asList(
                Arrays.asList("ab", "2", "3", "4", "5", "cd"),
                Arrays.asList("0", "2", "3", "4", "5", "46"),
                Arrays.asList("", " ", "3", "4", "5", "6"),
                Arrays.asList("1", "1", "2", "3", "4", "5"),
                Arrays.asList("1", "2", "3", "4", "5", "6", "7")
        );
    }
}
