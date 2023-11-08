package lotto.domain;

public class User {
    private final int pay;
    private final int lottoCnt;

    public User(String payment) {
        int pay = Integer.parseInt(payment);
        this.pay = pay;
        this.lottoCnt = pay/1000;
    }

    public static User paid(String pay) {
        return new User(pay);
    }

    public int getLottoCnt() {
        return lottoCnt;
    }
}
