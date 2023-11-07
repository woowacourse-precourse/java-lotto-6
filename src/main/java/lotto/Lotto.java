package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Exception.validateLottoNumbers(numbers);
        this.numbers = numbers;
    }

    public String lottoPrintFormat() {
        StringBuilder result = new StringBuilder();
        for (Integer number : numbers) {
            if (!result.isEmpty()) {
                result.append(", ");
            }
            result.append(number);
        }
        return "[" + result.toString() + "]";
    }

    public Integer compareWithWinNumbers(List<Integer> winNumbers, Integer bonusNumber) {
        int label = 0;

        for (Integer winNumber : winNumbers) {
            if (numbers.contains(winNumber)) {
                label++;
            }
        }
        if (label == 5) {
            if (numbers.contains(bonusNumber)) {
                label = 7;
            }
        }

        return label;
    }


}
