package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int PICK_NUMBER = 6;

    public static List<Lotto> generateLotto(int lottoQuantity) {
        List<Lotto> pickLotto = new ArrayList<>();

        for (int i = 0; i < lottoQuantity; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, PICK_NUMBER);
            Lotto lotto = new Lotto(numbers);
            pickLotto.add(lotto);
            printLotto(lotto);
        }
        return pickLotto;
    }

    public static void printLotto(Lotto lotto) {
        System.out.print("[");
        List<Integer> numbers = new ArrayList<>(lotto.getNumbers());
        Collections.sort(numbers);
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i));
            if (i < numbers.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
