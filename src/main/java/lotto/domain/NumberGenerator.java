package lotto.domain;

import static lotto.constant.DomainConstant.LOTTO_SIZE;
import static lotto.constant.DomainConstant.MAX_LOTTO_NUMBER;
import static lotto.constant.DomainConstant.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public interface NumberGenerator {

    List<Integer> generateNumbers();

    class RandomNumberGenerator implements NumberGenerator {

        @Override
        public List<Integer> generateNumbers() {
            return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER.getValue(), MAX_LOTTO_NUMBER.getValue(),
                LOTTO_SIZE.getValue());
        }
    }
}
