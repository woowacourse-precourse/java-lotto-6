package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.PrizeRank;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
     void setUp() {
        lottoService = new LottoService();
    }


    @Test
    @DisplayName("구입금액 akwrp 정확한 수량만큼 로또를 발행해야 한다")
    void purchaseLottosTest() {
        int purchaseAmount = 5000;
        List<Lotto> purchasedLottos = lottoService.purchaseLottos(purchaseAmount);
        assertThat(purchasedLottos).hasSize(purchaseAmount / 1000);
    }

    @Test
    @DisplayName("당첨 로또를 올바르게 생성해야 한다")
    void generateWinningLottoTest() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningLotto winningLotto = lottoService.generateWinningLotto(winningNumbers, bonusNumber);
        assertThat(winningLotto.getLotto().getNumbers()).containsExactlyInAnyOrderElementsOf(winningNumbers);
        assertThat(winningLotto.getBonusNumber()).isEqualTo(bonusNumber);
    }

    @Test
    @DisplayName("로또 1등에 당첨됐는지 정확하게 판단할줄 알아야 한다.")
    void checkFirstRankTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        assertThat(lottoService.checkWinningRank(lotto, winningLotto)).isEqualTo(PrizeRank.FIRST);
    }

    @Test
    @DisplayName("로또 2등에 당첨됐는지 정확하게 판단할줄 알아야 한다")
    void checkSecondRankTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        assertThat(lottoService.checkWinningRank(lotto, winningLotto)).isEqualTo(PrizeRank.SECOND);
    }

    @Test
    @DisplayName("로또 5등에 당첨됐는지 정확하게 판단할줄 알아야 한다")
    void checkFifthRankTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        assertThat(lottoService.checkWinningRank(lotto, winningLotto)).isEqualTo(PrizeRank.FIFTH);
    }

    @Test
    @DisplayName("로또 리스트의 각 등수를 결정할 수 있어야 한다")
    void determinePrizeRankTest() {
        List<Lotto> lottoPapers = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new Lotto(Arrays.asList(8, 9, 10, 11, 12, 13))
        );
        WinningLotto winningLotto = new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);
        List<PrizeRank> prizeRanks = lottoService.determinePrizeRank(lottoPapers, winningLotto);
        assertThat(prizeRanks).containsExactly(PrizeRank.FIRST, PrizeRank.SECOND, PrizeRank.NONE);
    }
    @Test
    @DisplayName("로또에 당첨이 되지 않았는지 판단해야한다.")
    void checkNoneRankTest() {
        Lotto lotto = new Lotto(List.of(10, 12, 13, 18, 19, 20));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        assertThat(lottoService.checkWinningRank(lotto, winningLotto)).isEqualTo(PrizeRank.NONE);
    }

    @Test
    @DisplayName("상금의 총합을 정확하게 계산할 수 있어야 한다")
    void calculateTotalPrizeTest() {
        List<PrizeRank> ranks = Arrays.asList(PrizeRank.FIRST, PrizeRank.SECOND, PrizeRank.THIRD);
        double totalPrize = lottoService.calculateTotalPrize(ranks);
        assertThat(totalPrize).isEqualTo(PrizeRank.FIRST.getPrizeMoney() +
                PrizeRank.SECOND.getPrizeMoney() +
                PrizeRank.THIRD.getPrizeMoney());
    }
}
