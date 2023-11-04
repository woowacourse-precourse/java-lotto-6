package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Utils {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int NUMBER_COUNT = 6;


    public static List<Integer> generateRandomUniqueNumber(){
        return Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, NUMBER_COUNT);
    }
    public static List<Integer> sortByAscending(List<Integer> list){
        List<Integer> orderedList = new ArrayList<Integer>(list);
        Collections.sort(orderedList);
        return orderedList;
    }

}
