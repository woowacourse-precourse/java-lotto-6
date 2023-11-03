package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Player {
    private static final int START_NUM_RANGE = 1;
    private static final int END_NUM_RANGE = 45;
    private static final int LOTTO_NUM_COUNT = 6;
    private static LottoAmount lottoAmount;
    private static LottoCount lottoCount;
    private static List<Lotto> lottos = new ArrayList<>();

    public void createLotto() {
        IntStream.rangeClosed(1, lottoCount.getLottoCount())
                .forEach(e -> lottos.add(
                        new Lotto(
                                Randoms.pickUniqueNumbersInRange(START_NUM_RANGE, END_NUM_RANGE, LOTTO_NUM_COUNT))));
    }

    public void setLottoAmount(LottoAmount lottoAmount) {
        this.lottoAmount = lottoAmount;
    }

    public void setLottoCount() {
        this.lottoCount = new LottoCount(lottoAmount.getLottoAmount());
    }

    public int getLottoCount() {
        return lottoCount.getLottoCount();
    }
}
