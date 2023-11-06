package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class UserLottoGenerateStrategy implements LottoGenerateStrategy{
    @Override
    public Lotto generate(){
        return new Lotto(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, SIZE));
    }
}
