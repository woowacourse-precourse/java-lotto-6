package lotto.user;

import lotto.Validation;

public class Payment {
    private static final Validation validation = new Validation();

    public int getMoneyNumber(String purchaseMoney) {
        validation.checkNull(purchaseMoney);

        int moneyNumber;
        try {
            moneyNumber = convertStringToInteger(purchaseMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수 형식으로 입력해야 합니다.");
        }
        validation.checkUnit(moneyNumber);
        return moneyNumber;
    }

    private static Integer convertStringToInteger(String number) {
        number = number.trim();
        return Integer.parseInt(number);
    }
}
