package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoResultManagerTest {

    private LottoRankResult rankResult;
    private LottoPrizeResult prizeResult;
    private WinningLotto winningLotto;
    LottoResultManager resultManager;
    private List<Lotto> lottos;

    private void assertRankResult(int targetRank, int ticketNumber) {
        assertThat(resultManager.getRankResult()
                .getCount(targetRank))
                .isEqualTo(ticketNumber);

        for (int rank = 0; rank <= 5; rank++) {
            if (rank != targetRank) {
                assertThat(resultManager.getRankResult()
                        .getCount(rank))
                        .isEqualTo(0);
            }
        }
    }

    @BeforeEach
    void setUp() {
        rankResult = new LottoRankResult();
        prizeResult = new LottoPrizeResult();
        winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        resultManager = new LottoResultManager(winningLotto, rankResult, prizeResult);
        lottos = new ArrayList<>();
    }

    @DisplayName("숫자 일치 개수가 3개 미만인 로또는 순위 결과의 0순위에 저장한다.")
    @Test
    void saveRankResultOfLottoOutOfRank() {
        int targetRank = 0;
        int ticketNumber = 4;

        lottos.add(new Lotto(List.of(8, 9, 10, 11, 12, 13)));
        lottos.add(new Lotto(List.of(1, 9, 10, 11, 12, 13)));
        lottos.add(new Lotto(List.of(1, 2, 10, 11, 12, 13)));
        lottos.add(new Lotto(List.of(1, 2, 7, 11, 12, 13)));

        resultManager.generateResult(lottos);

        assertRankResult(targetRank, ticketNumber);
    }

    @DisplayName("3개의 숫자가 일치하는 로또는 순위 결과의 5순위에 저장한다.")
    @Test
    void saveRankResultOfLottoOfRank5() {
        int targetRank = 5;
        int ticketNumber = 4;

        lottos.add(new Lotto(List.of(1, 2, 3, 11, 12, 13)));
        lottos.add(new Lotto(List.of(1, 2, 3, 7, 12, 13)));
        lottos.add(new Lotto(List.of(4, 5, 6, 11, 12, 13)));
        lottos.add(new Lotto(List.of(4, 5, 6, 7, 12, 13)));

        resultManager.generateResult(lottos);

        assertRankResult(targetRank, ticketNumber);
    }

    @DisplayName("4개의 숫자가 일치하는 로또는 순위 결과의 4순위에 저장한다.")
    @Test
    void saveRankResultOfLottoOfRank4() {
        int targetRank = 4;
        int ticketNumber = 4;

        lottos.add(new Lotto(List.of(1, 2, 3, 4, 12, 13)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 7, 13)));
        lottos.add(new Lotto(List.of(3, 4, 5, 6, 12, 13)));
        lottos.add(new Lotto(List.of(3, 4, 5, 6, 7, 13)));

        resultManager.generateResult(lottos);

        assertRankResult(targetRank, ticketNumber);
    }

    @DisplayName("5개의 숫자가 일치하고 보너스 번호가 일치하지 않는 로또는 순위 결과의 3순위에 저장한다.")
    @Test
    void saveRankResultOfLottoOfRank3() {
        int targetRank = 3;
        int ticketNumber = 3;

        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 13)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 6, 13)));
        lottos.add(new Lotto(List.of(3, 4, 5, 6, 1, 13)));

        resultManager.generateResult(lottos);

        assertRankResult(targetRank, ticketNumber);
    }

    @DisplayName("숫자 일치 개수 5개이고 보너스 번호가 일치하는 로또는 순위 결과의 2순위에 저장한다.")
    @Test
    void saveRankResultOfLottoOfRank2() {
        int targetRank = 2;
        int ticketNumber = 3;

        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        lottos.add(new Lotto(List.of(2, 3, 4, 5, 6, 7)));
        lottos.add(new Lotto(List.of(7, 1, 2, 3, 4, 5)));

        resultManager.generateResult(lottos);

        assertRankResult(targetRank, ticketNumber);
    }

    @DisplayName("6개의 숫자가 일치하는 로또는 순위 결과의 2순위에 저장한다.")
    @Test
    void saveRankResultOfLottoOfRank1() {
        int targetRank = 1;
        int ticketNumber = 3;

        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        resultManager.generateResult(lottos);

        assertRankResult(targetRank, ticketNumber);
    }

    @DisplayName("수익률을 계산해 반환한다.")
    @Test
    void calculateRateOfReturn() {
        lottos.add(new Lotto(List.of(1, 2, 3, 9, 10, 11)));
        int purchaseMoney = 80000;
        int prize = 5000;
        double rateOfReturn = (double) prize / purchaseMoney * 100;

        resultManager.generateResult(lottos);

        assertThat(resultManager.getRateOfReturn(purchaseMoney))
                .isEqualTo(rateOfReturn);
    }

}