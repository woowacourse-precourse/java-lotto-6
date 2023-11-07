package lotto.exception;

import lotto.Constants;

public class Exception {
    public int checkInt(String totalAmount) {
        int amount = 0;
        try {
            amount = Integer.parseInt(totalAmount);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 금액은 1000 단위 숫자로 입력해주세요.");
            throw new IllegalArgumentException(e);
        } finally {
            if (amount < 0) System.out.println("[ERROR] 금액은 1000 단위 숫자로 입력해주세요.");
            return amount;
        }
    }

    public boolean checkAmount(int totalAmount, boolean correctAmount) {
        if (totalAmount % Constants.LOTTOPRICE != 0) {
            try {
                System.out.println("[ERROR] 금액은 1000 단위 숫자로 입력해주세요.");
                throw new IllegalArgumentException();
            } finally {
                return correctAmount;
            }
        }
        correctAmount = true;
        return correctAmount;
    }
}
