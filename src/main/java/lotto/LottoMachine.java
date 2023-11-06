package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public static final int PRICE = 1000;

    public List<Lotto> buy(int money) throws IllegalArgumentException {
        validateMoney(money);
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < money / PRICE; i++) {
            tickets.add(getRandomLotto());
        }
        return tickets;
    }

    private void validateMoney(int cash) {
        if (cash % PRICE != 0) {
            throw new IllegalArgumentException("1,000원으로 나누어 떨어지지 않습니다");
        }
    }

    private Lotto getRandomLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }
}
