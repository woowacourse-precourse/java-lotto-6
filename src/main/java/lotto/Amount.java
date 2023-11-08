package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Amount {

    InputValidation iv = new InputValidation();

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
        return isDividedUp(iv.toInt(input));
    }

    int isDividedUp(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 1장의 가격은 1,000원입니다. 금액 값은 1,000원 단위로 입력해주세요.");
        }
        return amount;
    }
}
