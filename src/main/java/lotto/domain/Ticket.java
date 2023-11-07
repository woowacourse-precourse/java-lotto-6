package lotto.domain;

import static lotto.constant.LottoConstant.MONEY_UNIT;
import static lotto.exception.ErrorMessage.INVALID_UNIT;
import static lotto.exception.ErrorMessage.NOT_ENOUGH_MONEY;

import java.util.stream.Stream;
import lotto.exception.LottoException;

public class Ticket {

    private final int count;

    private Ticket(final int count) {
        this.count = count;
    }

    public static Ticket from(final int money) {
        validateMoney(money);
        return new Ticket(calculateCount(money));
    }

    private static void validateMoney(final int money) {
        validateAmountMoney(money);
        validateUnit(money);
    }

    private static void validateAmountMoney(int money) {
        if (isNotEnough(money)) {
            throw LottoException.from(NOT_ENOUGH_MONEY);
        }
    }

    private static boolean isNotEnough(final int money) {
        return money < MONEY_UNIT.getValue();
    }

    private static void validateUnit(int money) {
        if (isNotCorrectUnit(money)) {
            throw LottoException.from(INVALID_UNIT);
        }
    }

    private static boolean isNotCorrectUnit(final int money) {
        return money % MONEY_UNIT.getValue() != 0;
    }

    private static int calculateCount(final int money) {
        return money / MONEY_UNIT.getValue();
    }

    public Lottos buyLottos(final NumberGenerator numberGenerator) {
        return Lottos.from(Stream.generate(numberGenerator::generate)
                .limit(count)
                .map(Lotto::new)
                .toList());
    }
}
