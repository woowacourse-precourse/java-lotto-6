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



    @Test
    @DisplayName("입력 금액에 맞는 수의 로또 티켓이 발행되는지 테스트")
    void checkCorrectNumberOfTicketsBasedOnPurchaseAmount() {
        LottoGame lottoGame = new LottoGame();
        int purchaseAmount = 5000;
        List<Lotto> issuedLottos = lottoGame.purchaseLottos(purchaseAmount);
        assertThat(issuedLottos.size()).isEqualTo(5);
    }

}