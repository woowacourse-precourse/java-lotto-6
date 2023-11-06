package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static lotto.domain.LottoConst.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {

        try {
            if (numbers.size() != 6) {
                throw new IllegalArgumentException();
            }
            for (int num : numbers) {
                if (num < LOTTO_MIN_NUM || num > LOTTO_MAX_NUM)
                    throw new IllegalArgumentException(NOT_INPUT_NUM_IN_RANGE);
            }

            HashSet<Integer> set = new HashSet<>();
            for (int j = 0; j < numbers.size(); j++) {
                if (set.contains(numbers.get(j))) {
                    throw new IllegalArgumentException(DUPLICATE_NUMS);
                }
                set.add(numbers.get(j));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INPUT_WINNING_NUMS_NUMBER);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public static List<Lotto> createMyLottos(int buyCount) {
        List<Lotto> myLottos = new ArrayList<>();
        for (int i = 0; i < buyCount; i++) {
            List<Integer> randomList = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUM, LOTTO_MAX_NUM, LOTTO_SIZE);
            Lotto lotto = new Lotto(randomList);
            myLottos.add(lotto);
        }
        return myLottos;
    }

    public int getMatchCount(WinningNumbers winningNumbers) {
        int matchCount = 0;
        for (int num : numbers) {
            if (winningNumbers.getWinningNums().contains(num)) matchCount++;
        }
        return matchCount;
    }

    public boolean isBonusMatch(WinningNumbers winningNumbers) {
        return numbers.contains(winningNumbers.getBonusNum());
    }
}
