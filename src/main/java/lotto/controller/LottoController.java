package lotto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.utils.MatchResult;
import lotto.utils.RandomNumber;
import lotto.view.UserInput;
import lotto.view.UserOutput;

public class LottoController {
    private static int amount;
    private static List<Integer> number;
    private static int bonus;
    private static List<Set<Integer>> purchasedLottos = new ArrayList<>();

    public static void run() {
        try{
            System.out.println("구입금액을 입력해 주세요.");
            amount = Integer.parseInt(UserInput.inputAmount());
            int count = amount / 1000;
            System.out.println(count + "개를 구매했습니다.");


            for (int i = 0; i < count; i++) {
                Set<Integer> lotto = new HashSet<>(RandomNumber.generator());
                purchasedLottos.add(lotto);
                System.out.println(lotto);
            }
            System.out.println("당첨 번호를 입력해 주세요.");
            number = UserInput.inputNumber();

            System.out.println("보너스 번호를 입력해 주세요.");
            bonus = UserInput.inputBonus();

            List<Integer> matchCounts = getMatchCounts(purchasedLottos, number, bonus);
            System.out.println("당첨 통계");
            System.out.println("---");
            UserOutput.winningDetails(matchCounts);

            int totalPrize = calculateWinningAmount(matchCounts);
            String profitRate = UserOutput.rateOfReturn(totalPrize, amount);
            System.out.println("총 수익률은 " + profitRate + "%입니다.");

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    private static List<Integer> getMatchCounts(List<Set<Integer>> purchasedLottos, List<Integer> number, int bonus) {
        List<Integer> matchCounts = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));

        for (Set<Integer> lotto : purchasedLottos) {
            int matchCount = (int) number.stream()
                    .filter(lotto::contains)
                    .count();
            boolean bonusMatch = matchCount == 5 && lotto.contains(bonus);
            MatchResult result = MatchResult.valueOf(matchCount, bonusMatch);

            if (result != null) {
                matchCounts.set(result.getPrizeIndex(), matchCounts.get(result.getPrizeIndex()) + 1);
            }
        }

        return matchCounts;
    }

    private static int calculateWinningAmount(List<Integer> matchCounts) {
        int totalWinningAmount = 0;
        for (MatchResult result : MatchResult.values()) {
            totalWinningAmount += matchCounts.get(result.getPrizeIndex()) * result.getPrizeAmount();
        }
        return totalWinningAmount;
    }
}
