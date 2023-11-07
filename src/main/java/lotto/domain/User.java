package lotto.domain;

import java.util.List;

public class User {
    int payment;
    List<List<Integer>> userLottos;
    public User(String payment) {
        this.payment = InputHandler.convertStringToInteger(payment);
        userLottos = Lotto.publish(this.payment);
    }

    public static User publishLotto(String payment) {
        return new User(null);
    }

}
