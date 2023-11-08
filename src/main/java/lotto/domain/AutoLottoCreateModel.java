package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.domain.Lotto.*;

public final class AutoLottoCreateModel implements LottoCreateModel {
    @Override
    public Lotto generate() {
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(
                MIN_LOTTO_NUMBER_SIZE, MAX_LOTTO_NUMBER_SIZE, LOTTO_LENGTH);

        return new Lotto(lotto);
    }
}
