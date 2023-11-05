package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoWithBonus;

public class LottoService {
    public static final int SPECIAL_CASE = 5;
    public static final int SPECIAL_RESULT = 7;

    public static LottoResult compareLottoWithBonus(LottoWithBonus userLotto, Lotto generatedRandomLotto) {
        int sameNumberCount = compareEachLotto(userLotto, generatedRandomLotto);
        if ( sameNumberCount == SPECIAL_CASE && isBonusInLotto(userLotto, generatedRandomLotto)) {
            sameNumberCount = SPECIAL_RESULT;
        }
        return LottoResult.findLottoResultBySameNumberCount(sameNumberCount);
    }

    private static int compareEachLotto(LottoWithBonus userLotto, Lotto generatedRandomLotto) {
        return userLotto.findSameNumberCount(generatedRandomLotto);
    }

    private static boolean isBonusInLotto(LottoWithBonus userLottoWithBonus, Lotto generatedRandomLotto) {
        return userLottoWithBonus.isBonusInLotto(generatedRandomLotto);
    }

    // 결과를 출력하기 위한 DTO를 형성할 수 있어야 한다
}
