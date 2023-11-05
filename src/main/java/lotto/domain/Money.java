package lotto.domain;

import lotto.system.ExceptionMessage;
import lotto.system.SystemConstant;
import lotto.system.SystemMessage;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Money {
    private final long value;

    private Money(long value) {
        validate(value);
        this.value = value;
    }

    public static Money from(long value) {
        return new Money(value);
    }

    public static Money createManual() {
        while (true) {
            OutputView.printFrom(SystemMessage.INPUT_MONEY);
            try {
                return new Money(InputView.readLong());
            } catch (IllegalArgumentException e) {
                OutputView.exceptionMessage(e);
            }
        }
    }

    private void validate(long value) {
        validateDivisible(value);
        validateEnought(value);
    }

    private void validateDivisible(long value) {
        if (value % SystemConstant.LOTTO_TICKET_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(ExceptionMessage.MONEY_NOT_DIVISIBLE.getMessage());
        }
    }

    private void validateEnought(long value) {
        if (value < SystemConstant.LOTTO_TICKET_PRICE.getValue()) {
            throw new IllegalArgumentException(ExceptionMessage.MONET_NOT_ENOUGH.getMessage());
        }
    }

    public int countPurchase() {
        return (int) (value / SystemConstant.LOTTO_TICKET_PRICE.getValue());
    }

    public double getProfitMargin(WinningStats winningStats) {
        long profit = winningStats.stream()
                .map(WinningStat::getProfit)
                .reduce(0L, Long::sum);
        return (((double) profit / value) * SystemConstant.MULT_FACTOR.getValue())
                / SystemConstant.DIV_FACTOR.getValue();
    }
}
