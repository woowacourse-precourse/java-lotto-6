package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class CreateWinNumber {

    private final ValidateInputNumber
            validateInputNumber = new ValidateInputNumber();
    public List<Integer> winNumber() {
        while (true) {
            List<Integer> allNumbers;
            System.out.println("당첨 번호를 입력해 주세요.");
            String prizeNumber = Console.readLine();
            try {
                allNumbers = validateInputNumber.validateWinNumber(prizeNumber);
                return new Lotto(allNumbers).getNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int bonusNumber() {
        while (true) {
            System.out.println("보너스 번호를 입력해 주세요.");
            String number = Console.readLine();
            try {
                return validateInputNumber.inputNumber(number);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
