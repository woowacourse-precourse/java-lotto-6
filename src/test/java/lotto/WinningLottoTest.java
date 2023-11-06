package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningLottoTest {

    private static Stream<Arguments> createRankTestData() {
        return Stream.of(
                Arguments.of(Rank.FIRST, LottoFixtures.createSixMatchedWinningLotto()),
                Arguments.of(Rank.SECOND, LottoFixtures.createFiveAndBonusMatchedWinningLotto()),
                Arguments.of(Rank.THIRD, LottoFixtures.createFiveMatchedWinningLotto()),
                Arguments.of(Rank.FOURTH, LottoFixtures.createFourMatchedWinningLotto()),
                Arguments.of(Rank.FIFTH, LottoFixtures.createThreeMatchedWinningLotto()),
                Arguments.of(Rank.MISS, LottoFixtures.createMissMatchedWinningLotto())
        );
    }

    @DisplayName("당첨 기준에 맞는 등수를 얻어야 한다.")
    @ParameterizedTest
    @MethodSource("createRankTestData")
    void getRankWithMatchedNumbers(Rank rank, Lotto lotto) {
        WinningLotto normalWinningLotto = WinningLottoFixtures.createWinningLotto();
        Rank matchedRank = normalWinningLotto.match(lotto);
        assertThat(matchedRank).isEqualTo(rank);
    }
}
