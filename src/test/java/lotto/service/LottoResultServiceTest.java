package lotto.service;

import lotto.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


class LottoResultServiceTest {
    private LottoResultService lottoResultService;

    @BeforeEach
    void setUp() {
        this.lottoResultService = new LottoResultService();
    }

    @DisplayName("구매한 로또와 당첨 번호를 입력 받고 맞춘 번호 수를 정상적으로 반환하는지")
    @Test
    void countMatchingNumbers() {
        // given
        WinningLotto winningLotto = new WinningLotto(List.of(1,2,3,4,5,6), new BonusNumber(7));
        LottoService lottoService = new LottoService();
        PurchasedLotto purchasedLotto = new PurchasedLotto();

        List<Integer> randomNumbers = lottoService.createRandomNumbers();
        purchasedLotto.addLotto(new Lotto(randomNumbers));

        // when
        List<LottoResult> lottoResults = lottoResultService.countMatchingNumbers(purchasedLotto, winningLotto);

        // then
        for (LottoResult lottoResult : lottoResults) {
            assertThat(lottoResult.getCorrectNumbers()).isBetween(0,6);
            assertThat(lottoResult.getCorrectBonusNumber()).isIn(true, false);
        }
    }

    @DisplayName("로또 결과를 통해 몇 등인지와 당첨 금액을 반환하는지")
    @Test
    void confirmRewardLottos() {
        // given
        List<LottoResult> lottoResults = createLottoResultsTestObject();

        // when
        Map<LottoReward, Integer> rewardCount = lottoResultService.confirmRewardLottos(lottoResults);

        // then
        Arrays.stream(LottoReward.values())
                .forEach(reward -> assertThat(rewardCount.get(reward)).isEqualTo(1));
    }

    private List<LottoResult> createLottoResultsTestObject() {
        List<LottoResult> lottoResults = new ArrayList<>();

        lottoResults.add(new LottoResult(6, false));
        lottoResults.add(new LottoResult(5, true));
        lottoResults.add(new LottoResult(5, false));
        lottoResults.add(new LottoResult(4, false));
        lottoResults.add(new LottoResult(3, false));
        lottoResults.add(new LottoResult(0, false));

        return lottoResults;
    }

    @Test
    void countEarnRate() {
    }
}