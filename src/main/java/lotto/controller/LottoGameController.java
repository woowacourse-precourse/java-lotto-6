package lotto.controller;

import java.util.Arrays;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoCreator;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
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
        OutputView.printWinningNumbersInputMessage();
        int[] winningNumbers = InputView.nextIntArray();
        Lotto winningNumber = new Lotto(Arrays.stream(winningNumbers).boxed().collect(Collectors.toList()));
        OutputView.printBonusNumberInputMessage();
        int bonusNumber = InputView.nextInt();
        WinningLotto winningLotto = new WinningLotto(winningNumber, bonusNumber);


    }
}
