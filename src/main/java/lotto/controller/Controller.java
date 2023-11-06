package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.model.player.BonusNumber;
import lotto.model.Lotto;
import lotto.model.player.BuyLotto;
import lotto.model.calculator.YieldCalculator;
import lotto.model.calculator.CheckWinning;
import lotto.model.player.WinningNumber;
import lotto.model.result.WinningRank;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

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
        BuyLotto buyLotto = null;
        boolean ispurchased = false;
        while(!ispurchased) {
            try {
                buyLotto = new BuyLotto(inputView.readPurchaseAmount());
                ispurchased = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return buyLotto.getLottoPurchase();
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
        CheckWinning checkWinning
                = new CheckWinning(winningNumber, bonusNumber);
        WinningRank winningRank = new WinningRank();
        for(Lotto lotto : lottoPurchaseNumbers) {
            wonRecordManager(winningRank, checkWinning.calculate(lotto.getNumbers()));
        }
        return winningRank.getAllPrizeCount();
    }

    private void wonRecordManager(WinningRank winningRank, Map<String, Integer> result) {
        winningRank.recorder(result);
    }

    private void rateOfReturnManager(int purchase, Map<String, Integer> allPrizeCount) {
        YieldCalculator yieldCalculator = new YieldCalculator(purchase, allPrizeCount);
        outputView.printRateOfReturn(yieldCalculator.getRateOfReturn());
    }
}
