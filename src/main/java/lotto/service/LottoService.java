package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;

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
}
