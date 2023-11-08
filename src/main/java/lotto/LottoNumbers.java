package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {

    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final int COUNT = 6;

    public LottoNumbers() {
    }

    private static List<Integer> lottoNumberList;

    public static List<Integer> setLottoNumbers() {
        lottoNumberList = Randoms.pickUniqueNumbersInRange(MIN, MAX, COUNT);
        List<Integer> numbers = new ArrayList<>(lottoNumberList);
        Collections.sort(numbers);
        return numbers;
    }
}
