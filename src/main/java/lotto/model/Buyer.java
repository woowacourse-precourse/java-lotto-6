package lotto.model;

import lotto.constant.SystemData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Buyer {
    private final int totalAmount ;
    private final List<Lotto> lottoTickets;
    private HashMap<WinningCondition, Integer> winningStatistics = new HashMap<>();

    public Buyer(int purchaseAmount, ArrayList<Lotto> lottoTickets){
        this.totalAmount = purchaseAmount;
        this.lottoTickets = lottoTickets;

        for(WinningCondition winningCondition : WinningCondition.values()){
            winningStatistics.put(winningCondition, 0);
        }
    }

    public int getLottoTicketCount(){
        return lottoTickets.size();
    }

    public List<List<Integer>> getLottoTicketNumbers(){
        List<List<Integer>> lottoTicketNumbers = new ArrayList<>();

        for(Lotto lotto : lottoTickets){
            List<Integer> numbers = lotto.getNumbers();
            Collections.sort(numbers);
            lottoTicketNumbers.add(numbers);
        }

        return lottoTicketNumbers;
    }

    public void computeLottoResults(int[] winningNumbers, int bonusNumber){
        for(Lotto lotto : lottoTickets){
            int winningNumberCount = getWinningNumberCount(lotto.getNumbers(), winningNumbers);
            boolean containBonusNumber = getContainBonusNumber(lotto.getNumbers(), bonusNumber);
        }
    }

    public float getTotalProfitRate(){
        //TODO 수익률 계산 로직 추가
        return 10.0F;
    }

    public int getWinningNumberCount(List<Integer> numbers, int[] winningNumbers){
        int count = 0;
        for(int winningNumber : winningNumbers){
            if(numbers.contains(winningNumber)){
                count++;
            }
        }
        return count;
    }

    public boolean getContainBonusNumber(List<Integer> numbers, int bonusNumber){
        return numbers.contains(bonusNumber);
    }

//    public void updateWinningStatistics(int winningNumberCount, boolean containBonusNumber){
//        for(WinningCondition winningCondition : winningStatistics.keySet()){
//            winningCondition.
//            if(winningCondition.winningNumberCount == winningNumberCount){
//
//            }
//        }
//    }


}
