package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.ui.GetPurchaseUI;
import lotto.ui.GetWinningNumbersUI;
import lotto.ui.PrintLottoUI;
import lotto.ui.PrintWinningResultUI;

public class Application {

    private static Purchase getPurchaseAmount() {
        GetPurchaseUI getPurchaseUI = new GetPurchaseUI();
        Purchase purchase;

        while (true) {
            try {
                purchase = getPurchaseUI.getPurchaseAmount();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(Constants.ERROR_NOT_VALID_PURCHASE_AMOUNT);
            }
        }

        return purchase;
    }

    private static int getLottoCount(Purchase purchase) {
        return purchase.getPurchaseAmount() / 1000;
    }

    private static List<Lotto> makeLottos(int lottoCount) {
        PrintLottoUI printLottoUI = new PrintLottoUI();
        List<Lotto> lottos = new ArrayList<>();

        printLottoUI.printLottoCount(lottoCount);

        for (int i = 0; i < lottoCount; i++) {
            MakeLotto makeLotto = new MakeLotto();
            lottos.add(makeLotto.makeLotto());
            printLottoUI.printLotto(lottos.get(i).getLotto());
        }

        return lottos;
    }

    private static Lotto getWinningLotto(GetWinningNumbersUI winningNumbersUI) {
        Lotto winningLotto;

        while (true) {
            try {
                winningLotto = winningNumbersUI.getWinningNumbers();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(Constants.ERROR_NOT_VALID_LOTTO_NUMBERS);
            }
        }

        return winningLotto;
    }

    private static int getBonusNumber(GetWinningNumbersUI winningNumbersUI, Lotto winningLotto) {
        int bonusNumber;

        while (true) {
            try {
                bonusNumber = winningNumbersUI.getBonusNumbers(winningLotto);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(Constants.ERROR_NOT_VALID_BONUS_NUMBER);
            }
        }

        return bonusNumber;
    }

    private static List<Integer> getMatchingResult(Result result,
                                                   List<Lotto> lottos,
                                                   Lotto winningLotto,
                                                   int bonusNumber) {
        return result.calculateResult(lottos, winningLotto, bonusNumber);
    }

    private static double getRateOfReturn(Result result,
                                          List<Integer> matchingResult,
                                          Purchase purchase) {
        return result.calculateRateOfReturn(matchingResult, purchase.getPurchaseAmount());
    }

    private static void printResult(List<Integer> matchingResult, double rateOfReturn) {
        PrintWinningResultUI winningResultUI = new PrintWinningResultUI();

        winningResultUI.printWinningResultUI(matchingResult);
        winningResultUI.printRateOfReturn(rateOfReturn);
    }


    public static void main(String[] args) {

        Purchase purchase = getPurchaseAmount();

        int lottoCount = getLottoCount(purchase);
        List<Lotto> lottos = makeLottos(lottoCount);

        GetWinningNumbersUI winningNumbersUI = new GetWinningNumbersUI();
        Lotto winningLotto = getWinningLotto(winningNumbersUI);
        int bonusNumber = getBonusNumber(winningNumbersUI, winningLotto);

        Result result = new Result();
        List<Integer> matchingResult = getMatchingResult(result,lottos,winningLotto,bonusNumber);
        double rateOfReturn = getRateOfReturn(result, matchingResult, purchase);
        printResult(matchingResult, rateOfReturn);
    }
}
