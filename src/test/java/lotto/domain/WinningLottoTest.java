package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningLottoTest {

    @DisplayName("당첨 번호에 중복된 숫자가 있거나 범위를 초과하는 숫자가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("parametersForCreateWinningLottoByInvalidNumber")
    void createWinningLottoByInvalidNumber(List<Integer> lotto, int bonusNumber) {
        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR]");
    }

    static Stream<Arguments> parametersForCreateWinningLottoByInvalidNumber() {
        return Stream.of(
            Arguments.of(List.of(1, 2, 3, 4, 5, 6), 6),
            Arguments.of(List.of(1, 2, 3, 4, 5, 6), 50)
        );
    }
}
