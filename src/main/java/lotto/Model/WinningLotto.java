package lotto.Model;

import lotto.validation.Validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

public class WinningLotto {

    private static final int LOTTO_PRICE = 1000;
    private final HashMap<Rank, Integer> winningCount;
    private double totalPrizeMoney;

    public WinningLotto() {
        winningCount = new HashMap<>() {{
            put(Rank.FIRST, 0);
            put(Rank.SECOND, 0);
            put(Rank.THIRD, 0);
            put(Rank.FOURTH, 0);
            put(Rank.FIFTH, 0);
            put(Rank.MISS, 0);
        }};
        totalPrizeMoney = 0;
    }

    public void FindMatchNumber(List<Lotto> lottoPublished, List<Integer> winningNumbers, int bonusNumber){
        for (Lotto lotto : lottoPublished){
            Rank prizeType = Rank
                    .getPrizeType(getMatchNumbers(lotto.getNumbers(), winningNumbers)
                            , calculateBonus(lotto.getNumbers(), bonusNumber));
            winningCount.put(prizeType, winningCount.get(prizeType)+1);
            CalculateTotalMoney(prizeType);
        }
    }

    private void CalculateTotalMoney(Rank prizeType){
        totalPrizeMoney += prizeType.getPrizeMoney();
    }
    private int getMatchNumbers(List<Integer> lotto, List<Integer> winningNumbers){
        return (int) lotto.stream()
                .filter(number -> winningNumbers.stream().anyMatch(Predicate.isEqual(number)))
                .count();
    }
    private boolean calculateBonus(List<Integer> winningNumber, int bonusNumber){
        return winningNumber.contains(bonusNumber);
    }

    public String calculateMoney(int amount){
        totalPrizeMoney *= 1.0;
        return CalculateTotalMoneyToString(totalPrizeMoney / (amount * LOTTO_PRICE) * 100);
    }

    private String CalculateTotalMoneyToString(double amount){
        return String.format("%.1f", amount);
    }

    public HashMap<Rank, Integer> getWinningCount(){
        return winningCount;
    }




}
