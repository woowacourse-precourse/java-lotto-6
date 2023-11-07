package domain;

import enums.LottoError;

public class PurchaseInput {
    public int readPurchaseAmount(String input) {
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