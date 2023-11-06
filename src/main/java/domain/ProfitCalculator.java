package domain;

import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * packageName    : domain
 * fileName       : ProfitCalculator
 * author         : qkrtn_ulqpbq2
 * date           : 2023-11-06
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-06        qkrtn_ulqpbq2       최초 생성
 */
public class ProfitCalculator {
    private final HashMap<WinningHistory, Integer> winningHistory;
    private double totalPrizeMoney;
    public ProfitCalculator(){
        this.winningHistory = new HashMap<>(){{
            put(WinningHistory.FIRST, 0);
            put(WinningHistory.SECOND, 0);
            put(WinningHistory.THIRD, 0);
            put(WinningHistory.FOURTH, 0);
            put(WinningHistory.FIFTH, 0);
        }};
    }

    public void calculateProfit(List<Lotto> lottos, Lotto winningNumbers, int bonusNumber){
        for(Lotto lotto : lottos){
            calculate(getMatchNumbers(lotto, winningNumbers), isMatchBonusNumber(lotto, bonusNumber));
        }
    }

    private void calculate(int matchNumbers, boolean isMatchBonusNumber){
        WinningHistory rankType = WinningHistory.calculateRank(matchNumbers, isMatchBonusNumber);
        winningHistory.put(rankType, winningHistory.get(rankType) + 1);
        AddTotalPrizeMoney(rankType.getPrizeMoney());
    }

    private void AddTotalPrizeMoney(int prizeMoney){
        totalPrizeMoney += prizeMoney;
    }

    private int getMatchNumbers(Lotto lotto, Lotto winningNumbers){
        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> winningNumberList = winningNumbers.getNumbers();

        long matchedCount = lottoNumbers.stream()
                .filter(winningNumberList::contains)
                .count();
        return (int) matchedCount;
    }

    private boolean isMatchBonusNumber(Lotto lotto, int bonusNumber){
        return lotto.getNumbers().contains(bonusNumber);
    }
}
