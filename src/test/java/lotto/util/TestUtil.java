package lotto.util;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.LottoRule;

/**
 * 테스트에 필요한 유틸리티 기능
 */
public class TestUtil {

    /**
     * 테스트에서 사용할 예외 출력의 머리말 양식을 제공한다.
     * <p>
     * 해당 양식은 유지보수 과정에서 수정하면 테스트 실패 여부를 알기 위해 main 패키지와 분리한다.
     */
    public static final String ERROR_PREFACE = "[ERROR] ";

    public static final List<Integer> lottoNumberGenerator() {
        return pickUniqueNumbersInRange(LottoRule.MINIMUM_NUMBER, LottoRule.MAXIMUM_NUMBER, 6);
    }

    public static final Lotto createLotto() {
        return new Lotto(lottoNumberGenerator());
    }

    /**
     * 테스트용 로또 당첨 기록을 반환한다.
     *
     * @return 62.5% 수익률을 가진 기록
     */
    public static final Map<LottoRank, Integer> getLottoCompareTestSet() {
        Map<LottoRank, Integer> ranks = LottoRank.createRankMap();
        ranks.put(LottoRank.RANK_5TH, 1);
        ranks.put(LottoRank.RANK_NO, 7);

        return ranks;
    }

}
