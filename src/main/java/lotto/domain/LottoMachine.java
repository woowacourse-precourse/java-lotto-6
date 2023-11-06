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
        Lottos userLotto = Lottos.createFrom(randomLottoSupplier, lottoMoney);
        lottoRepository.saveUserLottos(userLotto);
    }

    public BuyingResults createBuyingResults() {
        Lottos userLottos = findUserLottosObject();
        return BuyingResults.createFrom(userLottos);
    }

    public void addWinningLotto(final List<Integer> winningNumbers, final int bonusNumber) {
        WinningLotto winningLotto = WinningLotto.createFrom(winningNumbers, bonusNumber);
        lottoRepository.saveWinningLotto(winningLotto);
    }

    public WinningResults createWinningResults() {
        Lottos userLottos = findUserLottosObject();
        WinningLotto winningLotto = findWinningLottoObject();
        List<LottoRewardCondition> compareResults = userLottos.createCompareResults(winningLotto);
        return WinningResults.createFrom(compareResults);
    }

    private Lottos findUserLottosObject() {
        return lottoRepository.findUserLottos()
                .orElseThrow(DomainExceptionMessage.NOT_FOUND_LOTTO::create);
    }

    private WinningLotto findWinningLottoObject() {
        return lottoRepository.findWinningLotto()
                .orElseThrow(DomainExceptionMessage.NOT_FOUND_LOTTO::create);
    }
}
