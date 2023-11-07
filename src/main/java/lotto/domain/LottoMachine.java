package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Money;

public class LottoMachine {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final int SIZE = 6;

    private final List<List<Integer>> lottoCandidates = new ArrayList<>();

    public List<List<Integer>> generateLotto(Money money) {
        int numberOfLotto = money.perUnit();
        for (int i = 0; i < numberOfLotto; i++) {
            pickAndSave();
        }
        return lottoCandidates;
    }
    private void pickAndSave() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN, MAX, SIZE);
        lottoCandidates.add(numbers);
    }

    public List<Lotto> getLottos() {
        return lottoCandidates.stream()
                .map(Lotto::new)
                .toList();
    }
}
