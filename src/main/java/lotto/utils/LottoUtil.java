package lotto.utils;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoUtil {
    final String NUM_COMMA_REG = "^[0-9,]+$";

    public String getUserInput() {
        return Console.readLine();
    }

    public List<List<Integer>> getLottos(int count) {
        List<List<Integer>> lottos = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(numbers);
        }
        return lottos;
    }

    public boolean validateWinningNumber(String winningNumber) {
        if(winningNumber.matches(NUM_COMMA_REG)) {
            return true;
        }
        return false;
    }

}
