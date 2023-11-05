package lotto.service;

import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.LottoWithBonus;

public class LottoService {
    public static int compareEachLotto(LottoWithBonus userLotto, Lotto generatedRandomLotto) {
        int sameNumberCount = userLotto.findSameNumberCount(generatedRandomLotto);
        // 5개 + 보너스 번호 일치를 위한 특별 추가 사항이다
        if (sameNumberCount == 5 && userLotto.isBonusInLotto(generatedRandomLotto)) {
            return 7;
        }
        return sameNumberCount;
    }

    private static boolean isBonusInLotto(Bonus userBonus, Lotto generatedRandomLotto) {
        return userBonus.hasSameNumberInLotto(generatedRandomLotto);
    }

    // 결과를 출력하기 위한 DTO를 형성할 수 있어야 한다

}
