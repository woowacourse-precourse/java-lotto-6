package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.model.Bonus;
import lotto.model.LotteryMachine;
import lotto.model.LotteryResult;
import lotto.model.Lotto;
import lotto.model.Number;
import lotto.model.PersonLotto;
import lotto.model.PurchaseMoney;
import lotto.model.WinningLotto;
import lotto.model.enums.WinningMoney;
import lotto.util.NumbersGenerator;
import lotto.util.RandomNumbersGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;

    private final OutputView outputView;

    private NumbersGenerator generate;

    private LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public static LottoController init(InputView inputView, OutputView outputView) {
        return new LottoController(inputView, outputView);
    }

    public void start() {
        generate = new RandomNumbersGenerator();

        PurchaseMoney purchaseMoney = initPurchaseMoney();
        PersonLotto personLotto = initPersonLotto(generate, purchaseMoney);

        WinningLotto winningLotto = initWinningNumbers();
        Bonus bonus = initBonusNumber(winningLotto);
        LotteryMachine lotteryMachine = initLotteryMachine(personLotto, winningLotto);

        result(lotteryMachine, bonus, purchaseMoney);
    }

    private void result(LotteryMachine lotteryMachine, Bonus bonus, PurchaseMoney purchaseMoney) {
        Map<WinningMoney, Integer> result = lotteryMachine.drawingLotto(bonus);
        LotteryResult lotteryResult = new LotteryResult(result);
        outputView.outputStatistics(lotteryResult, purchaseMoney);
    }

    private LotteryMachine initLotteryMachine(PersonLotto personLotto, WinningLotto winningLotto) {
        LotteryMachine lotteryMachine = new LotteryMachine(personLotto, winningLotto);
        return lotteryMachine;
    }

    private PersonLotto initPersonLotto(NumbersGenerator generate, PurchaseMoney purchaseMoney) {
        PersonLotto personLotto = new PersonLotto(generate, purchaseMoney);
        outputView.outputPurchase(purchaseMoney, personLotto);
        return personLotto;
    }

    private PurchaseMoney initPurchaseMoney() {
        PurchaseMoney purchaseMoney;

        while (true) {
            try {
                int inputMoney = inputView.inputPurchaseMoneyOfLotto();
                purchaseMoney = new PurchaseMoney(inputMoney);
                break;
            } catch (IllegalArgumentException ex) {
                outputView.outputErrorMessage(ex);
            }
        }
        return purchaseMoney;
    }

    private WinningLotto initWinningNumbers() {
        WinningLotto winningLotto;

        while (true) {
            try {
                List<Integer> input = inputView.inputWinningNumbers();
                Lotto lotto = new Lotto(input);
                winningLotto = new WinningLotto(lotto);
                break;
            } catch (IllegalArgumentException ex) {
                outputView.outputErrorMessage(ex);
            }
        }
        System.out.println();
        return winningLotto;
    }

    private Bonus initBonusNumber(WinningLotto winningLotto) {
        Bonus bonus;

        while (true) {
            try {
                bonus = new Bonus(new Number(inputView.inputBonusNumber()), winningLotto);
                break;
            } catch (IllegalArgumentException ex) {
                outputView.outputErrorMessage(ex);
            }
        }
        return bonus;
    }
}
