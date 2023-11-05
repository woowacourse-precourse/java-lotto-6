package lotto;

import static lotto.StringUtil.*;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BuyingController buyingController = new BuyingController();

        System.out.println(ENTER_PAY_AMOUNT.getMessage());
        buyingController.handle(Console.readLine());
    }
}
