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

    public static void checkUserInputIsNull(String userInput) throws IllegalArgumentException {
        if(userInput.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] "+"입력이 null값입니다.");
        }
    }

    public static void checkUserInputIsOverflow(String userInput) throws IllegalArgumentException {
        if(userInput.length()>MAX_INPUT_LENGTH) {
            throw new IllegalArgumentException("[ERROR] "+"입력 기준을 초과했습니다.");
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

    public static void checkUserInputDuplicated(List<Integer> target) throws IllegalArgumentException {
        Set<Integer> nonDuplicatedTarget = new HashSet<>(target);
        if (target.size() != nonDuplicatedTarget.size()) {
            throw new IllegalArgumentException("[ERROR] 중복되는 번호가 있습니다.");
        }
    }

    public static void checkUserInputIsIntegerNOutOfRange(List<String> target) throws IllegalArgumentException {
        for (String s : target) {
            InputValidator.checkUserInputIsOverflow(s);
            InputValidator.checkUserInputIsInteger(s);
            InputValidator.checkUserInputOutOfRange(Integer.parseInt(s), MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);
        }
    }

}
