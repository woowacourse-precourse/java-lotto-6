package lotto.domain;

public class BuyAmount {
    private static final int LOTTO_PRICE = 1000;

    private final int payment;
    private final int numberOfLottos;

    public BuyAmount(int payment) {
        validate(payment);
        this.payment = payment;
        this.numberOfLottos = calculateNumberOfBuyAmount(this.payment);
    }

    public int getPayment() {
        return payment;
    }

    public int getNumberOfLottos() {
        return numberOfLottos;
    }

    private void validate(int payment) {
        if (!isPaymentsForThousand(payment)) {
            throw new IllegalArgumentException();
        }
        if (isZero(payment)) {
            throw new IllegalArgumentException();
        }
        if (!isPlus(payment)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isPlus(int payment) {
        if (payment <= 0) {
            return false;
        }
        return true;
    }

    private boolean isZero(int payment) {
        if (payment != 0) {
            return false;
        }
        return true;
    }

    private boolean isPaymentsForThousand(int payment) {
        if (payment % LOTTO_PRICE != 0) {
            return false;
        }
        return true;
    }

    private int calculateNumberOfBuyAmount(int payment) {
        return payment / LOTTO_PRICE;
    }
}
