package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumGenerator {
    private static final int START_NUM = 0;
    private static final int END_NUM = 6;

    public static List<Integer> generateRandomNums(){
        final List<Integer> lottoNums = new ArrayList<>();
        Collections.shuffle(lottoNums);
        return lottoNums.subList(START_NUM, END_NUM);
    }

}
