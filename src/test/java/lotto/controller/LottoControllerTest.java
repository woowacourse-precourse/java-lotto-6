package lotto.controller;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoControllerTest {

    @DisplayName("로또 번호 생성 테스트")
    @Test
    void generateRandomLottoTest() {
        // when
        List<Lotto> lottos = LottoController.generateLottos(6000);
        // then
        assertThat(lottos.size()).isEqualTo(6);
    }

    @DisplayName("로또 번호 생성 개수가 0일 때 테스트")
    @Test
    void generateRandomLottoWhenNumberIsZeroTest() {
        // when
        List<Lotto> lottos = LottoController.generateLottos(0);
        // then
        assertThat(lottos.size()).isEqualTo(0);
    }

    @DisplayName("로또 당첨 내역 만들기 테스트")
    @Test
    void makeLottoResultTest() {
        // given
        List<Integer> winningNumber = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        Lotto lotto1 = new Lotto(List.of(8, 21, 23, 41, 42, 43));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 16, 32, 38));
        List<Lotto> lottos = new ArrayList<>(List.of(lotto1, lotto2));
        // when
        List<Integer> counts = LottoController.makeLottoResult(winningNumber, bonusNumber, lottos);
        // then
        assertThat(counts).isEqualTo(new ArrayList<>((List.of(1, 0, 0, 0, 0))));
    }

    @DisplayName("수익률 계산 테스트")
    @Test
    void calculateEarningRateTest() {
        // given
        int purchaseAmount = 8000;
        List<Integer> rewards = new ArrayList<>();
        rewards.add(5000);
        rewards.add(50000);
        rewards.add(1500000);
        rewards.add(30000000);
        rewards.add(2000000000);
        List<Integer> counts = new ArrayList<>(List.of(1, 0, 0, 0, 0));
        // when
        double earningRate = LottoController.calculateEarningRate(purchaseAmount, rewards, counts);
        // then
        assertThat(earningRate).isEqualTo(62.5);
    }
}