package lotto;

import static lotto.Enum.InputMessage.INPUT_PURCHASE_AMOUNT;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String input;
        int money;

        while (true) {
            try {
                System.out.println(INPUT_PURCHASE_AMOUNT.getMessage());
                input = Console.readLine();
                Exception.checkIfNumber(input);
                money = Integer.parseInt(input);
                Exception.checkUnit(money);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
