package lotto.buyer;

import lotto.company.LotteryResult;
import lotto.company.Lotto;
import lotto.message.ErrorMessage;
import lotto.message.Message;
import lotto.rank.Rank;
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
        for (int i = Rank.FIRST.getRank(); i <= Rank.FIFTH.getRank(); i++) {
            initMap.put(i, 0);
        }
        return initMap;
    }

    public int payForLotto() {
        System.out.println(Message.INPUT_BUY_AMOUNT);
        String buyAmount = CustomScanner.getReadLine();
        try {
            validateInput(buyAmount);
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            return payForLotto();
        }
        return Integer.parseInt(buyAmount);
    }

    private void validateInput(String buyAmount) throws IllegalArgumentException{
        System.out.println("buyAmount: " + buyAmount);
        if (!Validator.isNumber(buyAmount) || !Validator.validateBuyAmount(buyAmount)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BUY_AMOUNT_INPUT.getMessage());
        }
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
            return Rank.FIRST.getRank();
        }
        if (count == 6 && isBonusNumMatch) {
            return Rank.SECOND.getRank();
        }
        return 8 - count;
    }

    public void printLotteryResult() {
        System.out.printf("3개 일치 (5,000원) - %d개\n" +
                "4개 일치 (50,000원) - %d개\n" +
                "5개 일치 (1,500,000원) - %d개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n" +
                "6개 일치 (2,000,000,000원) - %d개\n"
        , rankResult.get(Rank.FIFTH.getRank())
        , rankResult.get(Rank.FOURTH.getRank())
        , rankResult.get(Rank.THIRD.getRank())
        , rankResult.get(Rank.SECOND.getRank())
        , rankResult.get(Rank.FIRST.getRank())
        );
        System.out.printf("총 수익률은 %.1f%%입니다.\n", getProfitRate());
    }

    private double getProfitRate() {
        double profit = 0;
        int buyAmount = lottos.size() * 1000;
        for (Rank rank : Rank.values()) {
            profit += rankResult.get(rank.getRank()) * rank.getPrize();
        }
        return (profit / buyAmount) * 100;
    }
}
