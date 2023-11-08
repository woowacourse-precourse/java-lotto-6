package lotto;

import static org.mockito.ArgumentMatchers.intThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WinningPrizeCalculator {
    
    Map<LottoPrize, Integer> ticketPrize = new HashMap<LottoPrize, Integer>();
    
    public void calculateWinningPrize(List<Lotto> lottoTicket, WinningNumbers winningNumbers) {
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            ticketPrize.put(lottoPrize, 0);
        }
        
        for (Lotto lotto : lottoTicket) {
            LottoPrize lottoPrize = calculateLottoPrize(lotto, winningNumbers);
            updateTicketPrize(lottoPrize);
        }
    }
    
    private void updateTicketPrize(LottoPrize lottoPrize) {
        ticketPrize.put(lottoPrize, ticketPrize.get(lottoPrize) + 1);
    }
    
    private LottoPrize calculateLottoPrize(Lotto lotto, WinningNumbers winningNumbers) {
        int matchCount;
        boolean matchBonus;
        
        matchCount = countTwoListMatch(lotto.getNumbers(),winningNumbers.getWinningNumbers());
        matchBonus = lotto.getNumbers().contains(winningNumbers.getBonusNumber());
        
        if (matchCount == 6) {
            return LottoPrize.SIX_MATCH;
        }
        if (matchCount == 5 && matchBonus) {
            return LottoPrize.FIVE_BONUS_MATCH;
        }
        if (matchCount == 5) {
            return LottoPrize.FIVE_MATCH;
        }
        if (matchCount == 4) {
            return LottoPrize.FOUR_MATCH;
        }
        if (matchCount == 3) {
            return LottoPrize.THREE_MATCH;
        }
        return LottoPrize.LESS_THAN_THREE_MATCH;
        
    }
    
    private int countTwoListMatch(List<Integer> list1, List<Integer> list2) {
        Set<Integer> integeratedSet = new HashSet<Integer>(list1);
        for (int number : list2) {
            integeratedSet.add(number);
        }
        return list1.size() + list2.size() - integeratedSet.size();
    }
    
    public Map<LottoPrize, Integer> getTicketPrize(){
        return this.ticketPrize;
    }
}
