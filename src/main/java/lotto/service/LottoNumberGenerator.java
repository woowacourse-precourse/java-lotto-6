package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumberGenerator {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;
    private static final int LOTTO_LEN = 6;

    public List<Integer> generateLotto() {
        Set<Integer> numbers = new HashSet<>();
        while(numbers.size() < LOTTO_LEN) {
            numbers.add(generateNumber());
        }
        return new ArrayList<>(numbers);
    }

    private int generateNumber() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }
}

