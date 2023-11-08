package lotto.util;

import static lotto.constant.NumberConstant.LAST_LOTTO_NUMBER;
import static lotto.constant.NumberConstant.NUMBERS_LENGTH;
import static lotto.constant.NumberConstant.START_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.NumberConstant;

public class LottoGenerator implements NumberGenerator {


    private static LottoGenerator instance;

    private LottoGenerator() {
    }


    public static LottoGenerator getInstance() {
        if (instance == null) {
            return new LottoGenerator();
        }
        return instance;
    }

    @Override
    public List<Integer> generateNumberList() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_LOTTO_NUMBER.getNumber(),
            LAST_LOTTO_NUMBER.getNumber(), NUMBERS_LENGTH.getNumber());
        return numbers.stream().sorted().toList();
    }
}
