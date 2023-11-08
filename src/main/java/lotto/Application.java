package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        User user = new User();
        user.getLotto();
        Store store = new Store();
        store.getTargetNumbers();
        store.getBonusNumber();
    }
}
