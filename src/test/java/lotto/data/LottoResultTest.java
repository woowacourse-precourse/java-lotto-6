package lotto.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lotto.message.LottoPrize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoResultTest {
    @ParameterizedTest(name = "[{index}] {0}인 경우")
    @DisplayName("로또 순위 결과를 생성한다.")
    @MethodSource("provideRankResultSets")
    void createRankResult(String title, List<Integer> winningNumbers, int bonusNumber, List<Lotto> lottos,
                          Map<LottoPrize, BigDecimal> expected) {
        WinningCombination winningCombination = new WinningCombination(winningNumbers, bonusNumber);

        Map<LottoPrize, BigDecimal> rankResult = winningCombination.getResultWith(lottos);
        BigDecimal purchaseAmount = BigDecimal.valueOf(lottos.size()).multiply(BigDecimal.valueOf(1000));
        LottoResult lottoResult = new LottoResult(rankResult, purchaseAmount);

        assertEquals(lottoResult.getLottoRank(), expected);
    }

    private static Stream<Arguments> provideRankResultSets() {
        return Stream.of(
                Arguments.of(
                        "1등(1), 2등(1), 5등(1)",
                        List.of(1, 2, 3, 4, 5, 6), 7,
                        List.of(
                                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                                new Lotto(List.of(1, 20, 3, 4, 7, 8))
                        ),
                        Map.of(
                                LottoPrize.FIRST, BigDecimal.ONE,
                                LottoPrize.SECOND, BigDecimal.ONE,
                                LottoPrize.THIRD, BigDecimal.ZERO,
                                LottoPrize.FOURTH, BigDecimal.ZERO,
                                LottoPrize.FIFTH, BigDecimal.ONE,
                                LottoPrize.NONE, BigDecimal.ZERO
                        )
                ), Arguments.of(
                        "2등(1), 4등(2)",
                        List.of(1, 2, 3, 4, 5, 6), 7,
                        List.of(
                                new Lotto(List.of(1, 2, 30, 40, 5, 6)),
                                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                                new Lotto(List.of(1, 2, 3, 4, 17, 8))
                        ),
                        Map.of(
                                LottoPrize.FIRST, BigDecimal.ZERO,
                                LottoPrize.SECOND, BigDecimal.ONE,
                                LottoPrize.THIRD, BigDecimal.ZERO,
                                LottoPrize.FOURTH, BigDecimal.valueOf(2),
                                LottoPrize.FIFTH, BigDecimal.ZERO,
                                LottoPrize.NONE, BigDecimal.ZERO
                        )
                ), Arguments.of(
                        "5등(2)",
                        List.of(1, 2, 3, 4, 5, 6), 7,
                        List.of(
                                new Lotto(List.of(1, 20, 3, 40, 43, 6)),
                                new Lotto(List.of(11, 22, 33, 44, 5, 7)),
                                new Lotto(List.of(1, 20, 3, 4, 7, 8))
                        ),
                        Map.of(
                                LottoPrize.FIRST, BigDecimal.ZERO,
                                LottoPrize.SECOND, BigDecimal.ZERO,
                                LottoPrize.THIRD, BigDecimal.ZERO,
                                LottoPrize.FOURTH, BigDecimal.ZERO,
                                LottoPrize.FIFTH, BigDecimal.valueOf(2),
                                LottoPrize.NONE, BigDecimal.ONE
                        )
                )
        );
    }
}
