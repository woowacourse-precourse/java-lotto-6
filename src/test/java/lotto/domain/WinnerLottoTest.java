package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("당첨 로또")
class WinnerLottoTest {

    @DisplayName("입력한 번호의 개수가 6개가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("wrongNumbersSizeDummy")
    void createLottoByOverSize(List<Integer> winnerNumbers, Integer bonusNumber) {
        assertThatThrownBy(() -> WinnerLotto.create(winnerNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }


    static Stream<Arguments> wrongNumbersSizeDummy() {
        return Stream.of(
                Arguments.arguments(
                        List.of(1, 2, 3, 4, 5, 6, 7),
                        10),

                Arguments.arguments(
                        List.of(1, 2, 3, 4),
                        10),

                Arguments.arguments(
                        List.of(1, 2, 3, 4, 5, 6, 8, 9),
                        10),

                Arguments.arguments(
                        List.of(1, 2),
                        10)
        );
    }
}