package lotto.utils;

import static lotto.enums.Constants.*;

import camp.nextstep.edu.missionutils.Randoms;

public class GeneratedLottoNumber {

    public static String getRandomNumber(){
        return Randoms.pickUniqueNumbersInRange(MIN_INCLUSIVE.getValue(), MAX_INCLUSIVE.getValue(), LOTTO_NUMBER_SIZE.getValue()).toString().replaceAll("[\\['\\]]","");
    }
}
