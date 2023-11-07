package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    public static List<Lotto> generateLottos(int quantity) {
        List<Lotto> allLotto = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            allLotto.add(new Lotto(createRandomNumbers()));
        }
        return allLotto;
    }

    public static List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public static void printGeneratedLottos(List<Lotto> allLotto, int quantity) {
        System.out.printf("\n%d개를 구매했습니다.\n", quantity);
        for (Lotto lotto : allLotto) {
            lotto.printNumbers();
        }
    }
}
