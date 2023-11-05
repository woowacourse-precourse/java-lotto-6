package lotto.Util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;

public class Util {

    public static ArrayList<String> toArrayList(String lottoNums) {
        return new ArrayList<>(Arrays.asList(lottoNums.toString()));
    }

    public static int getRandomNum() {
        return Randoms.pickNumberInRange(Rule.MIN_LENGTH, Rule.MAX_LENGTH);
    }



}
