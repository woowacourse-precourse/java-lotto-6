package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class WinningLotto {
    private Lotto winningNumber;
    private Integer bonusNumber;

    public WinningLotto(String winningNumberInput, String bonusNumberInput) {
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
            throw new IllegalArgumentException("로또 번호와 보너스 번호는 중복될 수 없습니다.");
        }
    }

    private void validateBonusRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("로또 번호는 1 ~ 45 사이의 번호만 입력 가능합니다.");
        }
    }

    private int validateNumericInput(String bonusNumberInput) {
        try {
            int bonusParseNumber = Integer.parseInt(bonusNumberInput);
            return bonusParseNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또 번호는 숫자만 입력이 가능합니다.");
        }
    }

}
