package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int inputPrice() {
        String input = Console.readLine();

        while (!validate(input)) {
            input = Console.readLine();
        }
        return Integer.parseInt(input);
    }

    private boolean validate(String input) {
        try {
            int price = Integer.parseInt(input);
            checkDividedByThousand(price);
            return true;
        } catch (NumberFormatException ne) {
            System.out.println("[ERROR] 숫자를 입력하세요.");
        } catch (IllegalArgumentException ie) {
            System.out.println("[ERROR] 금액은 1000원 단위여야 합니다.");
        }
        return false;
    }

    private void checkDividedByThousand(int price) throws IllegalArgumentException {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}
