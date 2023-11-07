package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.ui.GetPurchaseUI;
import lotto.ui.GetWinningNumbersUI;
import lotto.ui.PrintLottoUI;
import lotto.ui.PrintWinningResultUI;

public class Application {

    public static void main(String[] args) {

        GetPurchaseUI getPurchaseUI = new GetPurchaseUI();
        PrintLottoUI printLottoUI = new PrintLottoUI();
        GetWinningNumbersUI winningNumbersUI = new GetWinningNumbersUI();
        PrintWinningResultUI winningResultUI = new PrintWinningResultUI();

        Purchase purchase;

        int lottoCount;

        List<Lotto> lottos = new ArrayList<>();

        Lotto winningLotto;
        int bonusNumber;

        List<Integer> matchingResult;

        double rateOfReturn;

        while (true) {
            try {
                purchase = getPurchaseUI.getPurchaseAmount();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(Constants.ERROR_NOT_VALID_PURCHASE_AMOUNT);
            }
        }

        lottoCount = purchase.getPurchaseAmount() / 1000;

        printLottoUI.printLottoCount(lottoCount);

        for (int i = 0; i < lottoCount; i++) {
            MakeLotto makeLotto = new MakeLotto();
            lottos.add(makeLotto.makeLotto());
            printLottoUI.printLotto(lottos.get(i).getLotto());
        }

        while (true) {
            try {
                winningLotto = winningNumbersUI.getWinningNumbers();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(Constants.ERROR_NOT_VALID_LOTTO_NUMBERS);
            }
        }

        while (true) {
            try {
                bonusNumber = winningNumbersUI.getBonusNumbers(winningLotto);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(Constants.ERROR_NOT_VALID_BONUS_NUMBER);
            }
        }

        Result result = new Result();
        matchingResult = result.calculateResult(lottos, winningLotto, bonusNumber);

        winningResultUI.printWinningResultUI(matchingResult);

        rateOfReturn = result.calculateRateOfReturn(matchingResult, purchase.getPurchaseAmount());

        winningResultUI.printRateOfReturn(rateOfReturn);
    }
}
