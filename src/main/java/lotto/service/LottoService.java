package lotto.service;

import lotto.domain.LottoResult;
import lotto.domain.LottoTickets;
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
    private LottoTickets lottoTickets;
    private Money money;
    private LottoResult lottoResult;


    public LottoService(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<List<Integer>> generateLottos(String moneyInput) {
        this.money = Money.of(moneyInput);

        List<List<Integer>> generateNumbers = getGenerateNumbers();

        this.lottoTickets = LottoTickets.generateLottos(generateNumbers);

        return generateNumbers;
    }

    public void createWinningLotto(List<String> inputLotto, String bonusInput) {
        this.winningLotto = WinningLotto.createWinningLotto(inputLotto, bonusInput);
    }

    public Map<LottoPrize, Integer> getLottoResults() {
        this.lottoResult = LottoResult.createLottoResult(winningLotto, lottoTickets);

        return lottoResult.getLottoPrizesHistory();
    }

    public double getProfitRate() {
        return lottoResult
                .calculateProfitOnInvestment(money);
    }

    public int getPurchaseLottoCount() {
        return money.getCountBuyLotto();
    }

    private List<List<Integer>> getGenerateNumbers() {
        List<List<Integer>> generateNumber = IntStream.range(0, money.getCountBuyLotto())
                .mapToObj(i -> numberGenerator.generate())
                .collect(Collectors.toList());

        return generateNumber;
    }
}
