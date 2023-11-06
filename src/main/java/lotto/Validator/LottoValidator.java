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
                throw new IllegalArgumentException("로또 당첨 번호의 범위는 1~45 입니다.");
            }
        }

        if(winningLottoNumbers.size() != 6) {
            throw new IllegalArgumentException("로또 당첨 번호는 숫자 6개를 입력해야 합니다.");
        }

        if(hasDuplicateNumbers(winningLottoNumbers)) {
            throw new IllegalArgumentException("로또 당첨 번호에는 중복된 숫자가 없어야 합니다.");
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
}
