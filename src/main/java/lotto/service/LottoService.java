package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoWithBonus;

public class LottoService {
    public static LottoResult compareLottoWithBonus(LottoWithBonus userLotto, Lotto generatedRandomLotto) {
        int sameNumberCount = compareEachLotto(userLotto, generatedRandomLotto);
        if ( sameNumberCount == 5 && isBonusInLotto(userLotto, generatedRandomLotto)) {
            sameNumberCount = 7;
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
