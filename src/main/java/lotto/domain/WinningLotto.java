package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
    public static final Integer LOTTO_LOWER_LIMIT = 1;
    public static final Integer LOTTO_UPPER_LIMIT = 45;
    public static final String NUMBERS_EXCEPTION_MSG = "[ERROR] 당첨 번호가 정수가 아닙니다.";
    public static final String BONUS_EXCEPTION_MSG = "[ERROR] 보너스 번호가 이상합니노 ㅋㅋ.";
    public Lotto winningLotto;
    public Integer bonusNumber;

    public WinningLotto(String numbers, String bonus) {
        winningLotto = new Lotto(sliceNumbers(numbers));
        bonusNumber = getValidBonusNumber(bonus);
    }

    public boolean isEqualToBonusNumber(int number) {
        return bonusNumber == number;
    }

    private List<Integer> sliceNumbers(String numbers) {
        List<String> temp = Arrays.stream(numbers.split(",", -1)).toList();

        List<Integer> validNumbers;
        try {
            validNumbers = temp.stream()
                    .map(number -> Integer.parseInt(number)).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBERS_EXCEPTION_MSG);
        }

        return validNumbers;
    }

    private Integer getValidBonusNumber(String bonus) {
        Integer bonusNumber;
        try {
            bonusNumber = Integer.valueOf(bonus);
            checkRange(bonusNumber);
            checkUnique(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BONUS_EXCEPTION_MSG);
        }
        return bonusNumber;
    }

    private void checkRange(Integer bonusNumber) {
        if (bonusNumber < LOTTO_LOWER_LIMIT || bonusNumber > LOTTO_UPPER_LIMIT) {
            throw new IllegalArgumentException(BONUS_EXCEPTION_MSG);
        }
    }

    private void checkUnique(Integer bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_EXCEPTION_MSG);
        }
    }
}
