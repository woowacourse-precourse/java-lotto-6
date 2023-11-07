package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.common.Validation.*;
import static lotto.domain.LottoConst.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLotto(numbers);
        this.numbers = numbers;
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
