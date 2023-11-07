package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;
import lotto.CustomLotteryRanking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("[Unit] WinningLottery에 관한 테스트")
@DisplayNameGeneration(ReplaceUnderscores.class)
public class WinningLotteryTest {


    @ParameterizedTest
    @MethodSource
    void getResultFrom_등수가_같은_두_로또는_같은_결과를_가져와야_된다(Lotto a, Lotto b) {
        LotteryRound round = new LotteryRound(1);
        Collection<? extends LotteryRanking> rankings = List.of(CustomLotteryRanking.values());
        PurchasedLottery lotteryA = new PurchasedLottery(round, a);
        PurchasedLottery lotteryB = new PurchasedLottery(round, b);

        WinningLottery winningLottery = new WinningLottery(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new BonusNumber(7));

        assertThat(winningLottery.getResultFrom(lotteryA, rankings))
                .isEqualTo(winningLottery.getResultFrom(lotteryB, rankings));
    }

    private static Stream<Arguments> getResultFrom_등수가_같은_두_로또는_같은_결과를_가져와야_된다() {
        return Stream.of(
                arguments(new Lotto(List.of(8, 9, 10, 11, 12, 13)),
                        new Lotto(List.of(14, 15, 16, 17, 18, 19))),
                arguments(new Lotto(List.of(8, 9, 10, 11, 12, 6)),
                        new Lotto(List.of(14, 15, 16, 17, 18, 6))),
                arguments(new Lotto(List.of(8, 9, 10, 11, 5, 6)),
                        new Lotto(List.of(14, 15, 16, 17, 5, 6))),
                arguments(new Lotto(List.of(8, 9, 10, 4, 5, 6)),
                        new Lotto(List.of(14, 15, 16, 4, 5, 6))),
                arguments(new Lotto(List.of(8, 9, 3, 4, 5, 6)),
                        new Lotto(List.of(14, 15, 3, 4, 5, 6))),
                arguments(new Lotto(List.of(8, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(14, 2, 3, 4, 5, 6))),
                arguments(new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 7))),
                arguments(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)))
        );
    }
}
