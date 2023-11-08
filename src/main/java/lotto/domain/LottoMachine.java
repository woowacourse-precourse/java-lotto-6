package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    private Lottos lottos;
    
    public Lottos spinLotto(int spinAmount) {
        List<Lotto> pickedlottos = new ArrayList<>();

        while (spinAmount > 0) {
            pickedlottos.add(generateLotto(spinAmount));
            spinAmount--;
        }

        lottos = new Lottos(pickedlottos);

        return lottos;
    }

    private Lotto generateLotto(int spinAmount) {
        Lotto lotto = new Lotto(ascendingSort(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        return lotto;
    }

    private List<Integer> ascendingSort(List<Integer> number) {
        Collections.sort(number);
        return number;
    }

    
    
}
