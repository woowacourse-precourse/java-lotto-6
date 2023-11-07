package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Market {
    public Market() {}

    public List<Lotto> issueLotto(int payment) {
        validatePayment(payment);
        int numberOfLotto = payment / Lotto.PRICE;

        System.out.println();
        System.out.println(numberOfLotto + "개를 구매했습니다.");

        List<Lotto> totalLotto = new ArrayList<>();
        for (int i=0; i<numberOfLotto; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            totalLotto.add(lotto);
            System.out.println(lotto);
        }
        return totalLotto;
    }

    private void validatePayment(int payment) {
        if (payment < Lotto.PRICE) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 이상이어야 합니다.");
        }
        if (payment % Lotto.PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000으로 나누어 떨어져야 합니다.");
        }
    }
}