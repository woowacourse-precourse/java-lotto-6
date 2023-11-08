package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberPicker {
    private static final int START_RANGE = 1;
    private static final int END_RANGE = 45;
    private static final int COUNT = 6;

    public static List<Integer> getRandomNum() {
        List<Integer> numberGroup = new ArrayList<>();
        while (numberGroup.size() != 6) {
            numberGroup = Randoms.pickUniqueNumbersInRange(START_RANGE, END_RANGE, COUNT);
            numberGroup.stream().distinct().collect(Collectors.toList());
        }
        Collections.sort(numberGroup);
        return numberGroup;
    }
}
