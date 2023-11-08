package study;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomsTest {

    @DisplayName("pickUniqueNumbersInRange 사용해보기")
    @Test
    void pickUniqueNumbersInRange_사용해보기() {
        List<Integer> numbers = pickUniqueNumbersInRange(1, 45, 6);
        System.out.println("numbers = " + numbers);
    }
}
