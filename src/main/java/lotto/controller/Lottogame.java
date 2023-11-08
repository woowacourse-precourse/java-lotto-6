package lotto.controller;


import static lotto.view.OutputLottolist.printLottoList;
import static lotto.view.OutputStatics.printStatistics;

import java.util.List;
import lotto.domain.InputNumber;
import lotto.domain.LottoResult;
import lotto.domain.Rate;
import lotto.domain.Winner;
import lotto.parser.ParserLotto;
import lotto.domain.GenerateLotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.view.OutputMoney;
import lotto.view.OutputView;
import lotto.view.Request;

public class Lottogame {
    public void start() {
        Money money = getLottoMoney();
        int count = money.countMoney();
        OutputMoney.resultMoney(count);

        Lottos lottos = getLottos(money);
        printLottoList(lottos);

        Winner winner = getWinningLotto();
        LottoResult lottoResult = new LottoResult();
        calcLottoResult(lottoResult, winner, lottos);

        Rate rate = getRate(money, lottoResult);
        printStatistics(lottoResult, rate);
    }

    private Money getLottoMoney() {
        Request request = new Request();
        int money = ParserLotto.lottoParser(request.requestNubmer());
        return new Money(money);
    }

    private Lottos getLottos(Money money) {
        GenerateLotto lottoGenerator = new GenerateLotto();
        return new Lottos(lottoGenerator.generateLottoGroup(money.countMoney()));
    }

    private Winner getWinningLotto() {
        InputNumber inputUserNumber = new InputNumber();
        InputNumber inPutBonusNumber = new InputNumber();

        System.out.println(OutputView.ASK_INPUT_NUMBER.getMessage());
        List<Integer> winningNumbers = inputUserNumber.InputLottos();

        System.out.println(OutputView.ASK_INPUT_BONUS.getMessage());
        Integer bonusNumber = inPutBonusNumber.InputBonus();

        return new Winner(winningNumbers, bonusNumber);
    }
    private void calcLottoResult(LottoResult prizeResult, Winner winningLotto, Lottos lottos) {
        prizeResult.calcPrizeResult(winningLotto, lottos);
    }
    private Rate getRate(Money money, LottoResult lottoResult) {
        return new Rate(money, lottoResult);
    }
}
