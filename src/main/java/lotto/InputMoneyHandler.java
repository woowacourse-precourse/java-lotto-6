package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputMoneyHandler {
    static final int pricePerPiece = 1000;
    private int verifiedMoney;

    InputMoneyHandler() {
    }

    public void init() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String moneyInput = Console.readLine();
                if (!convertStringToInt(moneyInput)) throw new IllegalArgumentException("문자가 아닌 숫자를 입력해주세요.");
                if (!isValidInput()) throw new IllegalArgumentException("0원 보다 큰 금액을 입력해주세요.");
                if (!isDivisible()) throw new IllegalArgumentException("1000원 단위의 금액을 입력해주세요.");

                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    public boolean convertStringToInt(String moneyInput) {
        try {
            verifiedMoney = Integer.parseInt(moneyInput);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isDivisible() {
        return verifiedMoney % pricePerPiece == 0;
    }

    public boolean isValidInput() {
        return verifiedMoney > 0;
    }

    public int exceptionHandledMoney() {
        return verifiedMoney;
    }

}
