package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    private WinningLotto winningLotto;
    private ArrayList<Lotto> lottos;

    @BeforeEach
    void setUp() {
        winningLotto = new WinningLotto(List.of(1, 3, 5, 7, 9, 11), 2);
        lottos = new ArrayList<>();

        lottos.add(new Lotto(List.of(1, 3, 5, 7, 9, 11)));
        lottos.add(new Lotto(List.of(1, 3, 5, 7, 9, 2)));
        lottos.add(new Lotto(List.of(1, 3, 5, 20, 21, 22)));
    }

    @DisplayName("구입 금액만큼 로또(1000원)를 생성해서 반환한다.")
    @Test
    void generateLotto() {
        LottoService lottoService = new LottoService();
        ArrayList<Lotto> lottos = lottoService.generateLotto(new PurchaseAmount(8000));

        Assertions.assertThat(lottos.size()).isEqualTo(8000 / 1000);
    }

    @DisplayName("로또와 당첨 로또를 비교해서 Map<Rank, Count>를 반환한다.")
    @Test
    void generateLottoStatistics() {
        Map<Rank, Integer> rankCount = new HashMap<>();
        rankCount.put(Rank.FIRST, 1);
        rankCount.put(Rank.SECOND, 1);
        rankCount.put(Rank.FIFTH, 1);

        LottoService lottoService = new LottoService();
        Map<Rank, Integer> result = lottoService.generateLottoStatistics(winningLotto, lottos);

        assertThat(result).isEqualTo(rankCount);
    }

    @DisplayName("당첨 금을 합산하고 구입 금액과 비교하여 총 수익률을 구한다")
    @Test
    void calculateProfitRate() {
        Map<Rank, Integer> rankCount = new HashMap<>();
        // 50000, 10000 * 2
        rankCount.put(Rank.FOURTH, 1);
        rankCount.put(Rank.FIFTH, 2);

        LottoService lottoService = new LottoService();
        double ProfitRate = lottoService.calculateProfitRate(rankCount, new PurchaseAmount(10000));

        assertThat(ProfitRate).isEqualTo(600.0);
    }

}