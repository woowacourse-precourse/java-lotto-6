package lotto.computer;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import lotto.lotto.Lotto;
import lotto.lotto.Lottos;

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

    public int getMoney() {
        return money;
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
            throw new IllegalArgumentException("0이상의 값을 입력해 주세요.");
        }
    }

    private void checkLoeMaxMoney(int money) {
        if (money > maxMoney) {
            throw new IllegalArgumentException(maxMoney + "이하의 값을 입력해 주세요.");
        }
    }

    private void checkDivisibleBy1000(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("1000으로 나누어 떨어지는 값을 입력해 주세요.");
        }
    }
}
