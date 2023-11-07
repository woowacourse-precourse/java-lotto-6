package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class Lottos {
    private List<Lotto> lottos;
    private NumberPicker numberPicker;

    public Lottos(NumberPicker numberPicker) {
        this.lottos = new ArrayList<>();
        this.numberPicker = numberPicker;
    }

    public void generate(int count) {
        while (count > 0) {
            Lotto newLotto = createLotto();
            if (!isDuplicated(newLotto)) {
                lottos.add(newLotto);
                count--;
            }
        }
    }

    public Map<Integer, Integer> countNumberOfWins(Lotto winningLotto, BonusNumber bonusNumber) {
        HashMap<Integer, Integer> numberByRank = new HashMap<>();
        lottos.forEach(lotto -> {
            int rank = lotto.judge(winningLotto, bonusNumber);
            numberByRank.put(rank, numberByRank.getOrDefault(rank, 0) + 1);
        });

        return numberByRank;
    }

    public List<List<Integer>> getOrderedList() {
        return lottos.stream()
                .map(Lotto::getSortedNumbers)
                .toList();
    }

    private Lotto createLotto() {
        return new Lotto(numberPicker.pick());
    }

    private boolean isDuplicated(Lotto newLotto) {
        return lottos.stream()
                .anyMatch(isAleadyIn(newLotto));
    }

    private Predicate<Lotto> isAleadyIn(Lotto newLotto) {
        return lotto -> new HashSet<>(lotto.getSortedNumbers())
                .containsAll(newLotto.getSortedNumbers());
    }
}
