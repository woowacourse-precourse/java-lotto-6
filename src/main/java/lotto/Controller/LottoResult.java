package lotto.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoResult {
    private final ArrayList<List<Integer>> lottoTickets;
    private final List<Integer> lottoWinningNum;
    private final Integer bonusNum;
    public LottoResult(ArrayList<List<Integer>> lottoTickets, List<Integer> lottoWinningNum, Integer bonusNum) {
        this.lottoTickets = lottoTickets;
        this.lottoWinningNum = lottoWinningNum;
        this.bonusNum = bonusNum;
    }
    public List<Integer> getLottoResult(){
        List<Integer> result = matchLotto(lottoTickets, lottoWinningNum, bonusNum);
        return result;
    }
    public Integer matchCount(List<Integer> lottoTicket, List<Integer> lottoWinningNum){
        Integer match = 0;
        for(Integer number : lottoWinningNum){
            if(lottoTicket.contains(number)){
                match++;
            }
        }
        return match;
    }
    public List<Integer> matchLotto(ArrayList<List<Integer>> lottoTickets, List<Integer> lottoWinningNum,Integer bonus){
        List<Integer> result = new ArrayList<>(Collections.nCopies(5,0));
        for(List<Integer> lotto : lottoTickets){
            Integer match = matchCount(lotto,lottoWinningNum);
            if(match == 6){
                result.set(0,result.get(0)+1);
            } else if(match == 5 && lotto.contains(bonus)){
                result.set(1,result.get(1)+1);
            } else if(match == 5){
                result.set(2,result.get(2)+1);
            } else if(match == 4){
                result.set(3,result.get(3)+1);
            } else if(match == 3){
                result.set(4,result.get(4)+1);
            }
        }
        return result;
    }



}


