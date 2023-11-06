package lotto.view;

import java.util.Arrays;
import java.util.List;

public class InputValidator {

    private static final String DELIMITER = ",";
    private static final String NUMERIC_PATTERN = "\\d+";

    public List<String> toStringList(String userInput) {
        return Arrays.stream(userInput.split(DELIMITER))
                .map(String::trim)
                .toList();
    }

    public List<Integer> toIntegerList(List<String> userList) {
        return userList.stream()
                .map(Integer::parseInt)
                .toList();
    }

    public void validateDigit(List<String> list) {
        boolean isDigit = list.stream().allMatch(s -> s.matches(NUMERIC_PATTERN));
        if (!isDigit) {
            throw new IllegalArgumentException("로또 번호는 1~45 숫자만 입력 가능합니다.");
        }
    }

    public int toInt(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다! ");
        }
    }
}
