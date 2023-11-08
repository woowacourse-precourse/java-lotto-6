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

    private final int MINIMUM_MATCH_COUNT = 3;
    private final int FIRST_PLACE_MATCH_COUNT = 6;
    private final int MAXIMUM_MATCH_COUNT = 7;
    private final int RANK_STD = 8;
    private final int BUY_AMOUNT_UNIT = 1000;

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
        System.out.println();
        return Integer.parseInt(buyAmount);
    }

    private void validateInput(String buyAmount) throws IllegalArgumentException{
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
            if (count >= MINIMUM_MATCH_COUNT) {
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
        if (count == MAXIMUM_MATCH_COUNT || count == FIRST_PLACE_MATCH_COUNT && !isBonusNumMatch) {
            return Rank.FIRST.getRank();
        }
        if (count == FIRST_PLACE_MATCH_COUNT && isBonusNumMatch) {
            return Rank.SECOND.getRank();
        }
        return RANK_STD - count;
    }

    public void printLotteryResult() {
        System.out.printf(
                String.valueOf(Message.PRINT_LOTTERY_RESULT)
                , rankResult.get(Rank.FIFTH.getRank())
                , rankResult.get(Rank.FOURTH.getRank())
                , rankResult.get(Rank.THIRD.getRank())
                , rankResult.get(Rank.SECOND.getRank())
                , rankResult.get(Rank.FIRST.getRank())
        );
        System.out.printf(String.valueOf(Message.PRINT_PROFIT_RATE), getProfitRate());
    }

    private double getProfitRate() {
        double profit = 0;
        int buyAmount = lottos.size() * BUY_AMOUNT_UNIT;
        for (Rank rank : Rank.values()) {
            profit += rankResult.get(rank.getRank()) * rank.getPrize();
        }
        return (profit / buyAmount) * 100;
    }
}
