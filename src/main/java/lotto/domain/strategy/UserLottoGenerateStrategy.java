package lotto.domain.strategy;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.strategy.LottoGenerateStrategy;

public class UserLottoGenerateStrategy implements LottoGenerateStrategy {
    @Override
    public Lotto generate(){
        return new Lotto(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, SIZE));
    }
}
