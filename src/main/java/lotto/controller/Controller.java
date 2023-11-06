package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.domain.user.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.user.Purchase;
import lotto.domain.calculator.RateOfReturn;
import lotto.domain.calculator.WinCalculator;
import lotto.domain.user.WinningNumber;
import lotto.domain.result.WonRecord;
import lotto.io.LottoInputView;
import lotto.io.LottoOutputView;

public class Controller {
    private final LottoInputView inputView = new LottoInputView();
    private final LottoOutputView outputView = new LottoOutputView();
    private List<Lotto> lottoPurchaseNumbers = new ArrayList<>();

    public void excute() {
        int purchase = purchaseManager(); // 로또 구입
        printLottoManager(purchase); // 로또 발행
        List<Integer> winningNumber = winningNumberManager(); // 당첨 번호 입력
        int bonusNumber =  bonusNumberManager(winningNumber); // 보너스 번호 입력

        Map<String, Integer> allPrizeCount = wonCalculatorManager(winningNumber, bonusNumber); // 당첨 계산
        outputView.printWinningStatistics(allPrizeCount);

        rateOfReturnManager(purchase, allPrizeCount); // 수익률 계산
    }

    private Integer purchaseManager() {
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

    private void printLottoManager(int purchase) {
        int lottoPurchaseCount = purchase / 1000;
        outputView.printLottoPurchaseCount(lottoPurchaseCount);
        for(int i = 0; i<lottoPurchaseCount; i++) {
            lottoPurchaseNumbers.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
            outputView.printLottoNumbers(lottoPurchaseNumbers.get(i).getNumbers());
        }
    }

    private List<Integer> winningNumberManager() {
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

    private Integer bonusNumberManager(List<Integer> winningNumber) {
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

    private Map<String, Integer> wonCalculatorManager(List<Integer> winningNumber, int bonusNumber) {
        WinCalculator winCalculator
                = new WinCalculator(winningNumber, bonusNumber);
        WonRecord wonRecord = new WonRecord();
        for(Lotto lotto : lottoPurchaseNumbers) {
            wonRecordManager(wonRecord, winCalculator.calculate(lotto.getNumbers()));
        }
        return wonRecord.getAllPrizeCount();
    }

    private void wonRecordManager(WonRecord wonRecord, Map<String, Integer> result) {
        wonRecord.recorder(result);
    }

    private void rateOfReturnManager(int purchase, Map<String, Integer> allPrizeCount) {
        RateOfReturn rateOfReturn = new RateOfReturn(purchase, allPrizeCount);
        outputView.printRateOfReturn(rateOfReturn.getRateOfReturn());
    }
}
