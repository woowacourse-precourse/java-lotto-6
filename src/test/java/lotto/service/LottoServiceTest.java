package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.BonusNumber;
import lotto.domain.EarningRate;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningCombination;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningResult;
import lotto.repository.DomainRepository;
import lotto.utils.LottoPublisher;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

@DisplayName("로또 서비스 클래스에")
class LottoServiceTest {

    private final DomainRepository domainRepository = new DomainRepository();
    private final LottoService lottoService =
            new LottoService(domainRepository, new LottoPublisher());

    @DisplayName("구매 금액 저장 요청시 저장소에 저장한다.")
    @Test
    void savePurchaseAmount() {
        // given
        final PurchaseAmount expected = new PurchaseAmount(3000);

        // when
        lottoService.savePurchaseAmount(expected);

        // then
        assertThat(domainRepository.getPurchaseAmount()).isEqualTo(expected);
    }

    @DisplayName("구매 요청시 구매 금액에 맞게 구매한다.")
    @Test
    void purchase() {
        // given
        final int amount = 1000;
        lottoService.savePurchaseAmount(new PurchaseAmount(amount));

        // when
        final Lottos lottos = lottoService.purchase();

        // then
        assertThat(lottos.toElements()).hasSize(amount / 1000);
    }

    @DisplayName("당첨 정보 저장 요청시 저장소에 저장한다.")
    @Test
    void saveWinningCombination() {
        // given
        final WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        final BonusNumber bonusNumber = new BonusNumber(7);

        // when
        lottoService.saveWinningCombination(winningNumbers, bonusNumber);

        // then
        assertThat(domainRepository.getWinningCombination()).isNotNull();
    }

    @DisplayName("당첨 정보 계산 요청시 계산 후 당첨 정보를 반환한다.")
    @Test
    void calculateWinningResult() {
        // given
        domainRepository.saveLottos(new Lottos(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)))));
        domainRepository.saveWinningCombination(
                new WinningCombination(
                        new WinningNumbers(List.of(1, 2, 3, 4, 5, 6)), new BonusNumber(7)));

        // when
        final WinningResult winningResult = lottoService.calculateWinningResult();

        // then
        assertThat(winningResult).isNotNull();
    }

    @DisplayName("수익률 계산 요청시 계산 후 수익률을 반환한다.")
    @Test
    void checkEarningRate() {
        // given
        domainRepository.savePurchaseAmount(new PurchaseAmount(1000));
        domainRepository.saveWinningResult(new WinningResult(Map.of()));

        // when
        final EarningRate earningRate = lottoService.checkEarningRate();

        // then
        assertThat(earningRate).isNotNull();
    }
}
