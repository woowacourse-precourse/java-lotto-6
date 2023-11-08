package lotto;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private static final int LOTTO_NUMBER_MINIMUM = 1;
    private static final int LOTTO_NUMBER_MAXIMUM = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public List<Lotto> makeLottoNumbers(Integer quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < quantity; i++){
            Lotto lotto = makeLotto();
            lottos.add(lotto);
        }
        return lottos;
    }

    public Lotto makeLotto() {
        List<Integer> randomNumbers = pickUniqueNumbersInRange(LOTTO_NUMBER_MINIMUM, LOTTO_NUMBER_MAXIMUM, LOTTO_NUMBER_COUNT);
        Lotto lotto = new Lotto(randomNumbers);
        return lotto;
    }

    public WinningLotto getWinningLotto(List<Integer> winningNumbers, Integer bonus) {
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonus);
        return winningLotto;
    }
}
