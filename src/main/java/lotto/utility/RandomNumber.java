package lotto.utility;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class RandomNumber {

    private final int START_NUMBER = 1;
    private final int END_NUMBER = 45;
    private final int NUMBER_COUNT = 6;

    public List<Integer> makeLottoNumber() {
        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, NUMBER_COUNT);
        sortLottoNumber(lottoNumber);
        return lottoNumber;
    }

    private void sortLottoNumber(List<Integer> lottoNumber) {
        lottoNumber.stream().collect(Collectors.toList());
    }
}
