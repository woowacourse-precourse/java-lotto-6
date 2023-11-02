package lotto.utility;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Utility {
    public int parseInt(String input) {
        try {
            int number = Integer.parseInt(input);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 정수가 아닙니다");
        }
    }

    public List<Integer> getRandomNumbers(int length) {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, length);
        return numbers;
    }

    public String[] splitInput (String input) {
        String[] numbers = input.split(",");
        return numbers;
    }


}
