package lotto.controller;

import lotto.controller.dto.GameResult;
import lotto.controller.dto.LottoResult;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.LottoResults;
import lotto.domain.Lottos;
import lotto.controller.dto.Rule;
import lotto.domain.Store;
import lotto.domain.WinningNumbers;
import lotto.policy.SortPolicy;
import lotto.policy.NumberGeneratePolicy;
import lotto.policy.PricePolicy;
import lotto.view.Console;

import java.util.List;

public class LottoGame {

    private final Console console;
    private final Rule rule;

    public LottoGame(Console console,
                     PricePolicy pricePolicy,
                     NumberGeneratePolicy numberGeneratePolicy,
                     SortPolicy<?> sortPolicy) {

        this.console = console;
        this.rule = new Rule(numberGeneratePolicy, pricePolicy, sortPolicy);
    }

    public void run() {
        Store store = new Store(console.readMoney(), rule.pricePolicy());
        int lottoCount = store.getLottoCount(rule.pricePolicy());
        console.printLottoCount(lottoCount);

        List<Lotto> lottos = new LottoNumberGenerator(rule.numberGeneratePolicy())
                .generate(lottoCount);
        console.printLottos(LottoResult.of(lottos, rule.sortPolicy()));
        printGameResult(lottos, store);
    }

    private void printGameResult(List<Lotto> input, Store store) {
        Lottos lottos = new Lottos(input);

        WinningNumbers winningNumbers = WinningNumbers.of(console.readWinningNumbers());
        BonusNumber bonusNumber = new BonusNumber(console.readBonusNumber(), winningNumbers);

        LottoResults lottoResults = new LottoResults(lottos.convertToRank(winningNumbers, bonusNumber));
        double profitRate = lottoResults.calculateTotalProfitRate(store.getMoney());
        console.printLottoResults(GameResult.of(lottoResults, profitRate));
    }

}
