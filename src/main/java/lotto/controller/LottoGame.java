package lotto.controller;

import lotto.controller.dto.GameResult;
import lotto.controller.dto.LottoResult;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.LottoResults;
import lotto.domain.Lottos;
import lotto.domain.Store;
import lotto.domain.WinningNumbers;
import lotto.domain.policy.LottoNumberGeneratePolicy;
import lotto.domain.policy.NumberGeneratePolicy;
import lotto.view.Console;

import java.util.List;

public class LottoGame {

    private final Console console;

    public LottoGame(Console console) {
        this.console = console;
    }

    public void run() {
        //구매입력 받기 _ view
        Store store = new Store(console.readMoney());

        int lottoCount = store.getLottoCount();
        console.printLottoCount(lottoCount);

        //로또번호 생성
        NumberGeneratePolicy numberGeneratePolicy = new LottoNumberGeneratePolicy();

        List<Lotto> generate = new LottoNumberGenerator(numberGeneratePolicy).generate(lottoCount);
        console.printLottos(LottoResult.of(generate));
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
