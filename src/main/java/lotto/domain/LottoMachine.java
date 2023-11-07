package lotto.domain;

import java.util.List;
import java.util.function.Supplier;
import lotto.domain.lotto.LottoRepository;
import lotto.domain.lotto.LottoRewardCondition;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.money.LottoMoney;
import lotto.dto.BuyingResults;
import lotto.dto.WinningResults;
import lotto.validator.domain.exception.DomainExceptionMessage;

public class LottoMachine {

    private final LottoRepository lottoRepository;

    public LottoMachine(final LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    public void buyLottos(final Supplier<List<Integer>> randomLottoSupplier, final int price) {
        LottoMoney lottoMoney = LottoMoney.from(price);
        Lottos buyingLottos = Lottos.createFrom(randomLottoSupplier, lottoMoney);
        lottoRepository.saveBuyingLottos(buyingLottos);
    }

    public BuyingResults createBuyingResults() {
        Lottos buyingLottos = findBuyingLottosObject();
        return BuyingResults.createFrom(buyingLottos);
    }

    public void addWinningLotto(final List<Integer> winningNumbers, final int bonusNumber) {
        WinningLotto winningLotto = WinningLotto.createFrom(winningNumbers, bonusNumber);
        lottoRepository.saveWinningLotto(winningLotto);
    }

    public WinningResults createWinningResults() {
        Lottos buyingLottos = findBuyingLottosObject();
        WinningLotto winningLotto = findWinningLottoObject();
        List<LottoRewardCondition> compareResults = buyingLottos.createCompareResults(winningLotto);
        return WinningResults.createFrom(compareResults);
    }

    private Lottos findBuyingLottosObject() {
        return lottoRepository.findBuyingLottos()
                .orElseThrow(DomainExceptionMessage.NOT_FOUND_LOTTO::create);
    }

    private WinningLotto findWinningLottoObject() {
        return lottoRepository.findWinningLotto()
                .orElseThrow(DomainExceptionMessage.NOT_FOUND_LOTTO::create);
    }
}
