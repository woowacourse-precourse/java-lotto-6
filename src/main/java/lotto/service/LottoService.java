package lotto.service;

import lotto.domain.BonusNumber;
import lotto.domain.EarningRate;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningCombination;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningResult;
import lotto.repository.DomainRepository;
import lotto.utils.LottoPublisher;

public class LottoService {

    private final DomainRepository domainRepository;
    private final LottoPublisher lottoPublisher;

    public LottoService(
            final DomainRepository domainRepository, final LottoPublisher lottoPublisher) {
        this.domainRepository = domainRepository;
        this.lottoPublisher = lottoPublisher;
    }

    public void savePurchaseAmount(final PurchaseAmount purchaseAmount) {
        domainRepository.savePurchaseAmount(purchaseAmount);
    }

    public Lottos purchase() {
        final PurchaseAmount purchaseAmount = domainRepository.getPurchaseAmount();
        final Lottos lottos = lottoPublisher.publish(purchaseAmount);
        domainRepository.saveLottos(lottos);
        return lottos;
    }

    public void saveWinningCombination(
            final WinningNumbers winningNumbers, final BonusNumber bonusNumber) {
        domainRepository.saveWinningCombination(
                new WinningCombination(winningNumbers, bonusNumber));
    }

    public WinningResult calculateWinningResult() {
        final Lottos lottos = domainRepository.getLottos();
        final WinningCombination winningCombination = domainRepository.getWinningCombination();

        final WinningResult winningResult = winningCombination.calculateWinningLottos(lottos);
        domainRepository.saveWinningResult(winningResult);
        return winningResult;
    }

    public EarningRate checkEarningRate() {
        final PurchaseAmount purchaseAmount = domainRepository.getPurchaseAmount();
        final WinningResult winningResult = domainRepository.getWinningResult();

        return winningResult.calculateProfit(purchaseAmount);
    }
}
