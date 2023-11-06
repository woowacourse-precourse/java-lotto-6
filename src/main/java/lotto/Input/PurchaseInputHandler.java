package lotto.Input;

import camp.nextstep.edu.missionutils.Console;

public class PurchaseInputHandler {
    public static int getAmount() {
        while (true) {
            try {
                int convertedInt = convertValidAmount(Console.readLine());
                validateAmount(convertedInt);
                return convertedInt;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    private static int convertValidAmount(String input) {
        try {
            String amountInput = input.replace(",", "");
            return Integer.parseInt(amountInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 올바른 형식이 아닙니다. 1000원 단위로 다시 입력해주세요.");
        }

    }


    private static void validateAmount(int amount) {
        if (amount < 1000) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 이상이어야 합니다.");
        }
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 올바른 형식이 아닙니다. 1000원 단위로 다시 입력해주세요.");
        }
    }

}