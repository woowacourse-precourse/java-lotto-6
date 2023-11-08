package lotto.domain;

import java.util.List;

public class User {
    public int payment;
    public final List<List<Integer>> userLottos;
    public User(int payment) {
        this.payment = payment;
        userLottos = Lotto.publish(this.payment);
    }

//    public static User publishLotto(String payment) {
//        return new User(null);
//    }

    @Override
    public String toString() {
        return "User{" +
                "payment=" + payment +
                ", userLottos=" + userLottos +
                '}';
    }
}
