package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;

public class LottoService {
    public Lotto createLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public Lotto createLotto(String numbers) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number: numbers.split(",")) {
            winningNumbers.add(Integer.parseInt(number));
        }
        return new Lotto(winningNumbers);
    }
}
