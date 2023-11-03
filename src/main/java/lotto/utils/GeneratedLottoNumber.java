package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

public class GeneratedLottoNumber {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;
    private static final int NUMBER_TO_GENERATE = 6;

    public static Lotto getRandomNumber(){
        return new Lotto(Randoms.pickUniqueNumbersInRange(START_INCLUSIVE,END_INCLUSIVE,NUMBER_TO_GENERATE));
    }
}
