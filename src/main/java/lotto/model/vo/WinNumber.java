package lotto.model.vo;

import java.util.Arrays;
import java.util.List;

public class WinNumber {

    private static final String SPLIT_CHARACTER = ",";

    private List<Integer> winNumber;

    private WinNumber(List<Integer> winNumber) {
        this.winNumber = winNumber;
    }

    public static WinNumber of(String winNumber) {
        return new WinNumber(Arrays.stream(winNumber.split(SPLIT_CHARACTER))
                .map(Integer::parseInt)
                .toList());
    }

    public List<Integer> getWinNumber() {
        return winNumber;
    }
}
