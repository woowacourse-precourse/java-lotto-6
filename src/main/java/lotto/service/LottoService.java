package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoWithBonus;

public class LottoService {
    public int compareEachLotto(LottoWithBonus userLotto, Lotto generatedRandomLotto) {
        return userLotto.findSameNumberCount(generatedRandomLotto);
    }

    // 결과를 출력하기 위한 DTO를 형성할 수 있어야 한다

}
