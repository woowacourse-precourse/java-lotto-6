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
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void purchase() {
        int amount;

        while (true) {
            try {
                amount = inputView.amountInput() / 1000;
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        purchasedLotto = new PurchasedLotto(amount);
        purchaseResult(amount);
    }

    private void purchaseResult(int amount) {
        outputView.purchaseResult(amount);
        for (String s : purchasedLotto.getPurchasedLotto()) {
            System.out.println(s);
        }
    }

    public void setWinLotto() {
        List<Integer> winLottoInput;

        while (true) {
            try {
                winLottoInput = inputView.winLottoInput();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        Integer bonus = inputView.bonusInput();
        winLotto = new WinLotto(winLottoInput, bonus);
    }

    public void checkLotto() {
        List<Integer> winLottoNumbers;
        List<WinType> checkResult;
        Integer bonus;

        winLottoNumbers = winLotto.getNumbers();
        bonus = winLotto.getBonus();

        checkResult = purchasedLotto.checkLotto(winLottoNumbers, bonus);

        printResult(checkResult);
    }

    private void printResult(List<WinType> checkResult) {
        int price = checkResult.size() * 1000;
        int total = 0;

        outputView.resultHeader();

        for (WinType e : WinType.values()) {
            if (e == WinType.NONE) {
                continue;
            }
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
