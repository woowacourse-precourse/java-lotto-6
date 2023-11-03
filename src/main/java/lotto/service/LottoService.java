package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import lotto.domain.Lotto;
import lotto.domain.WinningNumbers;

public class LottoService {
    public List<Lotto> publish(int quantity) {
        List<Lotto> publishedLotto = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(randomNumbers);
            publishedLotto.add(lotto);
        }
        return publishedLotto;
    }
    public WinningNumbers getWinningNumbers(Set<Integer> originalWinningNumbers, int bonusNumber){
        return new WinningNumbers(originalWinningNumbers, bonusNumber);
    }
}
