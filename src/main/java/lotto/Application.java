package lotto;

import static lotto.LotteryResultRenderer.calculateReturnRate;
import static lotto.LotteryResultRenderer.getLottoResult;
import static lotto.LotteryResultRenderer.printResultSubject;
import static lotto.LotteryResultRenderer.printStats;
import static lotto.QuantityDisplayManager.printPurchaseQuantity;
import static lotto.UserInputHandler.getLottoPurchaseAmount;
import static lotto.UserInputHandler.inputBonusNumber;
import static lotto.UserInputHandler.inputWinningNumbers;
import static lotto.UserInputHandler.requestInputForBonusNumber;
import static lotto.UserInputHandler.requestInputForWinningNumbers;
import static lotto.UserInputHandler.requestPurchaseAmount;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        requestPurchaseAmount();
        int purchaseAmount = getLottoPurchaseAmount();
        int purchaseQuantity = purchaseAmount / 1000;

        System.out.println(purchaseQuantity+"개를 구매했습니다.");

        List<List<Integer>> numbers = printPurchaseQuantity(purchaseQuantity);

        for(int i = 0 ; i < purchaseQuantity ; i++){
            System.out.println(numbers.get(i));
        }

        requestInputForWinningNumbers();
        Lotto lotto = inputWinningNumbers();

        requestInputForBonusNumber();
        Bonus bonus = inputBonusNumber(lotto);

        printResultSubject();
        WinnerStatsData data = getLottoResult(numbers, lotto.getNumbers(), bonus.getBonusNumber());
        printStats(data);
        double ratePerReturn = calculateReturnRate(data, purchaseQuantity * 1000);
        System.out.println("총 수익률은 " + ratePerReturn + "%입니다.");
    }
}
