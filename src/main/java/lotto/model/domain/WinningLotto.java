package lotto.model.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.InputValidator;

public class WinningLotto implements InputValidator {

    private List<Integer> numbers;
    private Bonus bonusNumber; //TODO: bonus 제거해야함

    @Override
    public boolean getInputUntilValid() {
        return numbers == null;
    }

    public void setWinningNumber(String numbers) {
        List<String> inputDividedByComma = validateDelimiterComma(numbers);
        validateSixElements(inputDividedByComma);
        List<Integer> integerNumbers = validateWinningNumberIsNumeric(inputDividedByComma);
        validateNumberBetweenInRange(integerNumbers, 1, 45);
        this.numbers = integerNumbers;
    }

    public void addBonus(Bonus bonus) {
        this.bonusNumber = bonus;
    }

    public List<String> validateDelimiterComma(String numbers) {
        if (!numbers.matches(".*,.*")) {
            throw new IllegalArgumentException("[ERROR] 쉼표로 구분하여 입력해주세요.");
        }
        return List.of(numbers.split(","));
    }

    public void validateSixElements(List<String> numbers) {
        Set<String> set = new HashSet<>(numbers);
        if(set.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 서로 다른 6개의 당첨 번호를 입력해주세요.");
        }
    }

    public List<Integer> validateWinningNumberIsNumeric(List<String> numbers) {
        List<Integer> integerNumbers = new ArrayList<>();
        for (String number : numbers) {
            try {
                int numberToInteger = Integer.parseInt(number);
                integerNumbers.add(numberToInteger);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
            }
        }
        return integerNumbers;
    }

    private void validateNumberBetweenInRange(List<Integer> integerNumbers, int min, int max) {
        for(int number : integerNumbers) {
            if (number < min || number > max) {
                throw new IllegalArgumentException("[ERROR] 1에서 45사이의 숫자로 입력해주세요.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public int getBonusNumber() {
        return bonusNumber.getNumber();
    }

}
