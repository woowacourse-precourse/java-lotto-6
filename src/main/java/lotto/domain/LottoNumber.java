package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LottoNumber {

    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int COUNT_OF_LOTTO_NUMBER = 6;

    private static List<Integer> lottoNumberList;

    public static List<Integer> getRandomNumbers() {
        lottoNumberList = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, COUNT_OF_LOTTO_NUMBER);
        List<Integer> lottoSortingNumberList = new ArrayList<>(lottoNumberList);
        Collections.sort(lottoSortingNumberList);
        return lottoSortingNumberList;
    }
}
