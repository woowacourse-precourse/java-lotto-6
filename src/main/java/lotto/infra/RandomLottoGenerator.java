package lotto.infra;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Constraint;
import lotto.domain.LottoGenerator;

import java.util.List;

final class RandomLottoGenerator implements LottoGenerator {
    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(Constraint.MIN.getValue(), Constraint.MAX.getValue(), Constraint.SIZE.getValue());
    }
}
