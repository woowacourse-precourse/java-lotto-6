package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Util {
    public static List<Integer> toList(String inputWinningNum){
        String[] winningNumArray = inputWinningNum.split(Constants.SEPARATOR);
        List<Integer> winningNumList = new ArrayList<>();

        for(String s : winningNumArray) {
            winningNumList.add(Integer.parseInt(s));
        }
        return winningNumList;
    }

    public static List<Integer> getRandomNum() {
        return Randoms.pickUniqueNumbersInRange(Constants.RANDOM_START_NUM, Constants.RANDOM_END_NUM, Constants.RANDOM_WINNING_NUM_COUNT);
    }

    public static List<Integer> sortRandomNum(List<Integer> randomNum) {
        Collections.sort(randomNum);
        return randomNum;
    }
}
