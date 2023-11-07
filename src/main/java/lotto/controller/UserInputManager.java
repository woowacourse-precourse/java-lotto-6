package lotto.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInputManager {


    public String getPurchasePriceInput() {
        String input = readLine();
        if (!isDigit(input)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력하실 수 있습니다.");
        }
        if (!isThousandUnit(input)) {
            throw new IllegalArgumentException("[ERROR] 1000단위의 숫자만 입력하실 수 있습니다.");
        }
        return input;
    }


    public String getBonusNumberInput() {
        String input = readLine();
        if (!isDigit(input)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (!isInRange(input)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        return input;
    }

    public String getWinningNumbersInput() {
        return readLine();
    }

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
        if (Integer.parseInt(input) > 45 || Integer.parseInt(input) < 0) return false;
        return true;
    }


}
