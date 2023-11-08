package lotto.generator;

import camp.nextstep.edu.missionutils.Console;

import lotto.handler.ExceptionHandler;

public class Purchase {

    public static void main(String[] args) {
    }

    public static int purchase() {
        System.out.println("구입금액을 입력해 주세요.");
        String rawMoney = getValidMoneyFromUser();
        int money = Integer.parseInt(rawMoney);

        money = updateMoneyWithValidation(rawMoney, money);

        int count = money / 1000;
        System.out.println("\n" + count + "개를 구매했습니다.");
        return count;
    }

    private static String getValidMoneyFromUser() {
        String rawMoney = Console.readLine();

        while (true) {
            try {
                ExceptionHandler.checkNull(rawMoney);
                ExceptionHandler.checkNumberFormat(rawMoney);
                return rawMoney;
            } catch (NullPointerException | NumberFormatException e) {
                ExceptionHandler.handle(e);
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
                ExceptionHandler.handle(e);
                rawMoney = getValidMoneyFromUser();
                money = Integer.parseInt(rawMoney);
            }
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
