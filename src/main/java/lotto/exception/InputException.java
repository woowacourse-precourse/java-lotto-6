package lotto.exception;

import lotto.domain.Lotto;
import lotto.view.InputView;

import java.util.HashSet;
import java.util.Set;

public class InputException {
    public void checkThousandUnit(int money) {
        if (money % 1000 != 0 || money == 0) {
            throw new IllegalArgumentException("[ERROR] 1000단위로 입력해주세요.");
        }
    }

    public int inputExceptionCheck(String amount) {
        try {
            int money = toInt(amount);
            checkThousandUnit(money);
            return money;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new InputView().inputAmount();
        }
    }

    public int toInt(String amount) {
        if (!amount.matches("^[0-9]*$")) {
            throw new NumberFormatException("[ERROR] 숫자를 입력해 주세요.");
        }
        return Integer.parseInt(amount);
    }

    public String[] checkExceptionWinningNumber(String[] numbers) {
        try {
            checkNumberCount(numbers);
            for (int i = 0; i < 6; i++) {
                int number = toInt(numbers[i]);
                checkNotLottoNumber(number);
            }
            checkSameNumber(numbers);
            return numbers;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new InputView().winningNumber();
        }
    }

    public void checkNotLottoNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 1에서 45사이 값을 입력해 주세요.");
        }
    }

    public void checkNumberCount(String[] numbers) {
        if (numbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 6개를 입력해 주세요.");
        }
    }

    public int checkExceptionBonusNumber(String bonusNumber, Lotto winningLotto) {
        try {
            int number = toInt(bonusNumber);
            checkNotLottoNumber(number);
            checkContainsBonusNumber(winningLotto, number);
            return number;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new InputView().bonusNumber(winningLotto);
        }
    }

    public void checkSameNumber(String[] number) {
        Set<Integer> numbers = new HashSet<>();
        for (int i = 0; i < number.length; i++) {
            numbers.add(Integer.parseInt(number[i]));
        }
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("서로 다른 6개의 숫자를 입력하세요.");
        }
    }

    public void checkContainsBonusNumber(Lotto lotto, int bonusNumber) {
        if (lotto.toSet().contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호와 다른 번호를 입력해 주세요.");
        }
    }
}
