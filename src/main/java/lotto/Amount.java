package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Amount {

    public Amount() {
    }

    public int enterAmount() {
        int lottoNum;

        while (true) {
            try {
                printAmountEnterGuideStatement();
                String input = Console.readLine();
                lottoNum = validateAmount(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return lottoNum;
    }

    private void printAmountEnterGuideStatement() {
        System.out.println("구입 금액을 입력해 주세요");
    }

    int validateAmount(String input) {
        isNum(input);
        int amount = stringToInt(input);
        return isDividedUp(amount);
    }

    int isDividedUp(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 1장의 가격은 1,000원입니다. 금액 값은 1,000원 단위로 입력해주세요.");
        }
        return amount / 1000;
    }

    void isNum(String input) {
        String regex = "^[0-9]+$";
        if (!input.matches(regex)) {
            throw new IllegalArgumentException("[ERROR] 금액 값은 숫자여야 합니다.");
        }
    }

    int stringToInt(String str) {
        return Integer.parseInt(str);
    }
}
