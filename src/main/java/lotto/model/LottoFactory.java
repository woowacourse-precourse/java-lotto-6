package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {
    public Lottos createLottos(int numberOfLotto) {
        List<Lotto> lottos = new ArrayList<>();
        for (int lottoIdx = 0; lottoIdx < numberOfLotto; lottoIdx++) {
            lottos.add(createLotto());
        }
        return Lottos.create(lottos);
    }

    private Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    public WinningLotto createWinningLotto(List<Integer> numbers, Integer bonusNumber) {
        return WinningLotto.create(numbers, bonusNumber);
    }
}
