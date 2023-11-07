package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class SystemInput {
    public static int readMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();
        validateMoney(purchaseAmount);
        return Integer.parseInt(purchaseAmount);
    }

    public static void validateMoney(String purchase) {
        validateNone(purchase);
        validateDivision(purchase);
    }

    public static void validateNone(String purchase) {
        if (purchase.length() == 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateDivision(String purchase) {
        int money = Integer.parseInt(purchase);
        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    public static String readPickLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static String readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

}
