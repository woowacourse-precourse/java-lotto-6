package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

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
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Constants.RANDOM_START_NUM, Constants.RANDOM_END_NUM, Constants.NUM_COUNT);
        List<Integer> noDuplication = new ArrayList<>(numbers.stream().distinct().toList());

        while(noDuplication.size() < Constants.NUM_COUNT){
            noDuplication.add(Randoms.pickNumberInRange(Constants.RANDOM_START_NUM, Constants.RANDOM_END_NUM));
        }

        return noDuplication;
    }

    public static List<Integer> sortRandomNum(List<Integer> randomNum) {
        Collections.sort(randomNum);
        return randomNum;
    }
}
