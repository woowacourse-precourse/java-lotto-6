package lotto;

import lotto.model.User;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        User user = new User();
        int money = user.inputPurchaseAmount();
    }
}
