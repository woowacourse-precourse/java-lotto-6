package lotto.interactor;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import lotto.Lotto;
import lotto.Lottos;

import java.util.List;

public class LottoMachine {

    public static final int TICKET_PRICE = 1000;

    public Lottos generateLottos(int ticketNums) {
        System.out.println();
        System.out.println(ticketNums + "개를 구매했습니다.");
        Lottos lottos = new Lottos();
        for (int ticket = 0; ticket < ticketNums; ticket++) {
            Lotto lotto = generateLotto();
            lottos.addLotto(lotto);
        }
        return lottos;
    }

    private Lotto generateLotto() {
        List<Integer> immutableNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> numbers = new ArrayList<>(immutableNumbers);
        Collections.sort(numbers);
        System.out.println(numbers);
        return new Lotto(numbers);
    }

}
