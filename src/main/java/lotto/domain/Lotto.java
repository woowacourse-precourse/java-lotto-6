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

    public LottoPlace calLottoResult(WinningManager winningManager) {

        LottoResult correctResult = countCorrectNumbers(winningManager.getWinningNumbers());

        if (correctResult != LottoResult.FIVE) {
            return correctResult.getLottoPlace();
        }

        return calLottoPlaceWithBonusNumber(winningManager.getBonusNumber());
    }

    private LottoPlace calLottoPlaceWithBonusNumber(WinningNumber bonusNumber) {
        for (int number : numbers) {
            if (bonusNumber.isNumberExist(number)) {
                return LottoPlace.SECOND;
            }
        }

        return LottoPlace.SECOND;
    }

    private LottoResult countCorrectNumbers(WinningNumbers winningNumbers) {
        int count = 0;

        for (int number : numbers) {
            if (winningNumbers.isNumberExist(new WinningNumber(number))) {
                count++;
            }
        }

        LottoResult correctCount = LottoResult.NONE;

        for (LottoResult result : LottoResult.values()) {
            if (result.getMinCorrectCount() > count) {
                break;
            }

            correctCount = result;
        }

        return correctCount;
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
