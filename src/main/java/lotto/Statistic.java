package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Statistic {
    private List<Lotto> lottos;
    private List<Integer> winner;
    private int bonusNumber;

    public Statistic(int bonusNumber, Lotto lotto) {
        lottos = new LinkedList<>();
        this.bonusNumber = bonusNumber;
        winner = lotto.getLottoNumbers();
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }
}
