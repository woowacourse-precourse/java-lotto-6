package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        InputValidator inputValidator = new InputValidator();
        int money = 0;

        do {
            System.out.println("구입금액을 입력해 주세요.");
            money = inputValidator.checkMoneyValidate(Console.readLine());
        } while (money == 0);

    }
}
