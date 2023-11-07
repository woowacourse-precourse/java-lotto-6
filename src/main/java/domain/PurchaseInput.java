package domain;

import camp.nextstep.edu.missionutils.Console;
import enums.LottoError;

public class PurchaseInput {
    public int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        while (true) {
            Integer amount = getInteger();
            if (amount != null)
                return amount;
        }
    }

    private Integer getInteger() {
        try {
            int amount = readPurchaseAmount();
            if (amount >= 0) {
                return amount;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private int readPurchaseAmount() {
        String input = Console.readLine();
        int amount = parseInput(input);
        if (amount == -1) {
            throw new IllegalArgumentException(LottoError.LOTTO_BUY_FORMAT_ERROR.getMessage());
        }
        if (amount < 0) { //음수 예외처리
            throw new IllegalArgumentException(LottoError.BUY_ENOUGH_MONEY_ERROR.getMessage());
        }
        if (amount < 1000) { //1~999 예외처리
            throw new IllegalArgumentException(LottoError.LOTTO_BUY_MIN_MONEY_ERROR.getMessage());
        }
        if (amount % 1000 != 0) { //1000으로 나누어 떨어지지 않을때 예외처리
            throw new IllegalArgumentException(LottoError.LOTTO_BUY_CORRECT_ERROR.getMessage());
        }
        return amount;
    }

    private int parseInput(String input) {
        int isNumber;

        try {
            isNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            isNumber = -1; //예외 발생 시 값을 -1로 설정
        }

        return isNumber;
    }
}