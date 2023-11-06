package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoGameTest {

    static Stream<Arguments> lottoMatchArguments() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(7, 8, 9, 10, 11, 12)), Rank.MISS, 20),
                Arguments.of(new Lotto(List.of(1, 2, 3, 10, 11, 12)), Rank.THREE, 20),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 11, 12)), Rank.FOUR, 20),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 12)), Rank.FIVE, 20),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 12)), Rank.FIVE_BONUS, 6),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), Rank.SIX, 20)
        );
    }

    @Test
    @DisplayName("입력 금액에 맞는 수의 로또 티켓이 발행되는지 테스트")
    void checkCorrectNumberOfTicketsBasedOnPurchaseAmount() {
        LottoGame lottoGame = new LottoGame();
        int purchaseAmount = 5000;
        List<Lotto> issuedLottos = lottoGame.purchaseLottos(purchaseAmount);
        assertThat(issuedLottos.size()).isEqualTo(5);
    }

    @ParameterizedTest
    @MethodSource("lottoMatchArguments")
    @DisplayName("올바른 당첨 결과가 나오는지 테스트")
    void returnCorrectRankForLottoMatches(Lotto userLotto, Rank expectedRank, int bonusNumber) {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        Rank result = userLotto.calculateMatchRank(winningLotto, bonusNumber);

        assertEquals(expectedRank, result);
    }

}