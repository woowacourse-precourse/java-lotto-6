package lotto.purchase;

import camp.nextstep.edu.missionutils.Console;
public class Purchase {

    public static void main(String[] args) {
    }

    public static int purchase() {
        System.out.println("구입금액을 입력해 주세요.");
        String rawMoney = Console.readLine();

        checkNull(rawMoney);
        checkNumberFormat(rawMoney);

        int money = Integer.parseInt(rawMoney);
        checkMoney(money);
        int count = money / 1000;
        System.out.println(count + "개를 구매했습니다.");

        return count;
    }

    private static void checkNull(String input) {
        if (input == null || input.isEmpty()) {
            throw new NullPointerException("String is null or empty. \nerrorVar : " + input);
        }
    }

    private static void checkNumberFormat(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid number format. \nerrorVar : " + input);
        }
    }

    private static void checkMoney(int money) {
        try {
            if (money < 1000) {
                throw new IllegalArgumentException("최소 1000원 이상의 금액을 입력해주세요.");
            }
            if (money % 1000 != 0) {
                throw new IllegalArgumentException("1000원 단위로만 구매 가능합니다.");
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
