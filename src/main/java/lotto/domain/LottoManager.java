package lotto.domain;

import static lotto.util.MatchRanking.FIFTH_PLACE;
import static lotto.util.MatchRanking.FIRST_PLACE;
import static lotto.util.MatchRanking.FOURTH_PLACE;
import static lotto.util.MatchRanking.THIRD_PLACE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.util.MatchRanking;

public class LottoManager {
    private Map<MatchRanking, Integer> lottoResult;
    private static int MATCH_NUMBER_ZERO = 0;

    public LottoManager(Lottos lottos, List<Integer> totalMatchNumbers) {
        lottoResult = new HashMap<>();
        initLottoResult();
        matchResult(lottos, totalMatchNumbers);
    }

    public Map<MatchRanking, Integer> getLottoResult() {
        return lottoResult;
    }

    private void initLottoResult() {
        for (MatchRanking matchRanking : MatchRanking.values()) {
            if (!matchRanking.getRank().isEmpty()) {
                lottoResult.put(matchRanking, MATCH_NUMBER_ZERO);
            }
        }
    }

    public void matchResult(Lottos lottos, List<Integer> totalMatchNumbers) {
        int bonusNumber = parseBonusNumber(totalMatchNumbers);

        for (Lotto lotto : lottos.getLottos()) {
            List<Integer> numberIntersection = compareToMatch(lotto, totalMatchNumbers);
            MatchRanking ranking = judgeLottoRanking(numberIntersection, bonusNumber);
            rankingCount(ranking);
        }
    }

    private Integer parseBonusNumber(List<Integer> totalMatchNumbers) {
        return totalMatchNumbers.get(totalMatchNumbers.size() - 1);
    }

    public List<Integer> compareToMatch(Lotto lotto, List<Integer> totalMatchNumbers) {
        List<Integer> compareNumbers = new ArrayList<>(lotto.getNumbers());
        compareNumbers.retainAll(totalMatchNumbers);
        return compareNumbers;
    }

    public MatchRanking judgeLottoRanking(List<Integer> numberIntersection, Integer bonusNumber) {
        if (numberIntersection.size() == FIRST_PLACE.getCountMatchNumber()) {
            return judgeSecondAndThirdRanking(numberIntersection, bonusNumber);
        }
        if (numberIntersection.size() == THIRD_PLACE.getCountMatchNumber()) {
            return MatchRanking.THIRD_PLACE;
        }
        if (numberIntersection.size() == FOURTH_PLACE.getCountMatchNumber()) {
            return MatchRanking.FOURTH_PLACE;
        }
        if (numberIntersection.size() == FIFTH_PLACE.getCountMatchNumber()) {
            return MatchRanking.FIFTH_PLACE;
        }
        return MatchRanking.NO_MATCH;
    }

    public MatchRanking judgeSecondAndThirdRanking(List<Integer> numberIntersection, Integer bonusNumber) {
        if (numberIntersection.contains(bonusNumber)) {
            return MatchRanking.SECOND_PLACE;
        }
        return FIRST_PLACE;
    }

    private void rankingCount(MatchRanking ranking) {
        if (!ranking.getRank().isEmpty()) {
            int count = lottoResult.get(ranking);
            lottoResult.put(ranking,count + 1);
        }
    }
}
