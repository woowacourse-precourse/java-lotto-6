package lotto;

import lotto.handler.UserHandler;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
//        UserHandler.getAmountFromUser();
        int amount = UserHandler.getAmountFromUser();
        UserHandler.getLottoCountFromUser(amount);
    }
}
