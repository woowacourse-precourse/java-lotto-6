package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.excpetion.LottoException;
import lotto.utils.ErrorMessage;
import lotto.utils.LottoPlace;
import lotto.utils.LottoCorrectResult;

import java.util.*;

public class Lotto {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;
    private static final int SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        sizeValidate(numbers);
        uniqueValidate(numbers);

        this.numbers = numbers;
    }

    private void sizeValidate(final List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new LottoException(ErrorMessage.NON_APPROPRIATE_LOTTO_SIZE.getErrorMessage());
        }
    }

    public static Lotto createLotto() {
        List<Integer> pickedNumbers = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(MIN_VALUE, MAX_VALUE, SIZE)
        );

        Collections.sort(pickedNumbers);
        return new Lotto(pickedNumbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public LottoPlace calLottoResult(final WinningNumbers winningNumbers, final BonusNumber bonusNumber) {

        LottoCorrectResult correctResult = countCorrectNumbers(winningNumbers);

        if (correctResult != LottoCorrectResult.FIVE) {
            return correctResult.getLottoPlace();
        }

        return calLottoPlaceWithBonusNumber(bonusNumber);
    }

    private LottoPlace calLottoPlaceWithBonusNumber(final BonusNumber bonusNumber) {
        for (int number : numbers) {
            if (bonusNumber.isBonusNumber(number)) {
                return LottoPlace.SECOND;
            }
        }

        return LottoPlace.THIRD;
    }

    private LottoCorrectResult countCorrectNumbers(final WinningNumbers winningNumbers) {
        int count = countCorrectLottoNumber(winningNumbers);

        return getLottoCompareResult(count);
    }

    private int countCorrectLottoNumber(final WinningNumbers winningNumbers) {
        int count = 0;

        for (int number : numbers) {
            if (winningNumbers.isNumberExist(new WinningNumber(number))) {
                count++;
            }
        }

        return count;
    }

    private LottoCorrectResult getLottoCompareResult(final int correctCount) {
        LottoCorrectResult lottoCorrectResult = LottoCorrectResult.NONE;

        for (LottoCorrectResult result : LottoCorrectResult.values()) {
            if (result.getMinCorrectCount() > correctCount) {
                break;
            }
            lottoCorrectResult = result;
        }

        return lottoCorrectResult;
    }

    private void uniqueValidate(final List<Integer> pickedNumbers) {
        Set<Integer> nonDuplicatedPickedNumbers = new HashSet<>(pickedNumbers);

        if (nonDuplicatedPickedNumbers.size() != SIZE) {
            throw new LottoException(ErrorMessage.DUPLICATED_LOTTO_NUMBERS.getErrorMessage());
        }
    }
}
