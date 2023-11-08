package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Money;

public class LottoMachine {

    private final List<List<Integer>> lottoCandidates = new ArrayList<>();

    public List<List<Integer>> generateLotto(final Money money) {
        int numberOfLotto = money.perUnit();
        for (int i = 0; i < numberOfLotto; i++) {
            pickAndSave();
        }
        return deepCopy(lottoCandidates);
    }

    private void pickAndSave() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LottoRule.MIN.value(),
                LottoRule.MAX.value(),
                LottoRule.SIZE.value()
        );
        lottoCandidates.add(numbers);
    }

    private List<List<Integer>> deepCopy(List<List<Integer>> lottoCandidates) {
        List<List<Integer>> copied = new ArrayList<>();
        for (List<Integer> lottoCandidate : lottoCandidates) {
            copied.add(new ArrayList<>(lottoCandidate));
        }
        return copied;
    }

    public List<Lotto> getLottos() {
        return lottoCandidates.stream()
                .map(Lotto::new)
                .toList();
    }
}
