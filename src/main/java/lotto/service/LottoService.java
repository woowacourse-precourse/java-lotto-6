package lotto.service;

import lotto.domain.BonusNumber;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningCombination;
import lotto.domain.WinningNumbers;
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
        final Lottos lottos = lottoPublisher.createLottos(purchaseAmount);
        domainRepository.saveLottos(lottos);
        return lottos;
    }

    public void saveWinningCombination(
            final WinningNumbers winningNumbers, final BonusNumber bonusNumber) {
        domainRepository.saveWinningCombination(
                new WinningCombination(winningNumbers, bonusNumber));
    }
}
