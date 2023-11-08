package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.utils.ErrorMessage;
import lotto.utils.LottoPlace;
import lotto.utils.LottoResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;
    private static final int SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        sizeValidate(numbers);
        uniqueValidate(numbers);

        this.numbers = numbers;
    }

    private void sizeValidate(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public static Lotto createLotto() {
        List<Integer> pickedNumbers = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(MIN_VALUE, MAX_VALUE, SIZE)
        );

        Collections.sort(pickedNumbers);
        return new Lotto(pickedNumbers);
    }

    public String getLottoNumbers() {
        return numbers.toString();
    }

    public LottoPlace calLottoResult(WinningNumbers winningNumbers, BonusNumber bonusNumber) {

        LottoResult correctResult = countCorrectNumbers(winningNumbers);

        if (correctResult != LottoResult.FIVE) {
            return correctResult.getLottoPlace();
        }

        return calLottoPlaceWithBonusNumber(bonusNumber);
    }

    private LottoPlace calLottoPlaceWithBonusNumber(BonusNumber bonusNumber) {
        for (int number : numbers) {
            if (bonusNumber.isBonusNumber(number)) {
                return LottoPlace.SECOND;
            }
        }

        //todo: 수정 필요 -> THIRD
        return LottoPlace.SECOND;
    }

    private LottoResult countCorrectNumbers(WinningNumbers winningNumbers) {
        int count = countCorrectLottoNumber(winningNumbers);

        return getLottoCompareResult(count);
    }

    private int countCorrectLottoNumber(WinningNumbers winningNumbers) {
        int count = 0;

        for (int number : numbers) {
            if (winningNumbers.isNumberExist(new WinningNumber(number))) {
                count++;
            }
        }

        return count;
    }

    private LottoResult getLottoCompareResult(final int correctCount) {
        LottoResult lottoResult = LottoResult.NONE;

        for (LottoResult result : LottoResult.values()) {
            if (result.getMinCorrectCount() > correctCount) {
                break;
            }
            lottoResult = result;
        }

        return lottoResult;
    }

    private static void uniqueValidate(List<Integer> pickedNumbers) {
        boolean[] alreadyChecked = new boolean[MAX_VALUE + 1];

        for (int number : pickedNumbers) {
            if (alreadyChecked[number]) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATED_VALUES.getErrorMessage());
            }

            alreadyChecked[number] = true;
        }
    }
}
