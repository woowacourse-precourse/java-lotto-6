package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;

public class LottoNumberMaker {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int NUMBERS_COUNT = 6;
    private static final String COMMA = ",";
    public List<Integer> createLottoNumbers() {
        List<Integer> numbers =  Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBERS_COUNT);

        return numbers.stream()
                .sorted()
                .toList();
    }

    public List<Integer> createByInput(String input) {
        return Arrays.stream(input.split(COMMA))
                .map(Integer::parseInt)
                .toList();
    }
}
