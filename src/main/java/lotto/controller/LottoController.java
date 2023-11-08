package lotto.controller;


import static lotto.util.Util.changeStringToInt;
import static lotto.validator.LottoInputValidator.validateBonusNumber;
import static lotto.validator.LottoInputValidator.validatePurchaseMoney;
import static lotto.view.InputView.showInputBonusNumberMessage;
import static lotto.view.InputView.showInputPurchaseMoneyMessage;
import static lotto.view.InputView.showInputWinningNumbersMessage;
import static lotto.view.OutputBuyLottoCount.printBuyLotto;
import static lotto.view.PrintView.printErrorMessage;
import static lotto.view.PrintView.printLottoNumbers;
import static lotto.view.PrintView.printStatistics;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.LottoGenerator;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.PrizeResult;
import lotto.domain.Rate;
import lotto.domain.Service;
import lotto.domain.WinningLotto;
import lotto.domain.WinningNumber;
import lotto.util.Util;
import lotto.validator.LottoInputValidator;
import lotto.view.PrintView;

public class LottoController {
    PrintView printView = new PrintView();
    Service service = new Service();

    public void run() {
        Money money = getLottoMoney();
        printBuyLotto(money);

        Lottos lottos = getLottos(money);
        printLottoNumbers(lottos);

        WinningLotto winningLotto = getWinningLotto();
        PrizeResult prizeResult = new PrizeResult();
        calcLottoResult(prizeResult, winningLotto, lottos);

        Rate rate = getRate(money, prizeResult);
        printStatistics(prizeResult, rate);
    }


    private Money getLottoMoney() {
        int money = getPurchaseMoney();
        return new Money(money);
    }

    private Lottos getLottos(Money money) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        return new Lottos(lottoGenerator.generateLottos(money.getTicket()));
    }

    private int getBonusNumber() {
        showInputBonusNumberMessage();
        return inputBonusNumber();
    }


    private int getPurchaseMoney() {
        showInputPurchaseMoneyMessage();
        return inputPurchaseMoney();
    }

    private void printLottos(int money) {
        Lottos lottos = buyLottos(money);
        printView.printNumberOfLottos(money);
        printView.printLottoNumbers(lottos);
    }

    private List<Integer> getWinningNumbers() {
        showInputWinningNumbersMessage();
        return inputWinningNumbers();
    }

    private Lottos buyLottos(int money) {
        int lottoSize = service.getNumberOfLottos(money);
        LottoGenerator generator = new LottoGenerator();
        Lottos lottos = new Lottos(generator.generateLottos(lottoSize));
        return lottos;
    }

    private Rate getRate(Money money, PrizeResult prizeResult) {
        return new Rate(money, prizeResult);
    }

    private WinningLotto getWinningLotto() {
        showInputWinningNumbersMessage();
        List<Integer> winningNumbers = inputWinningNumbers();
        showInputBonusNumberMessage();
        Integer bonusNumber = inputBonusNumber();

        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private void calcLottoResult(PrizeResult prizeResult, WinningLotto winningLotto, Lottos lottos) {
        prizeResult.calcPrizeResult(winningLotto, lottos);
    }

    public List<Integer> inputWinningNumbers() {
        WinningNumber winningNumber = null;

        while (winningNumber == null) {
            try {
                winningNumber = getValidWinningNumber();
            } catch (IllegalArgumentException e) {
                printErrorMessage(e);
            }
        }

        return winningNumber.getWinningNumbers();
    }

    private WinningNumber getValidWinningNumber() {
        String input = Console.readLine();
        LottoInputValidator.validateWinningNumber(input);
        List<Integer> numbers = Util.changeStringToList(input);
        return new WinningNumber(numbers);
    }

    public int inputBonusNumber() {
        BonusNumber bonusNumber = new BonusNumber();
        boolean validInput = false;

        while (!validInput) {
            try {
                String input = Console.readLine();
                validateBonusNumber(input);
                bonusNumber.setBonusNumber(changeStringToInt(input));
                validInput = true;
            } catch (IllegalArgumentException e) {
                printErrorMessage(e);
            }
        }
        return bonusNumber.getBonusNumber();
    }

    public int inputPurchaseMoney() {
        boolean validInput = false;
        int purchaseMoney = 0;

        while (!validInput) {
            try {
                String input = Console.readLine();
                validatePurchaseMoney(input);
                purchaseMoney = changeStringToInt(input);
                validInput = true;
            } catch (IllegalArgumentException e) {
                printErrorMessage(e);
            }
        }
        return purchaseMoney;
    }
}
