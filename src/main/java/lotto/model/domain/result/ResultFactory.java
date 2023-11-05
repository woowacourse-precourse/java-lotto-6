package lotto.model.domain.result;

import java.util.HashMap;
import java.util.Map;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoAnswer;

public class ResultFactory {

    private static final int NECESSARY_CHECK_BONUS = 5;
    private Map<CompareResult, LottoResult> results;

    public ResultFactory(){
        results = new HashMap<>();
        results.put(new CompareResult(3, false), LottoResult.FIFTH);
        results.put(new CompareResult(4, false), LottoResult.FOURTH);
        results.put(new CompareResult(5, false), LottoResult.THIRD);
        results.put(new CompareResult(5, true), LottoResult.SECOND);
        results.put(new CompareResult(6, false), LottoResult.FIRST);
    }
    
    public LottoResult getResult(Lotto lotto, LottoAnswer lottoAnswer){
        CompareResult compareResult = lotto.compareLotto(lottoAnswer);
        return results.getOrDefault(compareResult, LottoResult.LOSE);
    }
}
