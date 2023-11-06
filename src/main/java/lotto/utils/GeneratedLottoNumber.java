package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class GeneratedLottoNumber {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;
    private static final int NUMBER_TO_GENERATE = 6;

    public static String getRandomNumber(){
        return Randoms.pickUniqueNumbersInRange(START_INCLUSIVE,END_INCLUSIVE,NUMBER_TO_GENERATE).toString().replaceAll("[\\['\\]]","");
    }
}
