package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import domain.LottoWinningMatchState;
import java.util.Optional;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoWinningMatchStateTest {
    @Test
    @DisplayName("일치한 로또 숫자 개수가 음수라면 예외를 발생시킨다.")
    void calculateLottoMatchStateByNegativeCount() {
        assertThrows(IllegalArgumentException.class,
                () -> LottoWinningMatchState.calculateMatchState(-1));
    }

    @Test
    @DisplayName("일치한 로또 숫자 개수가 6개를 초과하면 예외를 발생시킨다.")
    void calculateLottoMatchStateByOverCount() {
        assertThrows(IllegalArgumentException.class,
                () -> LottoWinningMatchState.calculateMatchState(7));
    }

    @ParameterizedTest
    @DisplayName("일치한 로또 숫자 개수가 3 미만이면 빈 옵셔널 값을 반환한다.")
    @ValueSource(ints = {0, 1, 2})
    void calculateLottoMatchStateByLessMinCount(int matchCount) {
        Optional<LottoWinningMatchState> stateOptional = LottoWinningMatchState.calculateMatchState(matchCount);
        assertThat(stateOptional).isEmpty();
    }

    @ParameterizedTest
    @DisplayName("일치한 로또 숫자 개수가 3 이상이면 상태가 들어있는 옵셔널 값을 반환한다.")
    @MethodSource("matchCountAndExpectState")
    void calculateLottoMatchStateByLessMinCount(int matchCount, LottoWinningMatchState expectState) {
        Optional<LottoWinningMatchState> stateOptional = LottoWinningMatchState.calculateMatchState(matchCount);
        assertThat(stateOptional).hasValue(expectState);
    }

    public static Stream<Arguments> matchCountAndExpectState() {
        return Stream.of(
                Arguments.of(3, LottoWinningMatchState.MIN_MATCH),
                Arguments.of(4, LottoWinningMatchState.NORMAL_MATCH),
                Arguments.of(5, LottoWinningMatchState.CHECK_BONUS_NUMBER_MATCH),
                Arguments.of(6, LottoWinningMatchState.ALL_MATCH)
        );
    }
}
