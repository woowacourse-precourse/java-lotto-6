package lotto.utils;

import static lotto.enums.LottoCalculateNums.MIN_WINNING;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoResultDTO;
import lotto.enums.LottoAmount;

public class LottoUtils {

    public static List<Lotto> createLottoList(int lottoCount){
        List<Lotto> lottoList  = new ArrayList<>();

        while(lottoCount > 0){
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoList.add(new Lotto(lottoNumbers));
            lottoCount--;
        }
        return lottoList;
    }

    /**
     * 모든 Lotto 리스트와 비교
     */
    public static List<LottoResult> matchLotto(List<Lotto> lottoList, List<Integer> winningNumber, int bonusNumber){
        List<LottoResult> lottoResultList = new ArrayList<>();

        for(Lotto lotto : lottoList){          // stream으로 변경 필요
            lottoResultList.add(lotto.matchLotto(winningNumber, bonusNumber));
        }
        return lottoResultList;
    }

    public static HashMap<String, Integer> initResultMap(){
        HashMap<String, Integer> matchMap = new HashMap<>();
        Integer revenue = 0;

        for(LottoAmount lottoAmount : LottoAmount.values()) {
            if (lottoAmount.getAmount() == 0)
                continue;
            matchMap.put(lottoAmount.getMatchType(), 0);
        }
        return matchMap;
    }

    public static LottoResultDTO createLottoResultDTO(List<LottoResult> lottoResultList, HashMap<String, Integer> matchMap, int purchaseAmount){
        double revenue = 0;
        for(LottoResult lottoResult : lottoResultList){
            if(lottoResult.getMatchedCnt() < MIN_WINNING){
                continue;
            }
            matchMap.put(lottoResult.getMatchedCntToString(), matchMap.get(lottoResult.getMatchedCntToString())+1);
            revenue += LottoAmount.getLottoAmount(lottoResult.getMatchedCntToString()).getAmount();
        }
        double revenueRate = ( revenue / (double) purchaseAmount) * 100;
        return new LottoResultDTO(matchMap, revenueRate);
    }
}
