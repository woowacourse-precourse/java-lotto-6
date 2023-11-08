package lotto.domain;

public class User {
    private final int pay;

    public User(String payment) {
        int pay = Integer.parseInt(payment);
        this.pay = pay;
    }

    public static User paid(String pay) {
        return new User(pay);
    }
}
