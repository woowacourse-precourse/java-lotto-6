package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomGenerator {
    public static List<Integer> generateRandomNums(){
        List<Integer> randomLotto = new ArrayList<>();
        while (randomLotto.size() < 6) {
            int randomNumber = Randoms.pickNumberInRange(1, 45);
            if (!randomLotto.contains(randomNumber)) {
                randomLotto.add(randomNumber);
            }
        }
        return randomLotto;
    }
}
