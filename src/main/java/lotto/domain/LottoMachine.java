package lotto.domain;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoRewardCondition;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.LottosRepository;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.money.LottoMoney;
import lotto.dto.BuyingResults;
import lotto.dto.WinningResults;

// todo 기능 분리 시도
public class LottoMachine {

    private static final String NOT_FOUND_LOTTO = "[ERROR] 로또 번호가 존재하지 않습니다.";

    private final LottosRepository lottosRepository;

    public LottoMachine(final LottosRepository lottosRepository) {
        this.lottosRepository = lottosRepository;
    }

    public void buyLottos(final Supplier<List<Integer>> randomLottoSupplier, final int price) {
        LottoMoney lottoMoney = LottoMoney.from(price);
        List<Lotto> lottos = createLottos(randomLottoSupplier, lottoMoney);
        Lottos userLotto = new Lottos(lottos);
        lottosRepository.saveUserLottos(userLotto);
    }

    public BuyingResults createBuyingResults() {
        Lottos userLottos = findUserLottosObject();
        return BuyingResults.createFrom(userLottos);
    }

    public void addWinningLotto(final List<Integer> winningNumbers, final int bonusNumber) {
        WinningLotto winningLotto = WinningLotto.createFrom(winningNumbers, bonusNumber);
        lottosRepository.saveWinningLotto(winningLotto);
    }

    public WinningResults createWinningResult() {
        Lottos userLottos = findUserLottosObject();
        WinningLotto winningLotto = findWinningLottoObject();

        List<LottoRewardCondition> compareResults = userLottos.createCompareResults(winningLotto);
        return WinningResults.from(compareResults);
    }

    private List<Lotto> createLottos(final Supplier<List<Integer>> randomLottoSupplier, final LottoMoney lottoMoney) {
        return Stream.generate(randomLottoSupplier)
                .limit(lottoMoney.createBuyingCount())
                .map(Lotto::createFrom)
                .toList();
    }

    private Lottos findUserLottosObject() {
        return lottosRepository.findUserLottos()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_LOTTO));
    }

    private WinningLotto findWinningLottoObject() {
        return lottosRepository.findWinningLotto()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_LOTTO));
    }
}
