package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class WinningNumber {

    private List<Integer> winnerNumbers = new ArrayList<>();

    private int bonusNumber;

    public List<Integer> getWinnerNumbers() {
        return winnerNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void inputWinnerNumbers() {
        while (true) try {
            this.winnerNumbers = inputWinnerNumbersValidation(readLine());
            break;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
    }


    public void inputBonusNum() {
        while (true) try {
            this.bonusNumber = inputBonusNumberValidation(readLine());
            break;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
    }

    private List<Integer> inputWinnerNumbersValidation(String inputWinnerNumbers) {
        List<Integer> numbers = new ArrayList<>();
        List<String> inputNumbers = Arrays.stream(inputWinnerNumbers.split(",")).toList();
        for (String inputNumber : inputNumbers) {
            int number = parseToNumber(inputNumber);
            checkNumberInRange(number);
            checkNumberDuplicate(number, numbers);
            numbers.add(number);
        }

        checkSizeValidate(numbers);

        return numbers;
    }

    private int inputBonusNumberValidation(String inputBonusNumber) {
        int bonusNumber = parseToNumber(inputBonusNumber);
        checkNumberInRange(bonusNumber);
        checkNumberDuplicate(bonusNumber, this.winnerNumbers);

        return bonusNumber;
    }

    private void checkSizeValidate(List<Integer> numbers) {
        if (numbers.size() != 6)
            throw new IllegalArgumentException("[ERROR] 당첨 번호가 6개가 아닙니다. 다시 입력하여 주세요");
    }

    private int parseToNumber(String inputNumber) {
        try {
            return Integer.parseInt(inputNumber);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다. 다시 입력하여 주세요");
        }
    }

    private void checkNumberDuplicate(int number, List<Integer> winnerNumbers) {
        if (winnerNumbers.contains(number))
            throw new IllegalArgumentException("[ERROR] 이미 로또 번호에 있는 번호 입니다. 다시 입력하여 주세요");
    }

    private void checkNumberInRange(int number) {
        if (number < 1 || number > 45)
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다. 다시 입력하여 주세요");
    }

}
