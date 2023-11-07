package lotto.controller;

import java.util.Arrays;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoComparator;
import lotto.domain.LottoCreator;
import lotto.domain.Lottos;
import lotto.domain.LottosResult;
import lotto.domain.Money;
import lotto.domain.NumberGenerator;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    private final LottoCreator lottoCreator;
    private final NumberGenerator numberGenerator;

    public LottoGameController(LottoCreator lottoCreator, NumberGenerator numberGenerator) {
        this.lottoCreator = lottoCreator;
        this.numberGenerator = numberGenerator;
    }

    public void start() {
        int moneyAmount = askMoney();
        int lottoCount = calculateLottoCount(moneyAmount);
        Lottos lottos = generateLottos(lottoCount);
        WinningLotto winningLotto = createWinningLotto();
        printLottosResult(moneyAmount, lottos, winningLotto);
    }

    private void printLottosResult(int moneyAmount, Lottos lottos, WinningLotto winningLotto) {
        LottoComparator lottoComparator = new LottoComparator(lottos, winningLotto);
        LottosResult lottosResult = lottoComparator.compareLottoAndWinningLotto();
        lottosResult.calculateRateOfReturn(moneyAmount);
        OutputView.print(lottosResult.toString());
    }

    private WinningLotto createWinningLotto() {
        Lotto winningNumber = inputWinningNumbers();
        int bonusNumber = inputBonusNumber();
        WinningLotto winningLotto = new WinningLotto(winningNumber, bonusNumber);
        return winningLotto;
    }

    private Lotto inputWinningNumbers() {
        OutputView.printWinningNumbersInputMessage();
        int[] winningNumbers = InputView.nextIntArray();
        return new Lotto(Arrays.stream(winningNumbers).boxed().collect(Collectors.toList()));
    }

    private int inputBonusNumber() {
        OutputView.printBonusNumberInputMessage();
        return InputView.nextInt();
    }

    private Lottos generateLottos(int lottoCount) {
        Lottos lottos = lottoCreator.createLottos(lottoCount);
        OutputView.printLottos(lottos);
        return lottos;
    }

    private int calculateLottoCount(int moneyAmount) {
        Money money = new Money(moneyAmount);
        int lottoCount = money.getDivideValue();
        OutputView.printBuyInfoMessage(lottoCount);
        return lottoCount;
    }

    private int askMoney() {
        OutputView.printMoneyInputMessage();
        int moneyAmount = InputView.nextInt();
        return moneyAmount;
    }
}
