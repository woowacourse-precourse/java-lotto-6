package model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class LottoGenerate {
    public static int lottoTicketsCount(int moneyNumber) {
        return moneyNumber / 1000;
    }

    public static List<Integer> generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    public static Lotto lottoAscendingOrder(List<Integer> numbers) {
        Collections.sort(numbers);
        Lotto lotto = new Lotto(numbers);
        return lotto;
    }
}
