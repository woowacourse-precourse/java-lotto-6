package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int inputPurchaseAmount() {
        String amountStringValue = Console.readLine();
        validateNullValue(amountStringValue);

        int amountIntValue = parseStringToInt(amountStringValue);
        validateNoRemainderValue(amountIntValue);

        return amountIntValue;
    }

    public int parseStringToInt(String stringValue) {
        try {
            int intValue = Integer.parseInt(stringValue);
            return intValue;
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 정수값을 입력해 주세요.");
        }
    }

    void validateNullValue(String value) {
        if (value.isBlank()) throw new IllegalArgumentException("[ERROR] 금액을 정확히 입력해 주세요.");
    }

    void validateNoRemainderValue(int value) {
        if (value % 1000 != 0) throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해 주세요.");
    }
}
