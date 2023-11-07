package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    public static void start() {
        Lottos lottos = purchaseLotto();
        List<Integer> winningNumbers = setWinningNumbers();
        int bonusNumber = setBonusNumber(winningNumbers);
        // 당첨 번호와 로또 비교
        List<Integer> matchedCount = new ArrayList<>();
        double incomeRate = 12.3;
        matchedCount.add(1);
        matchedCount.add(2);
        matchedCount.add(3);
        matchedCount.add(4);
        matchedCount.add(5);
        printResult(matchedCount, incomeRate);

    }

    private static Lottos purchaseLotto() {
        /* 구입금액 입력 및 구매*/
        String requestPurchasePrice = LottoView.requestPurchasePrice();
        int purchasePrice = LottoParser.readLineToNumber(requestPurchasePrice);
        LottoInputValidator.purchasePriceIsValid(purchasePrice);
        Lottos lottos = Lottos.purchaseLottos(purchasePrice / LottoConstants.LOTTO_PRICE.getConstant());


        /* 로또 구매갯수 및 번호들 출력*/
        LottoView.printPurchasedLottos(lottos);
        return lottos;
    }

    private static List<Integer> setWinningNumbers() {
        String requestWinningNumbers = LottoView.requestWinningNumbers();
        List<Integer> winningNumbers = LottoParser.readLineToNumbers(requestWinningNumbers);
        LottoInputValidator.WinningNumbersIsValid(winningNumbers);
        return winningNumbers;
    }

    private static int setBonusNumber(List<Integer> winningNumbers) {
        String requestBonusNumber = LottoView.requestBonusNumber();
        int bonusNumber = LottoParser.readLineToNumber(requestBonusNumber);
        LottoInputValidator.bonusNumberIsValid(winningNumbers, bonusNumber);
        return bonusNumber;
    }

    private static void printResult(List<Integer> matchedCount, double incomeRate) {
        LottoView.printLottoResult(matchedCount, incomeRate);
    }
}
