package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class Generator {

    private static final int RANDOM_START_NUMBER = 1;
    private static final int RANDOM_END_NUMBER = 45;
    private static final int RANDOM_PICK_SIZE = 6;


    public static List<Integer> createNumbers() {

        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(RANDOM_START_NUMBER, RANDOM_END_NUMBER,
                        RANDOM_PICK_SIZE).stream().distinct().sorted()
                .collect(Collectors.toList());

        return numbers;
    }


}
