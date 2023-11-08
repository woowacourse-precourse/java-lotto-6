package controller;

import enums.WinType;
import java.util.Collections;
import java.util.List;
import model.PurchasedLotto;
import model.WinLotto;
import view.InputView;
import view.OutputView;

public class LottoController {

    WinLotto winLotto;
    PurchasedLotto purchasedLotto;
    InputView inputView;
    OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void purchase() {
        int amount;

        amount = getPurchaseAmount();
        purchasedLotto = new PurchasedLotto(amount);

        printPurchaseResult(amount);
    }

    private int getPurchaseAmount() {
        while (true) {
            try {
                return inputView.amountInput() / 1000;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printPurchaseResult(int amount) {
        outputView.purchaseResult(amount);
        for (String s : purchasedLotto.getPurchasedLotto()) {
            System.out.println(s);
        }
    }

    public void setWinLotto() {
        List<Integer> winLottoInput;

        winLottoInput = getWinLottoInput();
        Integer bonus = inputView.bonusInput();

        winLotto = new WinLotto(winLottoInput, bonus);
    }

    private List<Integer> getWinLottoInput() {
        while (true) {
            try {
                return inputView.winLottoInput();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void checkLottoes() {
        List<Integer> winLottoNumbers;
        List<WinType> checkResult;
        Integer bonus;

        winLottoNumbers = winLotto.getNumbers();
        bonus = winLotto.getBonus();

        checkResult = purchasedLotto.checkLotto(winLottoNumbers, bonus);

        printResult(checkResult);
    }

    private void printResult(List<WinType> checkResult) {
        int price = purchasedLotto.getAmount() * 1000;
        int total = 0;

        outputView.resultHeader();

        for (WinType e : WinType.values()) {
            int frequency = Collections.frequency(checkResult, e);
            outputView.printResult(frequency, e);
            total += e.getReward() * frequency;
        }

        printEarnRate(total, price);
    }

    private void printEarnRate(int total, int price) {
        String earnRateText;
        earnRateText = String.format("%.1f", (double) (total * 100) / (double) price);
        outputView.earnRate(earnRateText);
    }


}
