package lotto;

import static java.lang.String.format;
import static lotto.Constant.FIFTH;
import static lotto.Constant.ZERO;

import java.util.Map;

public class ResultMessage {

    private static final int INCREASE = 1;

    public String[] makingStatics(Map<Integer, Long> gainStatics) {
        int size = gainStatics.size();
        String[] statics = new String[size];
        eachStatics(gainStatics, statics);
        return statics;
    }

    private static void eachStatics(Map<Integer, Long> gainStatics, String[] statics) {

        for (int i = ZERO; i < FIFTH; i++) {
            statics[i] = format("%s%d개", Result.getByKey(i + INCREASE).getValue(), gainStatics.get(i + INCREASE));
        }
    }
}