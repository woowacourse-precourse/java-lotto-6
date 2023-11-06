package lotto.domain.lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lotto.domain.result.WinningRank;
import lotto.domain.result.WinningResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottosTest {

    @ParameterizedTest()
    @MethodSource("argumentsExpectedWinningResult")
    @DisplayName("당첨로또와 로또들을 비교하여 예상하는 expectedWinningResult가 생성되는지 테스트")
    void 구매한로또와_당첨로또_비교하여_결과생성(Lottos lottos, WinningLotto winningLotto,
            Map<WinningRank, Integer> expectedWinningResult) {
        // when
        WinningResult winningResult = lottos.calculateWinningResult(winningLotto);

        // then
        Assertions.assertThat(winningResult.getResult()).isEqualTo(expectedWinningResult);
    }

    private static Stream<Arguments> argumentsExpectedWinningResult() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new BonusNumber(7));

        Lotto sixNumbersMatchedLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto fiveNumbersAndBonusNumberMatchedLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto fiveNumbersMatchedLotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        Lotto fourNumbersMatchedLotto = new Lotto(List.of(1, 2, 3, 4, 7, 8));
        Lotto threeNumbersMatchedLotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        Lotto nothingMatchedLotto = new Lotto(List.of(10, 11, 12, 13, 14, 15));

        Lottos allWinningLottos = new Lottos(
                List.of(sixNumbersMatchedLotto, fiveNumbersAndBonusNumberMatchedLotto,
                        fiveNumbersMatchedLotto, fourNumbersMatchedLotto,
                        threeNumbersMatchedLotto));

        Lottos nothingWinningLottos = new Lottos(List.of(nothingMatchedLotto));

        Map<WinningRank, Integer> expectedAllWinning = createExpectedWinningResult(1, 1, 1, 1,
                1, 0);
        Map<WinningRank, Integer> expectedNothingWinning = createExpectedWinningResult(0, 0, 0, 0,
                0, 1);

        return Stream.of(
                Arguments.of(allWinningLottos, winningLotto, expectedAllWinning),
                Arguments.of(nothingWinningLottos, winningLotto, expectedNothingWinning)
        );
    }

    private static Map<WinningRank, Integer> createExpectedWinningResult(int first, int second,
            int third, int fourth, int fifth, int empty) {
        Map<WinningRank, Integer> expectedWinningResult = new EnumMap<>(WinningRank.class);
        expectedWinningResult.put(WinningRank.FIRST, first);
        expectedWinningResult.put(WinningRank.SECOND, second);
        expectedWinningResult.put(WinningRank.THIRD, third);
        expectedWinningResult.put(WinningRank.FOURTH, fourth);
        expectedWinningResult.put(WinningRank.FIFTH, fifth);
        expectedWinningResult.put(WinningRank.EMPTY, empty);
        return expectedWinningResult;
    }
}