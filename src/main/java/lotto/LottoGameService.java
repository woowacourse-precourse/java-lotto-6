package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGameService {
    public LottoGameResponse buy(int money) {
        List<List<Integer>> lottos = new ArrayList<>();
        int count = money / 1000;

        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(NumberGenerator.createInRangeNumber(1, 45, 6));
            lottos.add(lotto.getNumbers());
        }

        return new LottoGameResponse(count, lottos);
    }

    public void winningNumber(String winningNumbers) {

    }

    public void calculateResult(String winningNumbers, int bonusNumber) {

    }
}
