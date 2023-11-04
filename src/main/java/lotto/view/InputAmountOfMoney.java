package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputAmountOfMoney {
    public int InputAmountOfMoney() {
        String amountOfMoney = Console.readLine();
        validate(amountOfMoney);
        return Integer.parseInt(amountOfMoney);
    }

    //메서드로 더 분리하자
    private void validate (String amountOfMoney) {
        validateMoneyType(amountOfMoney);
        if (Integer.parseInt(amountOfMoney) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
        if (Integer.parseInt(amountOfMoney) < 1000) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 이상이어야 합니다.");
        }
    }

    private static void validateMoneyType(String amountOfMoney) {
        try {
            Integer.parseInt(amountOfMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
    }

}
