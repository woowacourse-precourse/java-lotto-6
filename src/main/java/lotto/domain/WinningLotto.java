package lotto.domain;

import static lotto.domain.ErrorMessages.NOT_INTEGER;
import static lotto.domain.ErrorMessages.NOT_UNIQUE;
import static lotto.domain.ErrorMessages.RANGE_NUMBER;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
    public static final Integer LOTTO_LOWER_LIMIT = 1;
    public static final Integer LOTTO_UPPER_LIMIT = 45;
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
        if (bonusNumber < LOTTO_LOWER_LIMIT || bonusNumber > LOTTO_UPPER_LIMIT) {
            throw new IllegalArgumentException(RANGE_NUMBER.getMessage());
        }
    }

    private static void checkUnique(Integer bonusNumber, Lotto winningLotto) {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(NOT_UNIQUE.getMessage());
        }
    }
}
