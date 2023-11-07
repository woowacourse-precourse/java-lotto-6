package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import domain.LottoWinningTier;
import java.util.Optional;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoWinningTierTest {
    @Test
    @DisplayName("일치한 로또 숫자 개수가 음수라면 예외를 발생시킨다.")
    void calculateLottoWinningTierByNegativeCount() {
        assertThrows(IllegalArgumentException.class, () -> LottoWinningTier.calculateTier(-1, false));
    }

    @Test
    @DisplayName("일치한 로또 숫자 개수가 6개를 초과하면 예외를 발생시킨다.")
    void calculateLottoWinningTierByOverCount() {
        assertThrows(IllegalArgumentException.class, () -> LottoWinningTier.calculateTier(7, false));
    }

    @Test
    @DisplayName("일치한 로또 숫자 개수가 6개이며 보너스 번호까지 맞췄다면 예외를 발생시킨다.")
    void calculateLottoWinningTierByMaxCountPlusBonus() {
        assertThrows(IllegalArgumentException.class, () -> LottoWinningTier.calculateTier(6, true));
    }

    @ParameterizedTest
    @DisplayName("일치한 로또 숫자 개수가 3 미만이면 빈 옵셔널 값을 반환한다.")
    @ValueSource(ints = {0, 1, 2})
    void calculateLottoWinningTierByLess3(int matchCount) {
        Optional<LottoWinningTier> tierOptional = LottoWinningTier.calculateTier(matchCount, false);
        assertThat(tierOptional).isEmpty();
    }

    @ParameterizedTest
    @DisplayName("일치한 로또 숫자 개수가 3 이상이면 상태가 들어있는 옵셔널 값을 반환한다.")
    @MethodSource("matchCountMatchBonusAndExpectTier")
    void calculateLottoMatchStateByLessMinCount(int matchCount, boolean matchBonus, LottoWinningTier expectTier) {
        Optional<LottoWinningTier> stateOptional = LottoWinningTier.calculateTier(matchCount, matchBonus);
        assertThat(stateOptional).hasValue(expectTier);
    }

    public static Stream<Arguments> matchCountMatchBonusAndExpectTier() {
        return Stream.of(
                Arguments.of(6, false, LottoWinningTier.FIRST_TIER),
                Arguments.of(5, true, LottoWinningTier.SECOND_TIER),
                Arguments.of(5, false, LottoWinningTier.THIRD_TIER),
                Arguments.of(4, true, LottoWinningTier.FOURTH_TIER),
                Arguments.of(4, false, LottoWinningTier.FOURTH_TIER),
                Arguments.of(3, true, LottoWinningTier.FIFTH_TIER),
                Arguments.of(3, false, LottoWinningTier.FIFTH_TIER)
        );
    }
}
