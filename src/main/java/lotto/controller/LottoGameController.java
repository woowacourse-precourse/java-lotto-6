package lotto.controller;

import java.util.Arrays;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoComparator;
import lotto.domain.LottoCreator;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.Lottos;
import lotto.domain.LottosResult;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    public void start() {
        int moneyAmount = askMoney();
        int lottoCount = getLottoCount(moneyAmount);
        Lottos lottos = getLottos(lottoCount);
        WinningLotto winningLotto = getWinningLotto();
        printLottosResult(moneyAmount, lottos, winningLotto);
    }

    private static void printLottosResult(int moneyAmount, Lottos lottos, WinningLotto winningLotto) {
        LottoComparator lottoComparator = new LottoComparator(lottos, winningLotto);
        LottosResult lottosResult = lottoComparator.compareLottoAndWinningLotto();
        lottosResult.calculateRateOfReturn(moneyAmount);
        OutputView.print(lottosResult.toString());
    }

    private static WinningLotto getWinningLotto() {
        OutputView.printWinningNumbersInputMessage();
        int[] winningNumbers = InputView.nextIntArray();
        Lotto winningNumber = new Lotto(Arrays.stream(winningNumbers).boxed().collect(Collectors.toList()));
        OutputView.printBonusNumberInputMessage();
        int bonusNumber = InputView.nextInt();
        WinningLotto winningLotto = new WinningLotto(winningNumber, bonusNumber);
        return winningLotto;
    }

    private static Lottos getLottos(int lottoCount) {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        LottoCreator lottoCreator = new LottoCreator(lottoNumberGenerator);
        Lottos lottos = lottoCreator.createLottos(lottoCount);
        OutputView.printLottos(lottos);
        return lottos;
    }

    private static int getLottoCount(int moneyAmount) {
        Money money = new Money(moneyAmount);
        int lottoCount = money.getDivideValue();
        OutputView.printBuyInfoMessage(lottoCount);
        return lottoCount;
    }

    private static int askMoney() {
        OutputView.printMoneyInputMessage();
        int moneyAmount = InputView.nextInt();
        return moneyAmount;
    }
}
