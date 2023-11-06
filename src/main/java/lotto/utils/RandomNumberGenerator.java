package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.LottoNumber;
import lotto.LottoNumbers;

public class RandomNumberGenerator implements NumberGenerator {

    private final int min;
    private final int max;

    public RandomNumberGenerator(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public LottoNumbers generate() {
        LottoNumbers numbers = new LottoNumbers();
        while (numbers.size() != 6) {
            int randomNumber = pickRandomNumber();
            if (!numbers.contains(randomNumber)) {
                numbers.add(new LottoNumber(randomNumber));
            }
        }

        return numbers;
    }

    private int pickRandomNumber() {
        return Randoms.pickNumberInRange(min, max);
    }
}
