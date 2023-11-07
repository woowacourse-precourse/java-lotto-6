package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class Generator {

    public List<Lotto> generateLottos(int start, int end, int purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseAmount; i++) {
            lottos.add(generateLotto(start, end, purchaseAmount));
        }
        return lottos;
    }

    public Lotto generateLotto(int start, int end, int purchaseAmount) {
        List<Integer> numbers = Generator.generateNumbers(start, end, purchaseAmount);
        return new Lotto(numbers);
    }

    public static List<Integer> generateNumbers(int start, int end, int count) {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(start, end, count);
        return numbers;
    }
}
