package lotto.domain;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningNumbersTest {

    @ParameterizedTest(name = "당첨 번호 : {0}, 보너스 번호 : {1}")
    @MethodSource("generateDuplicateWinningNumbers")
    @DisplayName("보너스 번호가 당첨번호와 중복되면 예외가 발생한다.")
    void 보너스_번호가_당첨_번호와_중복_예외_테스트(List<Integer> winningNumber, int bonusNumber) {
        //when, then
        Assertions.assertThatThrownBy(() -> new WinningNumbers(winningNumber, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호와 중복된");

    }

    static Stream<Arguments> generateDuplicateWinningNumbers() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 2),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 3),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 4)
        );
    }
}
