package lotto.model;


import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoMachine {
    // TODO : enum 으로 변경해서 중복 제거.
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    public Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_COUNT);
        return new Lotto(numbers);
    }

}
