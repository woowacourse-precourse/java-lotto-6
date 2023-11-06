package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
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

    @DisplayName("당첨 번호와 로또 번호가 일치하는지 확인한다.")
    @ParameterizedTest
    @MethodSource("parametersForMatchWinningLottoToLotto")
    void matchWinningLottoToLotto(Lotto lotto, Rank rank) {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(winningLotto.match(lotto)).isEqualTo(rank);
    }

    static Stream<Arguments> parametersForMatchWinningLottoToLotto() {
        return Stream.of(
            Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), Rank.FIRST),
            Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)), Rank.SECOND),
            Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 8)), Rank.THIRD),
            Arguments.of(new Lotto(List.of(1, 2, 3, 4, 7, 8)), Rank.FOURTH),
            Arguments.of(new Lotto(List.of(1, 2, 3, 7, 8, 9)), Rank.FIFTH),
            Arguments.of(new Lotto(List.of(1, 2, 7, 8, 9, 10)), Rank.MISS)
        );
    }
}
