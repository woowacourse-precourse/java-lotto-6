package lotto.io.game;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.Test;

class LottoStoreRandomsTest {

    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 45;
    public static final int COUNT = 6;

    @Test
    void getSixNumbers() {
        int numberOfTests = 1_000;
        for (int i = 0; i < numberOfTests; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, COUNT);
            assert numbers.size() == COUNT;
            assert numbers.stream().min(Comparator.naturalOrder()).get() >= START_INCLUSIVE;
            assert numbers.stream().max(Comparator.naturalOrder()).get() <= END_INCLUSIVE;
        }
    }

}