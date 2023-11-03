package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Amount {

    public Amount() {
    }

    public int enterAmount() {
        int amount;

        while (true) {
            try {
                printAmountEnterGuideStatement();
                String input = Console.readLine();
                amount = validateAmount(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return amount;
    }

    private void printAmountEnterGuideStatement() {
        System.out.println("구입 금액을 입력해 주세요");
    }

    int validateAmount(String input) {
        int amount = isNum(input);
        return amount;
    }

    int isNum(String input) {
        String regex = "^[0-9]+$";
        if (!input.matches(regex)) {
            throw new IllegalArgumentException("[ERROR] 금액 값은 숫자여야 합니다.");
        }
        return stringToInt(input);
    }

    int stringToInt(String str) {
        return Integer.parseInt(str);
    }
}
