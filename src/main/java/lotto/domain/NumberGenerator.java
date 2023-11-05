package lotto.domain;

import static lotto.constant.DomainConstant.MAX_LOTTO_NUMBER;
import static lotto.constant.DomainConstant.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;

public interface NumberGenerator {
    int generate();

    class RandomNumberGenerator implements NumberGenerator{

        @Override
        public int generate() {
            return Randoms.pickNumberInRange(MIN_LOTTO_NUMBER.getValue(), MAX_LOTTO_NUMBER.getValue());
        }
    }
}
