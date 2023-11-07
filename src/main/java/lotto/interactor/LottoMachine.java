package lotto.interactor;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import lotto.Lotto;
import lotto.Lottos;

import java.util.List;

public class LottoMachine {

    public Lottos generateLottos(int ticketNums) {
        Lottos lottos = new Lottos();
        for (int ticket = 0; ticket < ticketNums; ticket++) {
            Lotto lotto = generateLotto();
            lottos.addLotto(lotto);
        }
        return lottos;
    }

    private Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        System.out.println(numbers);
        return new Lotto(numbers);
    }
}
