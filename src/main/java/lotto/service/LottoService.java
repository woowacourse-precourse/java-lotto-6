package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

import static lotto.constants.LottoConstants.*;

public class LottoService {

    public List<Integer> sortNumbersByAsc(List<Integer> integerList) {
        Collections.sort(integerList);
        return integerList;
    }

    private List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER, NUMBER_OF_LOTTO_NUMBERS);
    }
}
