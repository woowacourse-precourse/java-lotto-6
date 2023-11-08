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
                     SortPolicy sortPolicy) {

        this.console = console;
        this.rule = new Rule(numberGeneratePolicy, pricePolicy, sortPolicy);
    }

    public void run() {
        Store store = new Store(console.readMoney(), rule.pricePolicy());
        int lottoCount = store.getLottoCount(rule.pricePolicy());
        console.printLottoCount(lottoCount);

        //로또번호 생성
        List<Lotto> generate = new LottoNumberGenerator(rule.numberGeneratePolicy()).generate(lottoCount);
        console.printLottos(LottoResult.of(generate, rule.sortPolicy()));
        Lottos lottos = new Lottos(generate);
        // 당첨 번호 입력 받기
        WinningNumbers winningNumbers = WinningNumbers.of(console.readWinningNumbers());
        // 보너스 번호 입력 받기
        BonusNumber bonusNumber = new BonusNumber(console.readBonusNumber(), winningNumbers);

        // 당첨 통계 및 수익률 출력
        LottoResults lottoResults = new LottoResults(lottos.convertToRank(winningNumbers, bonusNumber));
        double profitRate = lottoResults
                .calculateTotalProfitRate(store.getMoney());

        GameResult gameResult = GameResult.of(lottoResults, profitRate);
        console.printLottoResults(gameResult);
    }

}
