package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberPicker {
    private List<Integer> numberGroup = new ArrayList<>();
    private final int START_RANGE = 1;
    private final int END_RANGE = 45;
    private final int COUNT = 6;

    private List<Integer> getRandomNum() {
        while (numberGroup.size() != 6) {
            numberGroup = Randoms.pickUniqueNumbersInRange(START_RANGE, END_RANGE, COUNT);
            numberGroup.stream().distinct().collect(Collectors.toList());
        }
        Collections.sort(numberGroup);
        return numberGroup;

    }
}
