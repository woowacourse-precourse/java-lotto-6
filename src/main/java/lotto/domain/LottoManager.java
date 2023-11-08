package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.util.MatchRanking;

public class LottoManager {
    private Map<MatchRanking, Integer> lottoResult;

    public LottoManager(Lottos lottos, List<Integer> totalMatchNumbers){
        lottoResult = new HashMap<>();
        initLottoResult();
        matchResult(lottos, totalMatchNumbers);
    }

    public Map<MatchRanking, Integer> getLottoResult() {
        return lottoResult;
    }

    private void initLottoResult(){
        for(MatchRanking matchRanking : MatchRanking.values()){
            if(!matchRanking.getRank().isEmpty()){
                lottoResult.put(matchRanking,0);
            }
        }
    }

    public void matchResult(Lottos lottos, List<Integer> totalMatchNumbers){
        int bonusNumber = parseBonusNumber(totalMatchNumbers);

        for(Lotto lotto : lottos.getLottos()){
            List<Integer> numberIntersection = compareToMatch(lotto, totalMatchNumbers);
            MatchRanking ranking = judgeLottoRanking(numberIntersection, bonusNumber);
            rankingCount(ranking);
        }
    }

    private Integer parseBonusNumber(List<Integer> totalMatchNumbers){
        return totalMatchNumbers.get(totalMatchNumbers.size()-1);
    }

    public List<Integer> compareToMatch(Lotto lotto, List<Integer> totalMatchNumbers){
        List<Integer> compareNumbers = new ArrayList<>(lotto.getNumbers());
        compareNumbers.retainAll(totalMatchNumbers);
        return compareNumbers;
    }

    public MatchRanking judgeLottoRanking(List<Integer> numberIntersection, Integer bonusNumber){
        if(numberIntersection.size()==6){
            return judgeSecondAndThirdRanking(numberIntersection, bonusNumber);
        }
        if(numberIntersection.size()==5){
            return MatchRanking.THIRD_PLACE;
        }
        if(numberIntersection.size()==4){
            return MatchRanking.FOURTH_PLACE;
        }
        if(numberIntersection.size()==3){
            return MatchRanking.FIFTH_PLACE;
        }
        return MatchRanking.NO_MATCH;
    }

    public MatchRanking judgeSecondAndThirdRanking(List<Integer> numberIntersection, Integer bonusNumber){
        if(numberIntersection.contains(bonusNumber)){
            return MatchRanking.SECOND_PLACE;
        }
        return MatchRanking.FIRST_PLACE;
    }

    private void rankingCount(MatchRanking ranking){
        if(!ranking.getRank().isEmpty()){
            int count = lottoResult.get(ranking);
            lottoResult.put(ranking,count+1);
        }
    }
}
