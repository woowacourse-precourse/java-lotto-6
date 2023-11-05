package lotto.controller;

import lotto.domain.LottoCreator;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    public void start() {
        OutputView.printMoneyInputMessage();
        int moneyAmount = InputView.nextInt();
        Money money = new Money(moneyAmount);
        int lottoCount = money.getDivideValue();
        OutputView.printBuyInfoMessage(lottoCount);
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        LottoCreator lottoCreator = new LottoCreator(lottoNumberGenerator);
        Lottos lottos = lottoCreator.createLottos(lottoCount);
        OutputView.printLottos(lottos);

    }
}
