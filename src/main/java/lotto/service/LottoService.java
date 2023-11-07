package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Prize;

public class LottoService {
    public static Lotto createLotto() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < 6) {
            int pickedNumber = Randoms.pickNumberInRange(1, 45);
            if (!numbers.contains(pickedNumber)) {
                numbers.add(pickedNumber);
            }
        }
        return new Lotto(numbers);
    }

    public static Prize getResult(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        if (lotto.match(winningNumbers) == 6) {
            return Prize.FIRST;
        }
        if (lotto.match(winningNumbers) == 5 && lotto.match(bonusNumber)) {
            return Prize.SECOND;
        }
        if (lotto.match(winningNumbers) == 5) {
            return Prize.THIRD;
        }
        if (lotto.match(winningNumbers) == 4) {
            return Prize.FOURTH;
        }
        if (lotto.match(winningNumbers) == 3) {
            return Prize.FIFTH;
        }
        return Prize.None;
    }
}
