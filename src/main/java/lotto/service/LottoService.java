package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.domain.constant.LottoPrize;
import lotto.domain.generator.NumberGenerator;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoService {

    private final NumberGenerator numberGenerator;
    private WinningLotto winningLotto;
    private List<Lotto> lottos;
    private Money money;
    private LottoResult lottoResult;

    public LottoService(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<List<Integer>> generateLottos(String moneyInput) {
        this.money = Money.of(moneyInput);

        List<List<Integer>> generateNumber = IntStream.range(0, money.getCountBuyLotto())
                .mapToObj(i -> numberGenerator.generate())
                .collect(Collectors.toList());

        this.lottos = generateNumber.stream()
                .map(numbers -> new Lotto(numbers))
                .collect(Collectors.toList());

        return generateNumber;
    }

    public void createWinningLotto(List<String> inputLotto, String bonusInput) {
        this.winningLotto = WinningLotto.createWinningLotto(inputLotto, bonusInput);
    }

    public Map<LottoPrize, Integer> getLottoResults() {
        this.lottoResult = LottoResult.createLottoResult(winningLotto, lottos);

        return lottoResult.getLottoPrizesHistory();
    }

    public double getProfitRate() {
        return this.lottoResult
                .calculateProfitOnInvestment(this.money);
    }

    public int getPurchaseLottoCount() {
        return money.getCountBuyLotto();
    }
}
