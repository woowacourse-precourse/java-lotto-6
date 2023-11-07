package lotto.service;

import lotto.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    void confirmRewardLottos() {
    }

    @Test
    void countEarnRate() {
    }
}