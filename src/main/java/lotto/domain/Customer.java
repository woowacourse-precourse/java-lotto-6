package lotto.domain;

public class Customer {
    private int lottoCount;
    private int paymentAmount;

    public Customer(int lottoCount, int paymentAmount) {
        this.lottoCount = lottoCount;
        this.paymentAmount = paymentAmount;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public int getPaymentAmount() {
        return paymentAmount;
    }
}
