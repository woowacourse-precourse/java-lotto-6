package lotto;

import camp.nextstep.edu.missionutils.Console;

public class GetInput {
    public static int askPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        while (true) {
            String purchaseMoney = Console.readLine();
            if (!isPurchaseMoneyInteger(purchaseMoney)) {
                continue;
            }
            if (!isPurchaseMoneyPositive(purchaseMoney)) {
                continue;
            }
            if (!isPurchaseMoneyThousands(purchaseMoney)) {
                continue;
            }
            return Integer.parseInt(purchaseMoney);
        }
    }

    public static boolean isPurchaseMoneyInteger(String purchaseMoney) {
        try {
            CheckInputValidation.isItInteger(purchaseMoney);
        } catch (IllegalArgumentException ex) {
            System.out.println("[ERROR] 구입금액은 숫자로 입력해주세요.");
            return false;
        }
        return true;
    }

    public static boolean isPurchaseMoneyPositive(String purchaseMoney) {
        try {
            CheckInputValidation.isItPositive(purchaseMoney);
        } catch (IllegalArgumentException ex) {
            System.out.println("[ERROR] 구입금액은 양수로 입력해주세요.");
            return false;
        }
        return true;
    }

    public static boolean isPurchaseMoneyThousands(String purchaseMoney) {
        try {
            CheckInputValidation.isItThousands(purchaseMoney);
        } catch (IllegalArgumentException ex) {
            System.out.println("[ERROR] 구입금액은 1000의 배수로 입력해주세요.");
            return false;
        }
        return true;
    }
}
