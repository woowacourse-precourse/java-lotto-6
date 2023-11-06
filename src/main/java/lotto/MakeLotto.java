package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class MakeLotto {

    public Lotto makeLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Constants.MIN_LOTTO_NUMBER,
                Constants.MAX_LOTTO_NUMBER,
                Constants.LOTTO_NUMBER_COUNT);
        Lotto lotto;

        while (true) {
            try {
                lotto = new Lotto(numbers);
                return lotto;
            } catch (IllegalArgumentException e) {
                System.out.println(Constants.ERROR_NOT_VALID_LOTTO_NUMBERS);
            }
        }
    }

}
