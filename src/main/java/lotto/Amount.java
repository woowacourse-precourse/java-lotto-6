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
        isPositiveNum(input);
        int amount = stringToInt(input);
        return isDividedUp(amount);
    }

    int isDividedUp(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 1장의 가격은 1,000원입니다. 금액 값은 1,000원 단위로 입력해주세요.");
        }
        return amount;
    }

    void isPositiveNum(String input) {
        String regex = "^([1-9]+[0-9]*)$";
        if (!input.matches(regex)) {
            throw new IllegalArgumentException("[ERROR] 금액 값은 0보다 큰 숫자여야 합니다.");
        }
    }

    int stringToInt(String str) {
        return Integer.parseInt(str);
    }
}
