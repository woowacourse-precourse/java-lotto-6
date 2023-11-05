package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        Integer userPurchaseAmount = Integer.parseInt(Console.readLine());

        System.out.println();
        int numberOfLottos = userPurchaseAmount / 1000;
        System.out.println(numberOfLottos + "개를 구매했습니다.");

        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Lotto> purchasedLottos = lottoGenerator.generateLottos(numberOfLottos);

        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumber = Arrays.stream(Console.readLine().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
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

        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + lottoResult.getCount(WinningCriteria.FIFTH_PLACE) + "개");
        System.out.println("4개 일치 (50,000원) - " + lottoResult.getCount(WinningCriteria.FOURTH_PLACE) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoResult.getCount(WinningCriteria.THIRD_PLACE) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoResult.getCount(WinningCriteria.SECOND_PLACE) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoResult.getCount(WinningCriteria.FIRST_PLACE) + "개");
        System.out.printf("총 수익률은 %.1f%%입니다.\n", roundedReturn);

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
