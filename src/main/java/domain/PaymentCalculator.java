package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class PaymentCalculator {
    public static LottoTicket purchaseLottoTicket(int amount) {
        int numberOfLotto = amount / 1000;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < numberOfLotto; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }

        return new LottoTicket(lottos);
    }
}
