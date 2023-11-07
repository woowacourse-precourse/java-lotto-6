package lotto.utility;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class RandomNumber {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int NUMBER_COUNT = 6;

    public List<Integer> makeLottoNumber() {
        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, NUMBER_COUNT);
        return sortLottoNumber(lottoNumber);
    }

    private List<Integer> sortLottoNumber(List<Integer> lottoNumber) {
        return lottoNumber.stream().sorted().collect(Collectors.toList());
    }
}
