package lotto.Utils;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public int StringToInteger(String bonusNumbers) {
        try {
            return Integer.parseInt(bonusNumbers);
        } catch (NumberFormatException e) {
            System.err.println("입력된 문자를 정수로 변환할 수 없습니다: " + bonusNumbers);
            throw new IllegalArgumentException();
        }
    }
    public List<Integer> StringToIntegerList(String UserInput) {
        List<Integer> winningNumbers = new ArrayList<>();
        String[] userInput = UserInput.split(",");
        for (String number : userInput) {
            String trimmedNumber = number.trim();
            if (!trimmedNumber.isEmpty()) {
                winningNumbers.add(Integer.parseInt(trimmedNumber));
            }
        }
        return winningNumbers;
    }
}
