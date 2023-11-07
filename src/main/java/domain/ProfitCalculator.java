package domain;

import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


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

    public String getWinningMessages(HashMap<WinningHistory, Integer> winningHistories) {
        StringBuilder message = new StringBuilder();
        for (WinningHistory history : WinningHistory.values()) {
            int count = winningHistories.get(history);
            if(history == WinningHistory.SECOND){
                message.append(String.format("%d개 일치, 보너스 볼 일치 (%,d원)", history.getMatchNumbers(), history.getPrizeMoney()));
                message.append(String.format(" - %d개%n", count));
                continue;
            }
            message.append(String.format("%d개 일치 (%,d원)", history.getMatchNumbers(), history.getPrizeMoney()));
            message.append(String.format(" - %d개%n", count));
        }
        return message.toString();
    }



    public String calculateRateOfReturn(int amount) {
        double rateOfReturn = (totalPrizeMoney / (double) amount) * 100;
        String formattedRateOfReturn = formatRateOfReturn(rateOfReturn);
        return String.format("%s%%", formattedRateOfReturn);
    }

    private String formatRateOfReturn(double rate) {
        double value = Math.round(rate * 10.0) / 10.0;
        return String.format("%.1f", value);
    }

    public HashMap<WinningHistory, Integer> getWinningHistory(){
        return winningHistory;
    }

    public void calculateProfit(List<Lotto> lottos, Lotto winningNumbers, int bonusNumber){
        for(Lotto lotto : lottos){
            calculate(getMatchNumbers(lotto, winningNumbers), isMatchBonusNumber(lotto, bonusNumber));
        }
    }

    private void calculate(int matchNumbers, boolean isMatchBonusNumber){
        WinningHistory rankType = WinningHistory.calculateRank(matchNumbers, isMatchBonusNumber);
        if(rankType != null){
            winningHistory.put(rankType, winningHistory.get(rankType) + 1);
            AddTotalPrizeMoney(rankType.getPrizeMoney());
        }
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
