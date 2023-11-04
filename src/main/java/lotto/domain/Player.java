package lotto.domain;

import lotto.utils.LottoGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.constants.Error.DIVIDE_INVALID;
import static lotto.constants.Error.MINIMUM_INVALID;
import static lotto.constants.Rule.MIN_MONEY;

public class Player {
    private final int money;
    private final int amount;
    private final List<Lotto> lotto;

    private Player(int money, int amount, List<Lotto> lotto) {
        this.money = money;
        this.amount = amount;
        this.lotto = lotto;
    }

    public static Player from(int money) {
        validate(money);
        int amount = calculateAmount(money);
        List<Lotto> lotto = purchaseLotto(amount);
        return new Player(money, amount, lotto);
    }

    public int getMoney() {
        return money;
    }

    public int getAmount() {
        return amount;
    }

    public List<Lotto> getLotto() {
        return lotto;
    }

    private static void validate(int money) {
        validateMinimumMoney(money);
        validateDivideMoney(money);
    }

    private static void validateMinimumMoney(int money) {
        if (money < MIN_MONEY.getValue()) {
            throw new IllegalArgumentException(MINIMUM_INVALID.getMessage());
        }
    }

    private static void validateDivideMoney(int money) {
        if (money % MIN_MONEY.getValue() != 0) {
            throw new IllegalArgumentException(DIVIDE_INVALID.getMessage());
        }
    }

    private static List<Lotto> purchaseLotto(int amount) {
        return IntStream.range(0, amount)
                .mapToObj(i -> new Lotto(LottoGenerator.generateLotto()))
                .collect(Collectors.toList());
    }

    private static int calculateAmount(int money) {
        return money / MIN_MONEY.getValue();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Player\n");
        sb.append("구입금액: ").append(money).append("\n");
        sb.append("구입한 로또 수량: ").append(amount).append("\n");
        sb.append("구입한 로또:\n");
        for (int i = 0; i < lotto.size(); i++) {
            sb.append("로또 ").append(i + 1).append(": ").append(lotto.get(i)).append("\n");
        }
        return sb.toString();
    }
}
