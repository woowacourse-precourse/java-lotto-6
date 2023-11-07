package lotto.domain.computer;

import static lotto.constant.ExceptionMessage.ENTER_DIVISIBLE_BY_THOUSAND;
import static lotto.constant.ExceptionMessage.ENTER_GREATER_THAN_ZERO;
import static lotto.constant.ExceptionMessage.ENTER_LESS_THAN_MAX_MONEY;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;

public class RandomLottoGenerator {

    private final int maxMoney = 1000000;
    private int money;

    public Lottos createUserLottos() {
        List<Lotto> lottos = createLottoList();
        return new Lottos(lottos);
    }

    private List<Lotto> createLottoList() {
        return IntStream.rangeClosed(1, money / 1000)
                .mapToObj(num -> createLotto())
                .toList();
    }

    private Lotto createLotto() {
        List<Integer> sortedNumbers =
                Randoms.pickUniqueNumbersInRange(1, 45, 6).stream()
                        .sorted(Integer::compareTo)
                        .toList();
        return new Lotto(sortedNumbers);
    }

    public void setMoney(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        checkGoe0(money);
        checkLoeMaxMoney(money);
        checkDivisibleBy1000(money);
    }

    private void checkGoe0(int money) {
        if (money < 0) {
            throw new IllegalArgumentException(ENTER_GREATER_THAN_ZERO.getMessage());
        }
    }

    private void checkLoeMaxMoney(int money) {
        if (money > maxMoney) {
            throw new IllegalArgumentException(maxMoney + ENTER_LESS_THAN_MAX_MONEY.getMessage());
        }
    }

    private void checkDivisibleBy1000(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ENTER_DIVISIBLE_BY_THOUSAND.getMessage());
        }
    }
}
