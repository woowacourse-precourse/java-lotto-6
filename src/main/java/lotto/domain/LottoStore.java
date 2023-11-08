package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoStore {
    private static final int COUNT = 6;
    private final List<Lotto> lottoes = new ArrayList<>();

    public LottoStore(int totalLottoNumber) {
        publishLottoes(totalLottoNumber);
    }

    public List<Lotto> getLottoes() {
        return this.lottoes;
    }

    private Lotto publishLotto() {
        return new Lotto(Collections.unmodifiableList(generateRandomNumbers()));
    }

    private List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                LottoNumberRange.MIN.getValue(), LottoNumberRange.MAX.getValue(), COUNT);
    }

    private void publishLottoes(int totalLottoes) {
        for (int i = 0; i < totalLottoes; i++) {
            this.lottoes.add(publishLotto());
        }
    }
}