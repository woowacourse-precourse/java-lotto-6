package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    public static final long FIRST_PRIZE_AMOUNT = 2000000000L; // 1등 상금 (예: 20억 원)
    public static final long SECOND_PRIZE_AMOUNT = 30000000L;  // 2등 상금 (예: 3천만 원)
    public static final long THIRD_PRIZE_AMOUNT = 1500000L;    // 3등 상금 (예: 150만 원)
    public static final long FOURTH_PRIZE_AMOUNT = 50000L;     // 4등 상금 (예: 5만 원)
    public static final long FIFTH_PRIZE_AMOUNT = 5000L;       // 5등 상금 (예: 5천 원)

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public long LottoResults(List<Integer> winningNumber, int bonusNumber) {
        List<Integer> tempWinningNumber = new ArrayList<>(winningNumber);
        tempWinningNumber.retainAll(numbers);
        int matchedNumbers = tempWinningNumber.size();
        if (matchedNumbers == 3) {
            return  FIFTH_PRIZE_AMOUNT;
        }
        if (matchedNumbers == 4) {
            return FOURTH_PRIZE_AMOUNT;
        }
        if (matchedNumbers == 5 && numbers.contains(bonusNumber)) {
            return THIRD_PRIZE_AMOUNT;
        }
        if (matchedNumbers == 5) {
            return SECOND_PRIZE_AMOUNT;
        }
        if (matchedNumbers == 6) {
            return FIRST_PRIZE_AMOUNT;
        }
        return 0;
    }

}
