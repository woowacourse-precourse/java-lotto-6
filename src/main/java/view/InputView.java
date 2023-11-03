package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int inputPurchaseAmount() {
        String amountStringValue = Console.readLine();

        int amountIntValue = parseStringToInt(amountStringValue);

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

}
