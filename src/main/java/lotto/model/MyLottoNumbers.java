package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MyLottoNumbers {
    private static final int MIN_IN_RANGE = 1;
    private static final int MAX_IN_RANGE = 45;
    private static final int EXACT_SIZE = 6;
    private static final int UNIQUE_NUMBER = 1;
    private List<Integer> myNumbers;
    private int bonusNumber;

    public MyLottoNumbers(String input) {
        List<Integer> beForeCheck;
        beForeCheck = validateNumber(validateSplit(input));
        validateSize(beForeCheck);
        myNumbers = validateUnique(beForeCheck);
    }

    public void setBonusNumber(String bonusInput) {
        try {
            this.bonusNumber = validateRange(Integer.parseInt(bonusInput));
            validateUniqueBonus(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    public List<Integer> getMyNumbers() {
        return myNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private List<String> validateSplit(String input) {
        try {
            return Arrays.asList(input.split(","));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 형식의 입력입니다.");
        }
    }

    private List<Integer> validateNumber(List<String> splitInput) {
        try {
            List<Integer> splitInputNumbers = new ArrayList<>();
            for (String number : splitInput) {
                splitInputNumbers.add(validateRange(Integer.parseInt(number)));
            }
            return splitInputNumbers;
            } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자들만 입력 가능합니다.");
        }
    }

    private int validateRange(int number) {
        if (number < MIN_IN_RANGE || number > MAX_IN_RANGE) {
            throw new IllegalArgumentException("[ERROR] 1~45의 숫자들만 입력 가능합니다.");
        }
        return number;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != EXACT_SIZE) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자로 구성되어야 합니다.");
        }
    }

    private List<Integer> validateUnique(List<Integer> numbers) {
        for (int n : numbers) {
            if (Collections.frequency(numbers,n)!=UNIQUE_NUMBER){
                throw new IllegalArgumentException("[ERROR] 중복된 숫자가 존재합니다.");
            }
        }
        return numbers;
    }
    
    private void validateUniqueBonus(int bonus) {
        if (myNumbers.contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 입력하신 보너스 숫자가 이미 존재합니다");
        }
    }
}
