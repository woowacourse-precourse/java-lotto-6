package lotto.model.vo;

import java.util.Arrays;
import java.util.List;

public class WinNumber {

    private static final String SPLIT_CHARACTER = ",";

    private List<Integer> winNumber;

    private WinNumber(List<Integer> winNumber) {
        has6Numbers(winNumber);
        isBetween1And45(winNumber);
        this.winNumber = winNumber;
    }

    public static WinNumber of(String winNumber) {
        return new WinNumber(Arrays.stream(winNumber.split(SPLIT_CHARACTER))
                .map(Integer::parseInt)
                .toList());
    }

    private void has6Numbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("6개의 수를 입력해야 합니다.");
        }
    }

    private void isBetween1And45(List<Integer> numbers) {
        if (!numbers.stream().allMatch((num) -> num >= 1 && num <= 45)) {
            throw new IllegalArgumentException("1부터 45 사이의 수를 입력해야 합니다.");
        }
    }

    public List<Integer> getWinNumber() {
        return winNumber;
    }
}
