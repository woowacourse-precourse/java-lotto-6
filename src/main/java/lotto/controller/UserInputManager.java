package lotto.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInputManager {


    public String getPurchasePriceInput() {
        String purchasePriceInput;
        boolean isOkayToInput;
        do {
            purchasePriceInput = readLine();
            isOkayToInput = isDigit(purchasePriceInput) && isThousandUnit(purchasePriceInput);
            if (!isOkayToInput) {
                System.out.println("[ERROR] 숫자만 입력하실 수 있으며, 1000단위로 입력해주세요.");
            }
        } while (!isOkayToInput);
        return purchasePriceInput;
    }

    public String getBonusNumberInput() {
        String bonusNumberInput;
        boolean isOkayToInput;
        do {
            bonusNumberInput = readLine();
            isOkayToInput = isDigit(bonusNumberInput) && isInRange(bonusNumberInput);
            if (!isOkayToInput) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        } while (!isOkayToInput);

        return bonusNumberInput;
    }


    public String getWinningNumbersInput() { return readLine();}

    private boolean isThousandUnit(String input) {
        return Integer.parseInt(input) % 1000 == 0;
    }

    private boolean isDigit(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }


    private boolean isInRange(String input) {
        return Integer.parseInt(input) <= 45 && Integer.parseInt(input) >= 0;
    }


}
