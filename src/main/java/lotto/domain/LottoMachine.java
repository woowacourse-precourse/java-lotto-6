package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.config.LottoConfig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoMachine {
    private final List<Lotto> lottos;

    LottoMachine(int money) {
        lottos = new ArrayList<>();
        setLottos(getLottosCount(money));
    }

    public int getLottosCount(int money) {
        return money / LottoConfig.LOTTO_UNIT_PRICE.getNumber();
    }

    private void setLottos(int lottosCount) {
        IntStream.rangeClosed(1, lottosCount)
                .forEach(i -> lottos.add(getLotto()));
    }

    private Lotto getLotto() {
        List<Integer> lottoNumbers = new ArrayList<>(generateLottoNumbers());
        try {
            Collections.sort(lottoNumbers);
            return new Lotto(lottoNumbers);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return getLotto();
        }
    }

    private List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                LottoConfig.LOTTO_NUMBER_MIN.getNumber(),
                LottoConfig.LOTTO_NUMBER_MAX.getNumber(),
                LottoConfig.LOTTO_NUMBER_COUNT.getNumber()
        );
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}