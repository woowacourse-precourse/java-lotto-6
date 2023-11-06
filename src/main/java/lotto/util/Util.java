package lotto.util;

import static lotto.constant.LottoNumber.LOTTO_NUMBER_LENGTH;
import static lotto.constant.LottoNumber.MAXIMUM_LOTTO_NUMBER;
import static lotto.constant.LottoNumber.MINIMUM_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Util {
    public static String readInput() {
        return Console.readLine();
    }

    public static List<Integer> generateRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER.getNumber(), MAXIMUM_LOTTO_NUMBER.getNumber(), LOTTO_NUMBER_LENGTH.getNumber());
    }

    public static List<Integer> sortListAscending(List<Integer> result) {
        List<Integer> sortedResult = new ArrayList<>(result);
        Collections.sort(sortedResult);

        return sortedResult;
    }

}
