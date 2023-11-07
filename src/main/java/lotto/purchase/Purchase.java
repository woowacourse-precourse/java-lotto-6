package lotto.purchase;

import camp.nextstep.edu.missionutils.Console;

import static lotto.handler.ExceptionHandler.handle;

public class Purchase {

    public static void main(String[] args) {
    }

    public static int purchase() {
        System.out.println("구입금액을 입력해 주세요.");
        String rawMoney = getValidMoneyFromUser();
        int money = Integer.parseInt(rawMoney);

        money = updateMoneyWithValidation(rawMoney, money);

        int count = money / 1000;
        System.out.println(count + "개를 구매했습니다.");
        return count;
    }

    private static String getValidMoneyFromUser() {
        String rawMoney = Console.readLine();

        while (true) {
            try {
                checkNull(rawMoney);
                checkNumberFormat(rawMoney);
                return rawMoney;
            } catch (NullPointerException | NumberFormatException e) {
                handle(e);
                rawMoney = Console.readLine();
            }
        }
    }

    private static int updateMoneyWithValidation(String rawMoney, int money) {
        while (true) {
            try {
                checkMoney(money);
                return money;
            } catch (IllegalArgumentException e) {
                handle(e);
                rawMoney = getValidMoneyFromUser();
                money = Integer.parseInt(rawMoney);
            }
        }
    }

    private static void checkNull(String input) {
        if (input == null || input.isEmpty()) {
            throw new NullPointerException("String is null or empty. \n └─ errorVar : " + input);
        }
    }

    private static void checkNumberFormat(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid number format. \n └─ errorVar : " + input);
        }
    }

    private static void checkMoney(int money) {
        try {
            if (money < 1000) {
                throw new IllegalArgumentException("Input at least over 1000₩. \n └─ errorVar : " + money);
            }
            if (money % 1000 != 0) {
                throw new IllegalArgumentException("Input multiple of 1000₩. \n └─ errorVar : " + money);
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
