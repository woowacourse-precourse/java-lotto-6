package lotto.Controller;

import static lotto.model.LottoResult.addCount;
import static lotto.model.LottoResult.checkBonusNumber;
import static lotto.model.LottoResult.matchResult;
import static lotto.util.Constant.LOTTO_PER_PRICE;
import static lotto.view.InputView.InputWinningNumbers;
import static lotto.view.InputView.readLine;

import java.util.ArrayList;
import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoNumbers;
import lotto.model.LottoProfit;
import lotto.model.LottoPurchase;
import lotto.view.OutputView;

public class LottoController {

    private static int lottoCount;
    private static List<List<Integer>> lottoNumbers;
    private static List<Integer> winningNumbers;
    private static int bonusNumber;

    public static void start() {

    }

    private static void purchaseLotto() {
        OutputView.printPurchasePrice();
        LottoPurchase lottoPurchase = new LottoPurchase(readLine());
        lottoCount = lottoPurchase.getLottoCount();
        OutputView.printPurchaseMessage(lottoCount);
    }

    private static void printAllLottoNumbers() {
        LottoNumbers allLottoNumbers = new LottoNumbers(lottoCount);
        lottoNumbers = new ArrayList<>(allLottoNumbers.getLottoNumbers());
        OutputView.printLottoNumbers(lottoNumbers);
    }

    private static void setWinningNumbers() {
        OutputView.printInputWinningNumbers();
        Lotto lotto = new Lotto(InputWinningNumbers(readLine()));
        winningNumbers = lotto.getNumbers();
    }

    private static void setBonusNumber() {
        OutputView.printInputBonusNumber();
        BonusNumber bonus = new BonusNumber(readLine());
        bonusNumber = bonus.getBonusNumber();
    }

    private static void printStatisticsResult() {
        OutputView.printWinningStatistics();
        for (List<Integer> lotto : lottoNumbers) {
            int match = matchResult(lotto, winningNumbers);
            addCount(checkBonusNumber(lotto, match, bonusNumber));
        }
        OutputView.printLottoStatistics();
    }

    private static void printLottoProfitResult() {
        OutputView.printTotalProfitRate();
        LottoProfit lottoProfit = new LottoProfit(lottoCount * LOTTO_PER_PRICE);
        String lottoProfitResult = lottoProfit.getLottoProfit();
        OutputView.printLottoProfit(lottoProfitResult);
    }

}
