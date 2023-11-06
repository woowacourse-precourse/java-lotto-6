package lotto.Domain;

import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import lotto.Constants.LottosConstants;

public class WinningCalculator {
    private static final int LOTTO_PRICE = 1000;
    private final HashMap<LottosConstants, Integer> winningCount;
    private double totalPrizeMoney;

    public WinningCalculator(){
        winningCount = new HashMap<>() {{
            put(LottosConstants.SIX_MATCH, 0);
            put(LottosConstants.THREE_MATCH, 0);
            put(LottosConstants.FOUR_MATCH, 0);
            put(LottosConstants.FIVE_MATCH, 0);
            put(LottosConstants.FIVE_MATCH_BONUS, 0);
            put(LottosConstants.NONE, 0);
        }};

        totalPrizeMoney = 0;
    }

    public void calculateMatchNumbers(List<Lotto> lottoPapers, List<Integer> winningNumbers, int bonusNumber){
        for (Lotto lotto : lottoPapers){
            LottosConstants prizeType = LottosConstants
                    .getPrizeType(getMatchNumbers(lotto.getNumbers(), winningNumbers)
                            , calculateBonus(lotto.getNumbers(), bonusNumber));
            winningCount.put(prizeType, winningCount.get(prizeType)+1);
            plusTotalPrizeMoney(prizeType);
        }
    }

    private void plusTotalPrizeMoney(LottosConstants prizeType){
        totalPrizeMoney += prizeType.getPrizeMoney();
    }

    private boolean calculateBonus(List<Integer> winningNumber, int bonusNumber){
        return winningNumber.contains(bonusNumber);
    }

    private int getMatchNumbers(List<Integer> lotto, List<Integer> winningNumbers){
        return (int) lotto.stream()
                .filter(number -> winningNumbers.stream().anyMatch(Predicate.isEqual(number)))
                .count();
    }

    private String totalprizeMoneyToString(double amount){
        return String.format("%.1f", amount);
    }
}
