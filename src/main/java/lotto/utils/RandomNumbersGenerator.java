package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.enums.LottoEnum;

import java.util.List;

public class RandomNumbersGenerator implements NumbersGenerator {

    @Override
    public List<Integer> generate() {
        return generateRandomNumbers();
    }

    private List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoEnum.MIN_LOTTO_NUMBER.getValue(), LottoEnum.MAX_LOTTO_NUMBER.getValue(), LottoEnum.SELECTED_NUMBERS_SIZE.getValue());
    }
}
