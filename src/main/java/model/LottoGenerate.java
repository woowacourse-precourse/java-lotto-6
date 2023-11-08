package model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGenerate {
    public static int lottoTicketsCount(int moneyNumber) {
        return moneyNumber / 1000;
    }

    public static List<Integer> generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }
}
