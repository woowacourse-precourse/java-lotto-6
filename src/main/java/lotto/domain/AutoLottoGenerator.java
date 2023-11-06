package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class AutoLottoGenerator implements LottoGenerator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    @Override
    public Lotto generate() {
        List<Integer> numbers = new ArrayList<>();

        int number = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
        while (numbers.size() < LOTTO_SIZE) {
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
        return new Lotto(numbers);
    }
}
