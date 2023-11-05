package lotto.func;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class LottoDraw {
    public static List<Integer> generateRandomLotto() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < 6) {
            int randomNum = Randoms.pickNumberInRange(1, 45);

            if (!numbers.contains(randomNum)) {
                numbers.add(randomNum);
            }
        }

        return numbers;
    }
}
