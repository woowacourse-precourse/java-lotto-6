package lotto.model;

import static lotto.Constants.Constants.LOTTO_NUMBER_COUNT;
import static lotto.Constants.Constants.MAX_RANDOM_NUMBER;
import static lotto.Constants.Constants.MIN_RANDOM_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoTicket extends Lotto {

    private LottoTicket(List<Integer> numbers) {
        super(numbers);
    }

    public static LottoTicket newInstance() {
        return new LottoTicket(generateNumbers());
    }

    private static List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER,
            LOTTO_NUMBER_COUNT);
    }

}