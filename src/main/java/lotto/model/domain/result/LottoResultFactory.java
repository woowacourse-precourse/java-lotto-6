package lotto.model.domain.result;

import java.util.HashMap;
import java.util.Map;
import lotto.model.domain.result.compare.LottoAnswerCompareResult;

/**
 * 정답과 비교한 결과에 따른 당첨 결과를 생성해 주는 결과 팩토리 클래스
 */
public class LottoResultFactory {
    private final Map<LottoAnswerCompareResult, LottoResult> results;

    /**
     * 생성 시에 각 비교 결과에 따른 당첨 결과를 초기화 시켜 줍니다.
     * <p>당첨 방식이 변경 된다면 이곳을 수정해 주세요</p>
     */
    public LottoResultFactory() {
        results = new HashMap<>();
        results.put(new LottoAnswerCompareResult(3, false), LottoResult.FIFTH);
        results.put(new LottoAnswerCompareResult(4, false), LottoResult.FOURTH);
        results.put(new LottoAnswerCompareResult(5, false), LottoResult.THIRD);
        results.put(new LottoAnswerCompareResult(5, true), LottoResult.SECOND);
        results.put(new LottoAnswerCompareResult(6, false), LottoResult.FIRST);
    }

    /**
     * 비교 결과에 따른 당첨 결과를 반환합니다.
     *
     * @param lottoCompareResult - 로또와 정답의 비교 결과
     * @return 당첨이 되지 않았을 경우  {@link LottoResult#LOSE}<br> 당첨 결과 {@link LottoResult#LOSE}를 제외한 {@link LottoResult}
     */
    public LottoResult getLottoResult(LottoAnswerCompareResult lottoCompareResult) {
        return results.getOrDefault(lottoCompareResult, LottoResult.LOSE);
    }
}
