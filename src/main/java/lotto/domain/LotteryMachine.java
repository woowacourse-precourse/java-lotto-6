package lotto.domain;

import java.util.List;

public class LotteryMachine {
    
    public static void drawLotto(List<Lotto> lottoTickets, Number number) {
        List<Integer> winningNumbers = number.getWinningNumbers().getNumbers();
        int bonusNumber = number.getBonusNumber();
        
        for (Lotto currentTicket : lottoTickets) {
            int matchNumberCount = countMatchingNumbers(currentTicket, winningNumbers);
            updateRanking(matchNumberCount, currentTicket, bonusNumber);
        }
    }
    
    private static int countMatchingNumbers(Lotto lotto, List<Integer> winningNumbers) {
        return (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }
    
    private static void updateRanking(int matchNumberCount, Lotto currentTicket, int bonusNumber) {
        if (matchNumberCount == Ranking.FIRST.getMatchNumberCount()) {
            Ranking.FIRST.addCount();
        }
        
        if (matchNumberCount == Ranking.SECOND.getMatchNumberCount()) {
            ExecuteBonusNumber(currentTicket, bonusNumber);
        }
        
        if (matchNumberCount == Ranking.FOURTH.getMatchNumberCount()) {
            Ranking.FOURTH.addCount();
        }
        
        if (matchNumberCount == Ranking.FIFTH.getMatchNumberCount()) {
            Ranking.FIFTH.addCount();
        }
    }
    
    private static void ExecuteBonusNumber(Lotto currentTicket, int bonusNumber) {
        if (currentTicket.getNumbers().contains(bonusNumber)) {
            Ranking.SECOND.addCount();
            return;
        }
        
        Ranking.THIRD.addCount();
    }
}
