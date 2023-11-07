package domain;

import camp.nextstep.edu.missionutils.Console;
import enums.LottoError;

public class PurchaseInput {
    public int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        while (true) {
            int amount = readPurchaseAmount();
            if (amount >= 0) {
                return amount;
            }
        }
    }

    private int readPurchaseAmount() {
        String input = Console.readLine();
        int amount = parseInput(input);

        if (amount == -1) {
            return -1;
        }

        if (amount < 0) {
            System.out.println(LottoError.BUY_ENOUGH_MONEY_ERROR.getMessage());
            return -1;
        }

        if (amount < 1000) {
            System.out.println(LottoError.LOTTO_BUY_MIN_MONEY_ERROR.getMessage());
            return -1;
        }

        if (amount % 1000 != 0) {
            System.out.println(LottoError.LOTTO_BUY_CORRECT_ERROR.getMessage());
            return -1;
        }

        return amount;
    }

    private int parseInput(String input) {
        int isNumber;

        try {
            isNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println(LottoError.LOTTO_BUY_FORMAT_ERROR.getMessage());
            isNumber = -1; //예외 발생 시 값을 -1로 설정
        }

        return isNumber;
    }
}