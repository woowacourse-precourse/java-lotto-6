package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Purchase;
import lotto.domain.RateOfReturn;
import lotto.domain.WinCalculator;
import lotto.domain.WinningNumber;
import lotto.domain.WonRecord;
import lotto.io.LottoInputView;
import lotto.io.LottoOutputView;

public class Controller {
    private final LottoInputView inputView = new LottoInputView();
    private final LottoOutputView outputView = new LottoOutputView();
    private List<Lotto> lottoPurchaseNumbers = new ArrayList<>();

    public void excute() {
        int purchase = purchaseManager();
        printLottoManager(purchase);
        winningCalculatorManager(purchase);
    }

    public Integer purchaseManager() {
        Purchase purchase = null;
        boolean ispurchased = false;
        while(!ispurchased) {
            try {
                purchase = new Purchase(inputView.readPurchaseAmount());
                ispurchased = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return purchase.getLottoPurchase();
    }

    public void printLottoManager(int purchase) {
        int lottoPurchaseCount = purchase / 1000;
        outputView.printLottoPurchaseCount(lottoPurchaseCount);
        for(int i = 0; i<lottoPurchaseCount; i++) {
            lottoPurchaseNumbers.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
            outputView.printLottoNumbers(lottoPurchaseNumbers.get(i).getNumbers());
        }
    }

    public List<Integer> winningNumberManager() {
        WinningNumber winningNumber = null;
        boolean ispurchased = false;
        while(!ispurchased) {
            try {
                winningNumber = new WinningNumber(inputView.readWinningNumber());
                ispurchased = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return winningNumber.getWinningNumber();
    }

    public Integer bonusNumberManager(List<Integer> winningNumber) {
        BonusNumber bonusNumber = null;
        boolean ispurchased = false;
        while(!ispurchased) {
            try {
                bonusNumber = new BonusNumber(winningNumber, inputView.readBonusNumber());
                ispurchased = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNumber.getBonusNumber();
    }

    public void winningCalculatorManager(int purchase) {
        List<Integer> winningNumber = winningNumberManager();
        WinCalculator winCalculator
                = new WinCalculator(winningNumber, bonusNumberManager(winningNumber));
        WonRecord wonRecord = new WonRecord();
        for(Lotto lotto : lottoPurchaseNumbers) {
            List<Integer> winningStatus = winCalculator.calculator(lotto.getNumbers());
            wonRecord.recorder(winningStatus.get(0), winningStatus.get(1));
        }
        outputView.printWinningStatistics(wonRecord.getAllPrizeCount());

        RateOfReturn rateOfReturn = new RateOfReturn(purchase, wonRecord.getAllPrizeCount());
        outputView.printRateOfReturn(rateOfReturn.getRateOfReturn());
    }
}
