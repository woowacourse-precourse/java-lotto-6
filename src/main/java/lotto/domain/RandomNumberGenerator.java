package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.NumberConstraints.*;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public List<Integer> generateNumber() {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < LOTTO_PER_NUMBER.value(); i++) {
            int number = Randoms.pickNumberInRange(LOTTO_MIN_NUMBER.value(), LOTTO_MAX_NUMBER.value());
            lottoNumbers.add(number);
        }
        return lottoNumbers;
    }
}
