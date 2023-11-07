package lotto.Validator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator {
    public static void isValidPurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void isValidWinningLottoNumbers(List<Integer> winningLottoNumbers) {
        for (Integer number : winningLottoNumbers) {
            if(number < 1 || number > 45) {
                throw new IllegalArgumentException();
            }
        }

        if(winningLottoNumbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        if(hasDuplicateNumbers(winningLottoNumbers)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean hasDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>();

        for (int number : numbers) {
            if (numberSet.contains(number)) {
                return true;
            }
            numberSet.add(number);
        }
        return false;
    }

    public static void validateDuplicateWinningAndBonusNumbers(List<Integer> winningLottoNumbers, int bonusLottoNumber) {
        if (winningLottoNumbers.contains(bonusLottoNumber)) {
            throw new IllegalArgumentException();
        }
    }
}
