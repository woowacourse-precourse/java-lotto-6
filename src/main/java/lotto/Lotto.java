package lotto;

import static lotto.constant.Constant.LOTTO_CNT;
import static lotto.constant.Constant.LOTTO_MAX_VALUE;
import static lotto.constant.Constant.LOTTO_MIN_VALUE;
import static lotto.error.ErrorMessage.DUPLICATED_LOTTO_NUMBER;
import static lotto.error.ErrorMessage.NOT_RIGHT_SIZE_LOTTO_NUMBER;
import static lotto.error.ErrorMessage.OVER_RANGE_LOTTO_NUMBER;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {

        if (!isRightSize(numbers.size())) {
            throw new IllegalArgumentException(NOT_RIGHT_SIZE_LOTTO_NUMBER.getMessage());
        }

        if (!isExistDuplicateNumber(numbers)) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBER.getMessage());
        }

        if (!isInRangeLottoNumbers(numbers)) {
            throw new IllegalArgumentException(OVER_RANGE_LOTTO_NUMBER.getMessage());
        }
    }

    private boolean isRightSize(int size) {
        return size == LOTTO_CNT;
    }

    private boolean isExistDuplicateNumber(List<Integer> numbers) {

        Set<Integer> setForDuplication = new HashSet<>();
        for (int number : numbers) {
            if (setForDuplication.contains(number)) {
                return false;
            }
            setForDuplication.add(number);
        }
        return true;
    }

    private boolean isInRangeLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(number -> number >= LOTTO_MIN_VALUE && number <= LOTTO_MAX_VALUE);
    }

    public String getNumbersStringBySortedAsc() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);

        return "[" + sortedNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")) + "]";
    }

    public void setWinnerLottoNumbers(Set<Integer> winnerLottoNumbers) {
        winnerLottoNumbers.addAll(numbers);
    }

    public WinnerRating judgeWinner(Set<Integer> winnerLottoNumbers, int bonusNumber) {
        int correctCnt = 0;
        boolean isContainBonusNumber = false;
        for (int number : numbers) {
            if (winnerLottoNumbers.contains(number)) {
                correctCnt++;
            }
            if (number == bonusNumber) {
                isContainBonusNumber = true;
            }
        }

        return calculateRating(correctCnt, isContainBonusNumber);
    }

    private WinnerRating calculateRating(int correctCnt, boolean isContainBonusNumber) {
        if (correctCnt == 3) {
            return WinnerRating.FIFTH;
        } else if (correctCnt == 4) {
            return WinnerRating.FOURTH;
        } else if (correctCnt == 5) {
            if (isContainBonusNumber) {
                return WinnerRating.SECOND;
            }
            return WinnerRating.THIRD;
        } else if (correctCnt == 6) {
            return WinnerRating.FIRST;
        }
        return WinnerRating.NO_LUCK;
    }

    public static Lotto issueLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }
}
