package lotto.buyer;

import lotto.company.LotteryResult;
import lotto.company.Lotto;
import lotto.utils.CustomScanner;
import lotto.utils.Validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Buyer {
    private final List<Lotto> lottos;
    private final Map<Integer, Integer> rankResult;

    public Buyer() {
        this.lottos = new ArrayList<>();
        this.rankResult = initRankResult();
    }

    private Map<Integer, Integer> initRankResult () {
        Map<Integer, Integer> initMap = new HashMap<>();
        for (int i = 1; i < 6; i++) {
            initMap.put(i, 0);
        }
        return initMap;
    }

    public int payForLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        String buyAmount = CustomScanner.getReadLine();
        if (!Validator.isNumber(buyAmount) || !Validator.validateBuyAmount(buyAmount)) {
            System.out.println("[ERROR] 로또 구매 금액은 1000원 단위로 입력해주세요. (최소 구매 금액: 1000원)");
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(buyAmount);
    }

    public void receiveLottos (List<Lotto> generatedLottos) {
        this.lottos.addAll(generatedLottos);
    }

    public Map<Integer, Integer> compareWithLotteryResult(LotteryResult lotteryResult) {
        for (Lotto lotto : lottos) {
            int count = getMatchNumCount(lotto, lotteryResult.getLotto().getNumbers());
            boolean isBonusNumMatch = lotto.getNumbers().contains(lotteryResult.getBonusNumber());
            if (isBonusNumMatch) {
                count++;
            }
            if (count >= 3) {
                int rank = calculateRank(rankResult, count, isBonusNumMatch);
                rankResult.put(rank, rankResult.get(rank) + 1);
            }
        }
        return rankResult;
    }

    private int getMatchNumCount(Lotto lotto, List<Integer> lotteryNums) {
        return (int) lotto.getNumbers().stream()
            .filter(num -> lotteryNums.contains(num))
            .count();
    }

    private int calculateRank(Map<Integer, Integer> rankResult, int count, boolean isBonusNumMatch) {
        if (count == 7 || count == 6 && !isBonusNumMatch) {
            return 1;
        }
        if (count == 6 && isBonusNumMatch) {
            return 2;
        }
        return 8 - count;
    }

    public void printLotteryResult() {
        System.out.printf("3개 일치 (5,000원) - %d개\n" +
                "4개 일치 (50,000원) - %d개\n" +
                "5개 일치 (1,500,000원) - %d개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n" +
                "6개 일치 (2,000,000,000원) - %d개\n"
        , rankResult.get(5)
        , rankResult.get(4)
        , rankResult.get(3)
        , rankResult.get(2)
        , rankResult.get(1)
        );
        System.out.printf("총 수익률은 %.1f%%입니다.\n", getProfitRate());
    }

    private double getProfitRate() {
        double profit = 0;
        int buyAmount = lottos.size() * 1000;
        profit += rankResult.get(1) * 2_000_000_000;
        profit += rankResult.get(2) * 30_000_000;
        profit += rankResult.get(3) * 1_500_000;
        profit += rankResult.get(4) * 50_000;
        profit += rankResult.get(5) * 5_000;
        return (profit / buyAmount) * 100;
    }
}
