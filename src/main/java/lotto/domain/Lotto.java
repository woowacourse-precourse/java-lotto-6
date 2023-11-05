package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        HashSet<Integer> set = new HashSet<>();
        for (int j = 0; j < numbers.size(); j++) {
            if (set.contains(numbers.get(j))) {
                throw new IllegalArgumentException("중복 숫자 예외");
            }
            set.add(numbers.get(j));
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }

    public static List<Lotto> createMyLottos(int buyCount) {
        List<Lotto> myLottos = new ArrayList<>();
        for (int i = 0; i < buyCount; i++) {
            List<Integer> randomList = Randoms.pickUniqueNumbersInRange(1, 45, 6);
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
