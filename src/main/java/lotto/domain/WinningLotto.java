package lotto.domain;

import static lotto.domain.constant.ErrorMessages.NOT_INTEGER;
import static lotto.domain.constant.ErrorMessages.NOT_UNIQUE;
import static lotto.domain.constant.ErrorMessages.RANGE_NUMBER;
import static lotto.domain.constant.Range.LOTTO_NUMBER_LOWER_LIMIT;
import static lotto.domain.constant.Range.LOTTO_NUMBER_UPPER_LIMIT;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
    public Lotto winningLotto;
    public Integer bonusNumber;

    public WinningLotto(Lotto winningLotto, Integer bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public WinningLotto(String winningLotto, String bonusNumber) {
        this.winningLotto = getValidLottoNumbers(winningLotto);
        this.bonusNumber = getValidBonusNumber(bonusNumber, this.winningLotto);
    }

    public static Lotto getValidLottoNumbers(String numbers) {
        return new Lotto(sliceNumbers(numbers));
    }

    public static Integer getValidBonusNumber(String bonus, Lotto winningLotto) {
        Integer bonusNumber;
        try {
            bonusNumber = Integer.valueOf(bonus);
            checkRange(bonusNumber);
            checkUnique(bonusNumber, winningLotto);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER.getMessage());
        }
        return bonusNumber;
    }


    private static List<Integer> sliceNumbers(String numbers) {
        List<String> temp = Arrays.stream(numbers.split(",", -1)).toList();

        List<Integer> validNumbers;
        try {
            validNumbers = temp.stream()
                    .map(number -> Integer.parseInt(number)).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER.getMessage());
        }

        return validNumbers;
    }

    private static void checkRange(Integer bonusNumber) {
        if (bonusNumber < LOTTO_NUMBER_LOWER_LIMIT.getLimit()
                || bonusNumber > LOTTO_NUMBER_UPPER_LIMIT.getLimit()) {
            throw new IllegalArgumentException(RANGE_NUMBER.getMessage());
        }
    }

    private static void checkUnique(Integer bonusNumber, Lotto winningLotto) {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(NOT_UNIQUE.getMessage());
        }
    }
}
