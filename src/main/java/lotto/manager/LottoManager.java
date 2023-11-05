package lotto.manager;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoPurchase;
import lotto.domain.RateOfReturn;
import lotto.domain.WinningCalculator;
import lotto.domain.WinningNumber;
import lotto.domain.WinningRecord;
import lotto.io.LottoInputView;
import lotto.io.LottoOutputView;

public class LottoManager {
    private final LottoInputView inputView = new LottoInputView();
    private final LottoOutputView outputView = new LottoOutputView();
    private List<Lotto> lottoPurchaseNumbers = new ArrayList<>();;

    public void excute() {
        LottoPurchase lottoPurchase = new LottoPurchase();
        lottoPurchase.setLottoPurchase(inputView.readPurchaseAmount());
        printLottoManager();

        winningCalculatorManager();

    }

    public void printLottoManager() {
        int lottoPurchaseCount = LottoPurchase.getLottoPurchase() / 1000;
        outputView.printLottoPurchaseCount(lottoPurchaseCount);
        for(int i = 0; i<lottoPurchaseCount; i++) {
            lottoPurchaseNumbers.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
            outputView.printLottoNumbers(lottoPurchaseNumbers.get(i).getNumbers());
        }
    }

    public List<Integer> winningNumberManager() {
        WinningNumber winningNumber = new WinningNumber();
        winningNumber.setWinningNumber(inputView.readWinningNumber());
        return winningNumber.getWinningNumber();
    }

    public Integer bonusNumberManager(List<Integer> winningNumber) {
        BonusNumber bonusNumber = new BonusNumber(winningNumber);
        bonusNumber.setBonusNumber(inputView.readBonusNumber());
        return bonusNumber.getBonusNumber();
    }

    public void winningCalculatorManager() {
        List<Integer> winningNumber = winningNumberManager();
        WinningCalculator winningCalculator
                = new WinningCalculator(winningNumber, bonusNumberManager(winningNumber));
        WinningRecord winningRecord = new WinningRecord();
        for(Lotto lotto : lottoPurchaseNumbers) {
            List<Integer> winningStatus = winningCalculator.calculator(lotto.getNumbers());
            winningRecord.recorder(winningStatus.get(0), winningStatus.get(1));
        }
        outputView.printWinningStatistics(winningRecord.getAllPrizeCount());

        RateOfReturn rateOfReturn = new RateOfReturn(LottoPurchase.getLottoPurchase(), winningRecord.getAllPrizeCount());
        outputView.printRateOfReturn(rateOfReturn.getRateOfReturn());
    }
}
