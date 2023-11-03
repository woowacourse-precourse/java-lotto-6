package lotto.exception;

import lotto.view.InputView;

public class InputException {
    public void checkThousandUnit(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000단위로 입력해주세요.");
        }
    }

    public void inputExceptionCheck(String amount) {
        try {
            int money = toInt(amount);
            checkThousandUnit(money);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            new InputView().inputAmount();
        }
    }

    public int toInt(String amount) {
        if (!amount.matches("^[0-9]*$")) {
            throw new NumberFormatException("[ERROR] 숫자를 입력해 주세요.");
        }
        return Integer.parseInt(amount);
    }

    public void checkExceptionWinningNumber(String[] numbers) {
        for (int i = 0; i < 6; i++) {
            try {
                int number = toInt(numbers[i]);
                checkNotLottoNumber(number);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                new InputView().winningNumber();
            }
        }
    }

    public void checkNotLottoNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("1에서 45사이 값을 입력해 주세요.");
        }
    }
}
