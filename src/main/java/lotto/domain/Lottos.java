package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static lotto.view.constatnt.Constant.*;

public class Lottos {
    private List<List<Integer>> lottos;

    public Lottos(List<List<Integer>> lottos) {
        this.lottos = lottos;
    }

    public static List<List<Integer>> createRandomLotto(int amount) {
        List<List<Integer>> lottos = new ArrayList<>();

        for(int i = 0; i < amount; i++) {
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(MIN_LENGTH, MAX_LENGTH, COUNT);
            sort(lotto);
            lottos.add(lotto);
        }
        return lottos;
    }

    private static void sort(List<Integer> randomLotto) {
        randomLotto.sort(Comparator.naturalOrder());
    }
}
