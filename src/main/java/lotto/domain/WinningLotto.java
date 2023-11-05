package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
    public static final Integer LOTTO_LOWER_LIMIT = 1;
    public static final Integer LOTTO_UPPER_LIMIT = 45;
    public static final String NUMBERS_EXCEPTION_MSG = "[ERROR] 당첨 번호가 정수가 아닙니다.";
    public static final String BONUS_NOT_UNIQUE_EXCEPTION_MSG = "[ERROR] 보너스 번호가 당첨번호와 겹칩니다.";
    public static final String BONUS_RANGE_EXCEPTION_MSG = "[ERROR] 보너스 번호는 1이상 45이하의 정수이어야 합니다.";
    public static final String BONUS_NAN_EXCEPTION_MSG = "[ERROR] 보너스 번호가 정수이어야 합니다.";
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
            throw new IllegalArgumentException(BONUS_NAN_EXCEPTION_MSG);
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
            throw new IllegalArgumentException(NUMBERS_EXCEPTION_MSG);
        }

        return validNumbers;
    }

    private static void checkRange(Integer bonusNumber) {
        if (bonusNumber < LOTTO_LOWER_LIMIT || bonusNumber > LOTTO_UPPER_LIMIT) {
            throw new IllegalArgumentException(BONUS_RANGE_EXCEPTION_MSG);
        }
    }

    private static void checkUnique(Integer bonusNumber, Lotto winningLotto) {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NOT_UNIQUE_EXCEPTION_MSG);
        }
    }
}
