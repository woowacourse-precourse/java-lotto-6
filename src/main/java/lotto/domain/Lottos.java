package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.function.Predicate;

public class Lottos {
    private List<Lotto> lottos;
    private NumberPicker numberPicker;

    public Lottos(NumberPicker numberPicker) {
        this.lottos = new ArrayList<>();
        this.numberPicker = numberPicker;
    }

    public List<Lotto> generate(int count) {
        while (count > 0) {
            Lotto newLotto = createLotto();
            if (!isDuplicated(newLotto)) {
                lottos.add(newLotto);
                count--;
            }
        }

        return lottos;
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
