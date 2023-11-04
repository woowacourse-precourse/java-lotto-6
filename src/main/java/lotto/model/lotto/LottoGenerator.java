package lotto.model.lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LottoGenerator {
    public final Lotto lotto;
    public LottoGenerator() {
        this.lotto = generateLotto(6);
    }
    public static Lotto generateLotto(int count) {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < count) {
            int number = Randoms.pickNumberInRange(1,45);
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

}
