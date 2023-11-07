package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;

public class LottoService {
    private int lottoCount;
    private List<Lotto> lottos;
    private WinningLotto winningLotto;

    public int getLottoCount() {
        return lottoCount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void setLottos(int purchasePrice) {
        lottoCount = calculateLottoCount(purchasePrice);
        lottos = generateLottos(lottoCount);
    }

    public WinningLotto getWinningLotto() {
        return winningLotto;
    }

    public void setWinningLotto(Lotto lotto, int bonusNumber) {
        winningLotto = new WinningLotto(lotto, bonusNumber);
    }

    private List<Lotto> generateLottos(int lottoCount) {
        return IntStream.range(0, lottoCount)
                .mapToObj(i -> generateLotto())
                .toList();
    }

    private Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Lotto.LOTTO_NUMBER_MIN, Lotto.LOTTO_NUMBER_MAX,
                Lotto.LOTTO_NUMBERS_COUNT);
        return new Lotto(numbers);
    }

    private int calculateLottoCount(int purchasePrice) {
        return purchasePrice / Lotto.LOTTO_PRICE_UNIT;
    }

}
