package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberTest {
    @DisplayName("보너스 번호가 범위를 벗어나면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("getBonusNumberOutOfRangeList")
    void crateBonusNumberOutOfRange(List<Integer> numbers, int bonusBall) {
        Assertions.assertThatThrownBy(() -> new WinningNumber(numbers, bonusBall))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> getBonusNumberOutOfRangeList() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 6), 0),
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 6), 46)
        );
    }

    @DisplayName("당첨 번호와 보너스 번호가 중복되면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedBonusNumber() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 6),6))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
