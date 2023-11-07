package lotto.Service;

import lotto.model.Lotto;
import lotto.model.ResultEachLotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResultService {
    public List<ResultEachLotto> compareLottosNumbers(List<Lotto> purchaseLottos, Lotto winningLotto, int bounsNum){
        List<ResultEachLotto> results = new ArrayList<>();
        for(Lotto purchaseLotto : purchaseLottos){
            results.add(compareLottoNumbers(purchaseLotto, winningLotto, bounsNum));
        }
        return results;
    }

    public ResultEachLotto compareLottoNumbers(Lotto purchaseLotto, Lotto winningLotto, int bounsNum){
        int matchCount = 0;
        int bouns = 0;
        for(int lottoNum : winningLotto.getLotto()){
            if(purchaseLotto.getLotto().contains(lottoNum)){
                matchCount++;
            }
        }
        if(matchCount == 5){
            if(purchaseLotto.getLotto().contains(bounsNum)){
                bouns++;
            }
        }
        return new ResultEachLotto(matchCount, bouns);
    }

    public List<Integer> calculateRankingResult(List<ResultEachLotto> results){
        List<Integer> rankingResult = new ArrayList<>(Collections.nCopies(7, 0));
        for(ResultEachLotto result : results){
            int rank = result.getRank();
            if(rank != -1){
                rankingResult.set(rank, rankingResult.get(rank) + 1);
            }
        }
        return rankingResult;
    }



}
