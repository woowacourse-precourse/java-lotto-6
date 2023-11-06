package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.function.Supplier;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoRewardCondition;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.LottoRepository;
import lotto.domain.lotto.WinningLotto;
import lotto.dto.BuyingResults;
import lotto.dto.WinningResults;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    LottoRepository lottoRepository;
    LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        lottoRepository = new LottoRepository();
        lottoMachine = new LottoMachine(lottoRepository);
    }

    @DisplayName("로또를 구매할 수 있다.")
    @Test
    void buyLottos() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        WinningLotto winningLotto = WinningLotto.createFrom(lottoNumbers, 7);
        Supplier<List<Integer>> stubLottoSupplier = () -> lottoNumbers;
        int price = 2000;

        // when
        lottoMachine.buyLottos(stubLottoSupplier, price);
        Lottos lottos = lottoRepository.findUserLottos().get();
        List<LottoRewardCondition> results = lottos.createCompareResults(winningLotto);

        // then
        assertThat(results).containsExactly(LottoRewardCondition.FIRST_WINNER, LottoRewardCondition.FIRST_WINNER);
    }

    @DisplayName("로또 구매 결과를 받을 수 있다.")
    @Test
    void createBuyingResults() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        Supplier<List<Integer>> stubLottoSupplier = () -> lottoNumbers;
        int price = 1000;

        // when
        lottoMachine.buyLottos(stubLottoSupplier, price);
        BuyingResults buyingResults = lottoMachine.createBuyingResults();
        String resultMessage = buyingResults.createResultMessage();

        // then
        assertThat(resultMessage).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @DisplayName("당첨 로또를 저장할 수 있다.")
    @Test
    void addWinningLotto() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        Lotto lotto = Lotto.createFrom(List.of(1, 2, 3, 4, 5, 7));

        // when
        lottoMachine.addWinningLotto(lottoNumbers, bonusNumber);
        WinningLotto winningLotto = lottoRepository.findWinningLotto().get();
        LottoRewardCondition result = winningLotto.getCompareResult(lotto);

        // then
        assertThat(result).isEqualTo(LottoRewardCondition.SECOND_WINNER);
    }

    @DisplayName("로또 구매와 당첨 로또 등록 이후 당첨 결과를 만들 수 있다.")
    @Test
    void createWinningResult() {
        // given
        double expectedProfitRatio = LottoRewardCondition.SECOND_WINNER.getRewardMoney() * 2 / 2000.0 * 100;
        lottoMachine.buyLottos(() -> List.of(1, 2, 3, 4, 5, 6), 2000);
        lottoMachine.addWinningLotto(List.of(1, 2, 3, 4, 5, 7), 6);

        // when
        WinningResults winningResults = lottoMachine.createWinningResults();
        List<Integer> winningCounts = winningResults.calculateWinningCounts();
        double actualProfitRatio = winningResults.calculateProfitRatio();

        // then
        assertAll(
                () -> assertThat(winningCounts).containsExactly(0, 0, 0, 2, 0),
                () -> assertThat(actualProfitRatio).isEqualTo(expectedProfitRatio)
        );
    }
}