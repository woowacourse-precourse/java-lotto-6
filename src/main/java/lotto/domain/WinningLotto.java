package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class WinningLotto {
    public static final int START_RANGE = 1;
    public static final int END_RANGE = 45;
    private Lotto winningNumber;
    private Integer bonusNumber;

    public WinningLotto(String winningNumberInput, String bonusNumberInput) throws IllegalArgumentException {
        List<Integer> winningNumberList = stringInputToIntList(winningNumberInput);
        this.winningNumber = new Lotto(winningNumberList);
        int bonusParseNumber = validateNumericInput(bonusNumberInput);
        validateDuplication(winningNumberList, bonusParseNumber);
        validateBonusRange(bonusParseNumber);
        this.bonusNumber = bonusParseNumber;
    }

    private List<Integer> stringInputToIntList(String winningNumberInput) {
        String[] split = winningNumberInput.split(",");
        Integer[] integerSplit = Stream.of(split)
                                 .mapToInt(Integer::parseInt)
                                 .boxed()
                                 .toArray(Integer[]::new);
        return Arrays.asList(integerSplit);
    }

    private void validateDuplication(List<Integer> winningNumberList, int bonusNumber) {
        if (winningNumberList.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] Can't duplicate between lotto and bonus");
        }
    }

    private void validateBonusRange(int bonusNumber) {
        if (bonusNumber < START_RANGE || bonusNumber > END_RANGE) {
            throw new IllegalArgumentException("[ERROR] Lotto range is 1 ~ 45");
        }
    }

    private int validateNumericInput(String bonusNumberInput) {
        try {
            int bonusParseNumber = Integer.parseInt(bonusNumberInput);
            return bonusParseNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] Can enter only numeric type");
        }
    }

    public Lotto getWinningNumber() {
        return winningNumber;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

}
