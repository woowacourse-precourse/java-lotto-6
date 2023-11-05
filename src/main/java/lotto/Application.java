package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        PrintOut printOut = new PrintOut();

        printOut.purchaseGuide();
        Integer userPurchaseAmount = Integer.parseInt(Console.readLine());

        int numberOfLottos = userPurchaseAmount / 1000;
        printOut.confirmPurchase(numberOfLottos);

        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Lotto> purchasedLottos = lottoGenerator.generateLottos(numberOfLottos);

        printOut.inputWinningNumber();
        List<Integer> winningNumber = Arrays.stream(Console.readLine().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        printOut.inputBonusNumber();
        int bonusNumber = Integer.parseInt(Console.readLine());

        LottoResult lottoResult = new LottoResult();
        for (Lotto purchasedLotto : purchasedLottos) {
            WinningCriteria criteria = getWinningCriteria(purchasedLotto, winningNumber, bonusNumber);
            if (criteria != null) {
                lottoResult.addWin(criteria);
            }
        }

        int totalPrice = lottoResult.getCount(WinningCriteria.FIFTH_PLACE) * 5_000 +
                lottoResult.getCount(WinningCriteria.FOURTH_PLACE) * 50_000 +
                lottoResult.getCount(WinningCriteria.THIRD_PLACE) * 1_500_000 +
                lottoResult.getCount(WinningCriteria.SECOND_PLACE) * 30_000_000 +
                lottoResult.getCount(WinningCriteria.FIRST_PLACE) * 2_000_000_000;
        double totalReturn = ((double) totalPrice / (double) userPurchaseAmount) * 100.0;

        double roundedReturn = Math.round(totalReturn * 10.0) / 10.0;

        printOut.getStatistics(lottoResult, roundedReturn);
    }

    private static WinningCriteria getWinningCriteria(Lotto lotto, List<Integer> winningNumber, int bonusNumber) {
        int matchCount = lotto.countMatches(winningNumber);
        boolean bonus = lotto.additionalNumber(bonusNumber);
        if (matchCount == 6) return WinningCriteria.FIRST_PLACE;
        if (matchCount == 5 && bonus) return WinningCriteria.SECOND_PLACE;
        if (matchCount == 5) return WinningCriteria.THIRD_PLACE;
        if (matchCount == 4) return WinningCriteria.FOURTH_PLACE;
        if (matchCount == 3) return WinningCriteria.FIFTH_PLACE;

        return null;
    }
}
