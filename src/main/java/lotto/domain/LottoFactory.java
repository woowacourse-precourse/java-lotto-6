package lotto.domain;


import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoFactory {
    public static Lotto generateLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        randomNumbers.sort(Comparator.naturalOrder());
        return new Lotto(randomNumbers);
    }

    public static List<Lotto> generateLotto(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i =0; i< count; i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    public static Lotties generateLotties(int count) {
        return new Lotties(generateLotto(count));
    }
}

