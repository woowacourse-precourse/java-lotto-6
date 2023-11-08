package lotto;

import java.util.List;
import java.util.Map;
import lotto.enums.LottoConstants;
import lotto.enums.LottoPrizeConstants;

public class LottoApplication {
    public static void start() {
        try {
            Lottos lottos = purchaseLotto();
            List<Integer> winningNumbers = setWinningNumbers();
            int bonusNumber = setBonusNumber(winningNumbers);

            // 당첨 번호와 로또 비교
            Map<LottoPrizeConstants, Integer> matchedLottoCount = lottos.checkLottos(winningNumbers, bonusNumber);

            // 수익률
            double incomeRate = lottos.getIncomeRate(matchedLottoCount);
            printResult(matchedLottoCount, incomeRate);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
    }

    private static Lottos purchaseLotto() throws IllegalArgumentException {
        /* 구입금액 입력 및 구매*/
        String requestPurchasePrice = LottoView.requestPurchasePrice();
        int purchasePrice = LottoParser.readLineToNumber(requestPurchasePrice);
        LottoInputValidator.purchasePriceIsValid(purchasePrice);
        int lottoQuantity = purchasePrice / LottoConstants.LOTTO_PRICE.getConstant();
        Lottos lottos = Lottos.purchaseLottos(lottoQuantity);

        /* 로또 구매갯수 및 번호들 출력*/
        LottoView.printPurchasedLottos(lottos);
        return lottos;
    }

    private static List<Integer> setWinningNumbers() throws IllegalArgumentException {
        String requestWinningNumbers = LottoView.requestWinningNumbers();
        List<Integer> winningNumbers = LottoParser.readLineToNumbers(requestWinningNumbers);
        LottoInputValidator.WinningNumbersIsValid(winningNumbers);
        return winningNumbers;
    }

    private static int setBonusNumber(List<Integer> winningNumbers) throws IllegalArgumentException {
        String requestBonusNumber = LottoView.requestBonusNumber();
        int bonusNumber = LottoParser.readLineToNumber(requestBonusNumber);
        LottoInputValidator.bonusNumberIsValid(winningNumbers, bonusNumber);
        return bonusNumber;
    }

    private static void printResult(Map<LottoPrizeConstants, Integer> matchedCount, double incomeRate) {
        LottoView.printLottoResult(matchedCount, incomeRate);
    }
}
