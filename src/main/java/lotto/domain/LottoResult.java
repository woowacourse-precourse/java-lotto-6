package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private static final int DEFALUT_VALUE = 0;
    private static final int ADD_AMOUNT = 1;
    private static final int STANDARD_COUNT_OF_BONUS_EXECUTE = 5;
    
    private final Map<Ranking, Integer> winningResult = new EnumMap<>(Ranking.class);
    
    public LottoResult() {
        Ranking[] rankings = Ranking.values();
        for (Ranking ranking : rankings) {
            winningResult.put(ranking, DEFALUT_VALUE);
        }
    }
    
    public void calculateWinningResult(List<Lotto> lottoTickets, Number number) {
        Lotto winningNumbers = number.getWinningNumbers();
        int bonusNumber = number.getBonusNumber();
        
        for (Lotto ticket : lottoTickets) {
            updateWinningResult(ticket, winningNumbers, bonusNumber);
        }
    }
    
    private void updateWinningResult(Lotto ticket, Lotto winningNumbers, int bonusNumber) {
        int matchingNumberCount = ticket.countMatchingNumber(winningNumbers);
        
        if (matchingNumberCount == STANDARD_COUNT_OF_BONUS_EXECUTE) {
            executeBonus(ticket, bonusNumber);
            return;
        }
        updateExceptBonus(matchingNumberCount);
    }
    
    private void updateExceptBonus(int matchingNumberCount) {
        Ranking[] rankings = Ranking.values();
        for (Ranking ranking : rankings) {
            addRankingCount(ranking, matchingNumberCount);
        }
    }
    
    public void executeBonus(Lotto ticket, int bonusNumber) {
        if (ticket.contains(bonusNumber)) {
            winningResult.put(Ranking.SECOND, winningResult.get(Ranking.SECOND) + ADD_AMOUNT);
        }
    }
    
    public void addRankingCount(Ranking ranking, int matchingNumberCount) {
        if (ranking.getMatchingNumberCount() == matchingNumberCount) {
            winningResult.put(ranking, winningResult.get(ranking) + ADD_AMOUNT);
        }
    }
    
    public Map<Ranking, Integer> getWinningResult() {
        return winningResult;
    }
}
