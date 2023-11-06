package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import lotto.fixtures.LottoFixtures;
import lotto.fixtures.WinningLottoFixtures;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningLottoTest {

    private static Stream<Arguments> createRankTestData() {
        return Stream.of(
                Arguments.of(Rank.FIRST,  LottoFixtures.createSixMatchedLotto()),
                Arguments.of(Rank.SECOND, LottoFixtures.createFiveAndBonusMatchedLotto()),
                Arguments.of(Rank.THIRD,  LottoFixtures.createFiveMatchedLotto()),
                Arguments.of(Rank.FOURTH, LottoFixtures.createFourMatchedLotto()),
                Arguments.of(Rank.FIFTH,  LottoFixtures.createThreeMatchedLotto()),
                Arguments.of(Rank.MISS,   LottoFixtures.createMissMatchedLotto())
        );
    }

    @DisplayName("당첨 기준에 맞는 등수를 얻어야 한다.")
    @ParameterizedTest
    @MethodSource("createRankTestData")
    void getRankWithMatchedNumbers(Rank rank, Lotto lotto) {
        WinningLotto winningLotto = WinningLottoFixtures.createWinningLotto();
        Rank matchedRank = winningLotto.match(lotto);
        assertThat(matchedRank).isEqualTo(rank);
    }
}
