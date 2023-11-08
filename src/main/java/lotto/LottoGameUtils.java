package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoGameUtils {

    public static List<Lotto> issueLotto(long budget) {
        long lottoPrice = Lotto.getPrice();
        validateBudgetWithPrice(budget, lottoPrice);
        int numberOfTickets = countIssuableTickets(budget, lottoPrice);
        return issueFixedNumberOfLotto(numberOfTickets);
    }

    private static void validateBudgetWithPrice(long budget, long price) {
        if (budget % price != 0) {
            throw new IllegalArgumentException("[ERROR] 예산은 로또의 가격 단위로 입력할 수 있습니다.");
        }
    }

    private static int countIssuableTickets(long budget, long price) {
        int numberOfTickets = (int) (budget / price);
        if (numberOfTickets < 1) {
            throw new IllegalArgumentException("[ERROR] 금액이 충분하지 않습니다.");
        }
        return numberOfTickets;
    }

    private static List<Lotto> issueFixedNumberOfLotto(int numberOfTickets) {
        List<Lotto> lotto = new ArrayList<>();
        for (int i = 0; i < numberOfTickets; i++) {
            lotto.add(new Lotto(Lotto.generateLottoNumbers()));
        }
        return lotto;
    }

    public static LottoWinning createLottoWinningWithNumbers(List<Integer> number) {
        return new LottoWinning(number);
    }

    public static void updateLottoWinningWithBonus(LottoWinning lottoWinning, int bonus) {
        lottoWinning.setBonusNumber(bonus);
    }

    public static Map<LottoRank, Integer> evaluateLottoWinning(LottoWinning lottoWinning, List<Lotto> tickets) {
        return lottoWinning.assignRanks(tickets);
    }

    public static double calculateRateOfReturn(long budget, Map<LottoRank, Integer> winningCount) {
        double totalReward = 0.0;
        for (LottoRank winning: winningCount.keySet()) {
            totalReward += winning.getReward() * winningCount.get(winning);
        }
        return (double) totalReward / budget;
    }
}
