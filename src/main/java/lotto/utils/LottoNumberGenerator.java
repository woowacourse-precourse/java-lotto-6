package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoNumberGenerator {
    private static final Integer MINIMUM_NUMBER = 1;
    private static final Integer MAXIMUM_NUMBER = 45;
    private static final Integer NUMBER_OF_LOTTO_NUMBERS = 6;

    public static Integer pickBonusNumber(List<Integer> prePickedNumbers) {
        int randomNumber = Randoms.pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER);
        while (!prePickedNumbers.contains(randomNumber)) {
            randomNumber = Randoms.pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER);
        }
        return randomNumber;
    }

    public static List<Integer> pickLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER, NUMBER_OF_LOTTO_NUMBERS);
    }
}
