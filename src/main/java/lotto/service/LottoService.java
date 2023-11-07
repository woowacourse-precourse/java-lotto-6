package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constants.LottoRule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoService {

    public static List<Integer> generateRandomLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(LottoRule.LOTTO_MIN_NUMBER.getNumber(),
                LottoRule.LOTTO_MAX_NUMBER.getNumber(), LottoRule.LOTTO_NUMBER_COUNT.getNumber());
    }

    public static List<Integer> sort(List<Integer> numbers) {
        List<Integer> sortedList = new ArrayList<>(numbers);
        Collections.sort(sortedList);
        return sortedList;
    }
}
