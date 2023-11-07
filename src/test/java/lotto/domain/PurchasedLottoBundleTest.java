package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("[도메인] 구매한 로또 묶음 테스트")
class PurchasedLottoBundleTest {

    @Test
    void _2개의_당첨_로또를_만든다() {

        final var purchasedLottoBundle = new PurchasedLottoBundle(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6))
        ));

        final var winningResults = purchasedLottoBundle.checkWinningResults(
                AnswerLotto.of(List.of(1, 2, 3, 4, 5, 6)).registerBonusNumber(7)
        );

        assertAll(
                () -> assertThat(winningResults.value().get(LottoRewardTable.FIRST)).isEqualTo(2),
                () -> assertThat(winningResults.calculateProfit()).isEqualTo(LottoRewardTable.FIRST.getReward() * 2L)
        );

    }

    @Test
    void 각_등수_별로_전부_당첨된다() {
        final var purchasedLottoBundle = new PurchasedLottoBundle(List.of(
                new Lotto(List.of(1, 5, 10, 2, 3, 4)), //5등
                new Lotto(List.of(1, 5, 10, 15, 2, 3)), //4등
                new Lotto(List.of(1, 5, 10, 15, 20, 2)), // 3등
                new Lotto(List.of(1, 5, 10, 15, 20, 45)), // 2등
                new Lotto(List.of(1, 5, 10, 15, 20, 25)) // 1등
        ));

        final var winningResults = purchasedLottoBundle.checkWinningResults(
                AnswerLotto.of(List.of(1, 5, 10, 15, 20, 25))
                        .registerBonusNumber(45)
        );

        final var matchCounts = winningResults.value().values().stream().toList();
        assertAll(
                () -> assertThat(matchCounts).isEqualTo(List.of(1L, 1L, 1L, 1L, 1L)),
                () -> assertThat(winningResults.calculateProfit()).isEqualTo(Arrays.stream(LottoRewardTable.values())
                        .mapToLong(LottoRewardTable::getReward)
                        .sum())

        );
    }

}