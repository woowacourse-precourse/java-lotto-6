package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.constant.BonusMatchType;
import lotto.constant.MatchNumber;
import lotto.constant.UnitNumber;
import lotto.constant.Winning;
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

        Map<Winning, Integer> allPrizeCount = wonCalculatorManager(winningNumber, bonusNumber); // 당첨 계산
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
        int lottoPurchaseCount = purchase / UnitNumber.LOTTO_PRICE.getNumber();
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

    private Map<Winning, Integer> wonCalculatorManager(List<Integer> winningNumber, int bonusNumber) {
        CheckWinning checkWinning
                = new CheckWinning(winningNumber, bonusNumber);
        WinningRank winningRank = new WinningRank();
        for(Lotto lotto : lottoPurchaseNumbers) {
            List<Integer> purchaseLottoNumber = lotto.getNumbers();
            int count = CheckWinning.winningNumberCounter(purchaseLottoNumber);
            BonusMatchType bonus = BonusMatchType.NOT_APPLICABLE;
            if(count == MatchNumber.FIVE.getNumber()) {
                bonus = CheckWinning.bonusNumberCounter(purchaseLottoNumber);
            }
            wonRecordManager(winningRank, count, bonus);
        }
        return winningRank.getAllPrizeCount();
    }

    private void wonRecordManager(WinningRank winningRank, int count, BonusMatchType bonus) {
        winningRank.recorderWinningRank(count, bonus);
    }

    private void rateOfReturnManager(int purchase, Map<Winning, Integer> allPrizeCount) {
        YieldCalculator yieldCalculator = new YieldCalculator(purchase, allPrizeCount);
        outputView.printRateOfReturn(yieldCalculator.getRateOfReturn());
    }
}
