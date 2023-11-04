package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoService {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final int NUMBER_OF_LOTTO_NUMBERS = 6;

    public List<Integer> sortNumbersByAsc(List<Integer> integerList) {
        Collections.sort(integerList);
        return integerList;
    }

    private List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, NUMBER_OF_LOTTO_NUMBERS);
    }
}
