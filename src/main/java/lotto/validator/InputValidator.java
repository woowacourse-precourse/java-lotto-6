package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.model.Constants.*;

public class InputValidator {
    public static void checkUserInputIsInteger(String userInput) throws IllegalArgumentException {
        if(!userInput.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("[ERROR] "+"숫자만 입력해주세요.");
        }
    }

    public static void checkUserInputIsDivided(Integer userInput, Integer divided) throws IllegalArgumentException {
        if (userInput % divided != 0) {
            throw new IllegalArgumentException("[ERROR] "+divided+"으로 나누어 떨어지지 않습니다.");
        }
    }

    public static void checkUserInputOutOfRange(Integer userInput, Integer minRange, Integer maxRange) throws IllegalArgumentException {
        if (userInput < minRange || userInput > maxRange) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 "+minRange+"부터 "+maxRange+" 사이의 숫자여야 합니다.");
        }
    }

    public static void checkUserInputDuplicated(List<Integer> targetList) throws IllegalArgumentException {
        Set<Integer> targetSet = new HashSet<>(targetList);
        if (targetList.size() != targetSet.size()) {
            throw new IllegalArgumentException("[ERROR] 중복되는 번호가 있습니다.");
        }
    }

    public static void checkUserInputIsIntegerNOutOfRange(List<String> targetList) throws IllegalArgumentException {
        for (String s : targetList) {
            InputValidator.checkUserInputIsInteger(s);
            InputValidator.checkUserInputOutOfRange(Integer.parseInt(s), MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);
        }
    }

}
