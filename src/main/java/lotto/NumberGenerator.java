package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberGenerator {
    public List<Integer> generateBall() {
        List<Integer> balls = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        hasDuplication(balls);
        Collections.sort(balls);
        return balls;
    }

    public void hasDuplication(List<Integer> balls) {
        Set<Integer> deDuplicate = new HashSet<>(balls);
        while (deDuplicate.size() != 6) {
            generateBall();
        }
    }
}
